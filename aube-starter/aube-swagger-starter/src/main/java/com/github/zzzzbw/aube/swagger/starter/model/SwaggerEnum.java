package com.github.zzzzbw.aube.swagger.starter.model;

import cn.hutool.core.util.StrUtil;

/**
 * @author by zzzzbw
 * @since 2020/08/06 18:51
 */
public interface SwaggerEnum {
    default String getDesc() {
        return StrUtil.EMPTY;
    }
}
