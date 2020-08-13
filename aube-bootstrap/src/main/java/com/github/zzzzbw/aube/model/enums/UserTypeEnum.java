package com.github.zzzzbw.aube.model.enums;

import com.github.zzzzbw.aube.swagger.starter.model.SwaggerEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author by zzzzbw
 * @since 2020/08/07 9:49
 */
@AllArgsConstructor
@Getter
public enum UserTypeEnum implements SwaggerEnum {

    NORMAL("普通用户"),

    ADMIN("管理员用户");

    private final String desc;
}
