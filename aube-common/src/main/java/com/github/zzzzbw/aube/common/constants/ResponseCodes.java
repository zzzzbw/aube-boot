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
    SUCCESS(0, "成功"),
    AUTH_ERROR(401, "验证失败"),
    FORBIDDEN(403, "拒绝访问"),
    NOT_FOUND(404, "找不到资源"),
    INTERNAL_SERVER_ERROR(500, "系统繁忙，请稍后再试"),
    ;

    private final int code;
    private final String msg;
}
