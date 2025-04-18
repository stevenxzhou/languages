package patterns.singleton;

public class John {
    
    private Logger logger;

    public John(){
        this.logger = Logger.getInstance();
        this.logger.getLastMessages();
    }
}
