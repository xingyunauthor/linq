package com.bestvike.linq.exception;

/**
 * @author 许崇雷
 * @date 2017/7/11
 */
public final class InvalidOperationException extends RuntimeException {
    public InvalidOperationException() {
        super("Operation is not valid due to the current state of the object.");
    }

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Exception innerException) {
        super(message, innerException);
    }
}
