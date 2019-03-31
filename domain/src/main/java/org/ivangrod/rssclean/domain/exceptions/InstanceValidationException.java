package org.ivangrod.rssclean.domain.exceptions;

public class InstanceValidationException extends BusinessException {

    private static final long serialVersionUID = 1L;
    protected Object instance;

    public InstanceValidationException(String message) {
        super(message);
    }

    public InstanceValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstanceValidationException(String message, Object instance) {
        super(message);
        this.instance = instance;
    }

    public Object getInstance() {
        return instance;
    }
}
