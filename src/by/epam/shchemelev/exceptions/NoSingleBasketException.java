package by.epam.shchemelev.exceptions;

import java.io.Serializable;

public class NoSingleBasketException extends Exception implements Serializable {
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
