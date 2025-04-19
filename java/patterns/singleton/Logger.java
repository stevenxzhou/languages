package patterns.singleton;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Logger {
    class Message {
        public Date timestamp;
        public String content; 
        public Message (String content) {
            this.timestamp = new Date();
            this.content = content;
        }
    }

    private static Logger logger;

    public static synchronized Logger getInstance() {
        String callerClassName = getCallerClassName();
        System.out.println("getInstance() called by: " + callerClassName);
        
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
            System.out.println("First time createdd");
            return logger;
        }

        return logger;
    }

    private static String getCallerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // stackTrace[0] = getStackTrace()
        // stackTrace[1] = getCallerClassName()
        // stackTrace[2] = getInstance()
        // stackTrace[3] = actual caller

        if (stackTrace.length >= 4) {
            return stackTrace[3].getClassName();
        } else {
            return "Unknown";
        }
    }

    private Queue<Message> messages;
    private static final int MAX_CAPACITY = 10;
    
    public Logger() {
        this.messages = new LinkedList<Message>();
    }

    public void Log(String content) {
        if (this.messages.size() > MAX_CAPACITY) {
            this.messages.poll();
        }

        Message msg = new Message(content);
        this.messages.add(msg);
    }

    public synchronized void getLastMessages() {
        Queue<Message> copyMessages = new LinkedList<>(this.messages);
        while (copyMessages.size() > 0) {
            Message msg = copyMessages.poll();
            System.out.println(msg.content + " - " + msg.timestamp);
        }
    }
}
