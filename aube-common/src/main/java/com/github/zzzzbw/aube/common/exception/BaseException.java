package com.github.zzzzbw.aube.common.exception;

import com.github.zzzzbw.aube.common.constants.Response;
import com.github.zzzzbw.aube.common.constants.ResponseCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author by zzzzbw
 * @since 2020/4/1 22:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    protected String msg;

    protected int code;

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(ResponseCodes codes) {
        super(codes.getMsg());
        this.msg = codes.getMsg();
        this.code = codes.getCode();
    }


    public BaseException(Response<?> resp) {
        super(resp.getMsg());
        this.msg = resp.getMsg();
        this.code = resp.getCode();
    }
}
