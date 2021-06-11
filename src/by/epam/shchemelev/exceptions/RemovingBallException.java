package by.epam.shchemelev.exceptions;

public class RemovingBallException extends Exception{
    public RemovingBallException() {
        super();
    }

    public RemovingBallException(String message) {
        super(message);
    }

    public RemovingBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemovingBallException(Throwable cause) {
        super(cause);
    }
}
