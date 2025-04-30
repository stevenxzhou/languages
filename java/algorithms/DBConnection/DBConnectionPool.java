package algorithms.DBConnection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBConnectionPool {
    private int maxSize;
    private Queue<DBConnection> availableConnections;
    private Set<DBConnection> inUseConnections;
    private Lock lock;
    private Condition condition;
    private boolean isPoolClosed;

    public DBConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.availableConnections = new LinkedList<>();
        this.inUseConnections = new HashSet<>();
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.isPoolClosed = false;
        
        // 初始化连接池
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxSize; i++) {
            DBConnection conn = createConnection();
            availableConnections.offer(conn);
        }
    }

    private DBConnection createConnection() {
        DBConnection conn = new DBConnection();
        conn.open();
        return conn;
    }

    public DBConnection acquire() throws InterruptedException {
        lock.lock();
        try {
            while (availableConnections.isEmpty() && !isPoolClosed) {
                // 等待可用连接
                condition.await();
            }

            if (isPoolClosed) {
                throw new IllegalStateException("Connection pool is closed");
            }

            DBConnection conn = availableConnections.poll();
            inUseConnections.add(conn);
            return conn;
        } finally {
            lock.unlock();
        }
    }

    public void release(DBConnection conn, boolean needsRebuild) {
        lock.lock();
        try {
            if (!inUseConnections.remove(conn)) {
                throw new IllegalStateException("Connection not in use");
            }

            if (needsRebuild || !conn.isValid()) {
                // 关闭旧连接并创建新连接
                conn.close();
                conn = createConnection();
            }

            availableConnections.offer(conn);
            condition.signal(); // 通知等待的线程有新的连接可用
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        lock.lock();
        try {
            isPoolClosed = true;
            
            // 关闭所有可用连接
            for (DBConnection conn : availableConnections) {
                conn.close();
            }
            availableConnections.clear();

            // 关闭所有使用中的连接
            for (DBConnection conn : inUseConnections) {
                conn.close();
            }
            inUseConnections.clear();

            // 唤醒所有等待的线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
