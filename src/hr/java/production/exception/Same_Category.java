package hr.java.production.exception;

public class Same_Category extends Exception{

    public Same_Category(String message) {
        super(message);
    }

    public Same_Category(String message, Throwable cause) {
        super(message, cause);
    }

    public Same_Category(Throwable cause) {
        super(cause);
    }
}
