package com.invest.server.exception;

/**
 * 비즈니스 예외 처리 정의
 * @version 1.0
 * @author Jeon Jihoon
 */

public enum ErrorCode {

    SOLD_OUT(200, "SOO1", "SOLD_OUT"),
    NOT_FOUND(200, "S002", "NOT_FOUND");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
