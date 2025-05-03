package algorithms.DBConnection;
import algorithms.DBConnection.DBConnectionPool;

public class DBConnectionTest {
    public static void main(String[] args) {
        DBConnectionPool pool = new DBConnectionPool(5);
        
        try {
            // 获取连接
            DBConnection conn = pool.acquire();
            
            try {
                // 使用连接
                conn.runCommand("SELECT * FROM users");
                
                // 释放连接，并标记需要重建
                pool.release(conn, true);
            } catch (Exception e) {
                // 处理异常
                pool.release(conn, true);
            }
        } catch (InterruptedException e) {
            // 处理中断异常
        } finally {
            // 关闭连接池
            pool.close();
        }
    }
}
