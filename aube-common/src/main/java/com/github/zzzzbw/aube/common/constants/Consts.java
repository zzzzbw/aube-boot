package com.github.zzzzbw.aube.common.constants;

import lombok.experimental.UtilityClass;

/**
 * @author by zzzzbw
 * @since 2020/08/07 10:00
 */
@UtilityClass
public class Consts {

    public interface PACKAGE {
        String MAPPER_SCAN = "com.github.zzzzbw.aube.**.dao";

        String SWAGGER_STARTER = "com.github.zzzzbw.aube.swagger.starter";

        String MYBATIS_PLUS_STARTER = "com.github.zzzzbw.aube.mybatisplus.starter";

        String WEB_STARTER = "com.github.zzzzbw.aube.web.starter";
    }
}
