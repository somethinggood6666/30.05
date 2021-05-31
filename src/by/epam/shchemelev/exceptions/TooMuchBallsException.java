package by.epam.shchemelev.exceptions;

public class TooMuchBallsException extends Exception{
    public TooMuchBallsException() {
        super();
    }

    public TooMuchBallsException(String message) {
        super(message);
    }

    public TooMuchBallsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooMuchBallsException(Throwable cause) {
        super(cause);
    }
}
