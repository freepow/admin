/**
 * @FileName  : ServiceBusinessException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author jaeger

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.framework.exception;

public class ServiceBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String customMessage;
    private Throwable cause;
    private int status;

    public ServiceBusinessException(String customMessage) {
        this.customMessage = customMessage;
    }
    public ServiceBusinessException(String customMessage, int status) {
        this.customMessage = customMessage;
        this.status = status;
    }
    public ServiceBusinessException(String customMessage, Throwable cause) {
        super(customMessage, cause);
        this.customMessage = customMessage;
        this.cause = cause;
    }
    public ServiceBusinessException(String customMessage, Throwable cause, int status) {
        super(customMessage, cause);
        this.customMessage = customMessage;
        this.cause = cause;
        this.status = status;
    }

    public String getCustomMessage() {
        return customMessage;
    }
    public void setCustomMessageg(String customMessage) {
        this.customMessage = customMessage;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Throwable getCause() {
        return cause;
    }
    public void setCause(Throwable cause) {
        this.cause = cause;
    }

}