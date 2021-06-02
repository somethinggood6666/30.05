package by.epam.shchemelev.exceptions;

public class BasketDoesntExistsException extends Exception{
    public BasketDoesntExistsException() {
        super();
    }

    public BasketDoesntExistsException(String message) {
        super(message);
    }

    public BasketDoesntExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketDoesntExistsException(Throwable cause) {
        super(cause);
    }
}
