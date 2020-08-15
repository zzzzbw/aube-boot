package com.github.zzzzbw.aube.common.constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by zzzzbw
 * @since 2020/3/20 12:47
 */
@AllArgsConstructor
@Getter
public enum ResponseCodes {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),
    /**
     * 验证失败
     */
    AUTH_ERROR(401, "验证失败"),
    /**
     * 拒绝访问
     */
    FORBIDDEN(403, "拒绝访问"),
    /**
     * 找不到资源
     */
    NOT_FOUND(404, "找不到资源"),
    /**
     * 系统错误
     */
    INTERNAL_SERVER_ERROR(500, "系统繁忙，请稍后再试"),
    ;

    private final int code;
    private final String msg;
}
