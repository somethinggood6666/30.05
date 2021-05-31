package by.epam.shchemelev.exceptions;

import java.io.Serializable;

public class OutOfWeightException extends Exception {
    public OutOfWeightException() {
        super();
    }

    public OutOfWeightException(String message) {
        super(message);
    }

    public OutOfWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfWeightException(Throwable cause) {
        super(cause);
    }
}
