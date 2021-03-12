package com.invest.server.exception.biz;

import com.invest.server.exception.CustomException;
import com.invest.server.exception.ErrorCode;

/**
 * 상품 정보를 조회하지 못한 경우 NOT_FOUND 처리
 * @version 1.0
 * @author Jeon Jihoon
 */

public class NotFoundProductException extends CustomException {
    private static final long serialVersionUID = -2116671122895194101L;
    public NotFoundProductException() {
        super(ErrorCode.NOT_FOUND);
    }
}
