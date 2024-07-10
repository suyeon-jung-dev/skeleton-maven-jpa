package com.skeleton.restapi.common;

public class CommonResponse {

    private String code;
    private Object data;

    public CommonResponse(String code, String data) {
        this.code = code;
        this.data = data;
    }

    public CommonResponse(ResponseCode errorCode) {
        this.code = errorCode.getCode();
        this.data = errorCode.getMessage();
    }

    public CommonResponse(Object data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.data = data;
    }
}
