package hr.java.production.exception;

public class BojaNePostojiException extends Exception{
    public BojaNePostojiException() {
    }

    public BojaNePostojiException(String message) {
        super(message);
    }

    public BojaNePostojiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BojaNePostojiException(Throwable cause) {
        super(cause);
    }
}
