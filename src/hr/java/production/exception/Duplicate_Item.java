package hr.java.production.exception;


public class Duplicate_Item extends Exception {
    public Duplicate_Item() {
    }

    public Duplicate_Item(String message) {
        super(message);
    }

    public Duplicate_Item(String message, Throwable cause) {
        super(message, cause);
    }

    public Duplicate_Item(Throwable cause) {
        super(cause);
    }
}
