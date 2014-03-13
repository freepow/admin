package com.brewduck.framework.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 4:37
 * To change this template use File | Settings | File Templates.
 */
public class PasswordMismatchException extends Exception {
    public PasswordMismatchException() {
        super();
    }

    public PasswordMismatchException(String message) {
        super(message);
    }

    public PasswordMismatchException(Throwable cause) {
        super(cause);
    }

    public PasswordMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
