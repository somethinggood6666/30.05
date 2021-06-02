package by.epam.shchemelev.exceptions;

public class BallDoesntExistsException extends Exception{
    public BallDoesntExistsException() {
        super();
    }

    public BallDoesntExistsException(String message) {
        super(message);
    }

    public BallDoesntExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BallDoesntExistsException(Throwable cause) {
        super(cause);
    }
}
