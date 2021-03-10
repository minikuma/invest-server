package com.invest.server.exception;

/**
 * 비즈니스 에러 처리 코드 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

public enum ErrorCode {
    SOLD_OUT(400, "S001", "Sold Out");

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

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
