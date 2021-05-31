package by.epam.shchemelev.exceptions;

public class NoSingleBasketException extends Exception{
    public NoSingleBasketException() {
        super();
    }

    public NoSingleBasketException(String message) {
        super(message);
    }

    public NoSingleBasketException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSingleBasketException(Throwable cause) {
        super(cause);
    }
}
