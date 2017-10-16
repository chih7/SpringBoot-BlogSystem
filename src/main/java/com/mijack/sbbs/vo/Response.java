package com.mijack.sbbs.vo;

import java.util.HashMap;

public class Response<T> extends HashMap<String, Object> {
    @Override
    public Response<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Response<T> data(T data) {
        put("data", data);
        return this;
    }

    public Response<T> code(int code) {
        put("code", code);
        return this;
    }

    public Response<T> msg(String msg) {
        put("msg", msg);
        return this;
    }

    public static <T> Response<T> ok(T data) {
        return new Response<T>().data(data);
    }
}
