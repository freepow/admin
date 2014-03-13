package com.brewduck.framework.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 4:31
 * To change this template use File | Settings | File Templates.
 */
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // 생성자
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
