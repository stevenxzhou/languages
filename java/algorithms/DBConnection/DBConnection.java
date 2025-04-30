package algorithms.DBConnection;

public class DBConnection {
    private boolean isValid = true;

    public void open() {
        // 初始化连接
    }

    public void runCommand(String command) {
        // 执行命令
    }

    public void close() {
        // 关闭连接
    }

    public boolean isValid() {
        return isValid;
    }

    public void invalidate() {
        isValid = false;
    }
}
