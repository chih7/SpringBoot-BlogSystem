package com.mijack.sbbs.vo;

public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    public Response<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>().data(data);
    }
}
