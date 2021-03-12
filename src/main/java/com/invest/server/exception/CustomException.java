package com.invest.server.exception;

/**
 * 비즈니스 예외 처리용 예외 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
