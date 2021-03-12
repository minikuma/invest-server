package com.invest.server.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 예외 처리 응답
 * @version 1.0
 * @author Jeon Jihoon
 */

@NoArgsConstructor
@Getter
public class ErrorResponse {
    private final LocalDateTime timeStamp = LocalDateTime.now();
    private String message;
    private String code;
    private int status;

    static public ErrorResponse create() {
        return new ErrorResponse();
    }

    public ErrorResponse code(String code) {
        this.code = code;
        return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }
}
