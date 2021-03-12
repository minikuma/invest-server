package com.invest.server.exception.biz;

import com.invest.server.exception.CustomException;
import com.invest.server.exception.ErrorCode;

/**
 * 투자 상품이 마감된 경우 SOLD OUT 응답 처리
 * @version 1.0
 * @author Jeon Jihoon
 */

public class NotEnoughProductException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;
    public NotEnoughProductException() {
        super(ErrorCode.SOLD_OUT);
    }
}