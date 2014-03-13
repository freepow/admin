/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.framework.exception;

/**
 * @author bluepoet
 *
 */
public class AuthenticationNotException extends Exception {
	public AuthenticationNotException() {
		super();
	}

	public AuthenticationNotException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationNotException(String message) {
		super(message);
	}

	public AuthenticationNotException(Throwable cause) {
		super(cause);
	}
}