package by.epam.shchemelev.exceptions;

public class AddingBallException extends Exception{
    public AddingBallException() {
        super();
    }

    public AddingBallException(String message) {
        super(message);
    }

    public AddingBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddingBallException(Throwable cause) {
        super(cause);
    }
}
