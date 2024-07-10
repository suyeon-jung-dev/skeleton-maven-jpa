package com.skeleton.restapi.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonController {

    protected ResponseEntity<?> responseSuccess() {
        return new ResponseEntity<>(null);
    }

    protected  ResponseEntity<?> responseSuccess(Object data) {
        CommonResponse result = new CommonResponse(data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public Object handleException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        log.error(ExceptionUtils.getStackTrace(exception));

        CommonResponse result = new CommonResponse(ResponseCode.ERROR_UNKNOWN);

        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
