package org.ivangrod.rssclean.domain.exceptions;

public class DuplicateInstanceException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public DuplicateInstanceException(String message) {
        super(message);
    }

    public DuplicateInstanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
