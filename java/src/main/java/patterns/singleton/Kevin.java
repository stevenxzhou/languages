package patterns.singleton;

public class Kevin {
    
    private Logger logger;

    public Kevin() {
        this.logger = Logger.getInstance();
        this.logger.Log("I am Kevin!");
        this.logger.Log("I am Kevin!");
        this.logger.Log("I am Kevin!");
        this.logger.Log("I am Kevin!");
        this.logger.Log("I am Kevin!");
    }
}
