package com.nanooda.framework.security;

import com.nanooda.framework.exception.AuthenticationNotException;
import com.nanooda.framework.exception.PasswordMismatchException;
import com.nanooda.framework.exception.UserNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 4:29
 * To change this template use File | Settings | File Templates.
 */
public interface AuthenticationService {
    void login(String userId, String password) throws Throwable, UserNotFoundException, AuthenticationNotException, PasswordMismatchException;
}
