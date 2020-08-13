package com.github.zzzzbw.aube.common.constants;

import com.github.zzzzbw.aube.common.exception.BaseException;
import lombok.Data;

import java.util.function.Supplier;

/**
 * @author by zzzzbw
 * @since 2020/3/20 12:46
 */
@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;
    private boolean success;

    private Response() {
    }

    private Response(boolean success) {
        this.success = success;
    }

    private Response(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private Response(boolean success, T data, int code) {
        this.success = success;
        this.data = data;
        this.code = code;
    }

    private Response(boolean success, int code) {
        this.success = success;
        this.code = code;
    }

    private Response(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }


    private Response(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public T orElseThrow() {
        if (!this.success) {
            throw new BaseException(this);
        }
        return this.data;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (this.success) {
            return this.data;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public static <T> Response<T> ok() {
        return new Response<>(true);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(true, data);
    }

    public static <T> Response<T> ok(T data, int code) {
        return new Response<>(true, data, code);
    }

    public static <T> Response<T> fail() {
        return new Response<>(false);
    }

    public static <T> Response<T> fail(int code) {
        return new Response<>(false, code);
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(false, msg);
    }

    public static <T> Response<T> fail(int code, String msg) {
        return new Response<>(false, code, msg);
    }


    public static <T> Response<T> fail(Response<?> response) {
        return new Response<>(false, response.getCode(), response.getMsg());
    }

    public static <T> Response<T> fail(ResponseCodes responseCodes) {
        return new Response<>(false, responseCodes.getCode(), responseCodes.getMsg());
    }


    public static class EmptyData {
    }
}
