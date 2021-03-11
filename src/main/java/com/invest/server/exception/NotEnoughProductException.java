package com.invest.server.exception;

import org.springframework.validation.BindingResult;

public class NotEnoughProductException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;
    public NotEnoughProductException() {
        super(ErrorCode.SOLD_OUT);
    }
}
