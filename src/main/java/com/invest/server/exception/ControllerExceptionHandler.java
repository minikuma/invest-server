package com.invest.server.exception;

import com.invest.server.exception.biz.NotEnoughProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 컨트롤러 예외 처리
 * @version 1.0
 * @author Jeon Jihoon
 */

@ControllerAdvice(annotations = RestController.class)
public class ControllerExceptionHandler {

    @ExceptionHandler(NotEnoughProductException.class)
    protected ResponseEntity<ErrorResponse> handlerCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response = ErrorResponse.create()
                .code(errorCode.getCode())
                .status(errorCode.getStatus())
                .message(e.toString());
        return new ResponseEntity<>(response, Objects.requireNonNull(HttpStatus.resolve(errorCode.getStatus())));
    }
}
