package com.github.zzzzbw.aube.common.constants;

import lombok.experimental.UtilityClass;

/**
 * @author by zzzzbw
 * @since 2020/08/07 10:00
 */
@UtilityClass
public class Consts {

    public interface PACKAGE {
        String BASE = "com.github.zzzzbw.aube";

        String MAPPER_SCAN = BASE + ".**.dao";

        String SWAGGER_STARTER = BASE + ".swagger.starter";

        String MYBATIS_PLUS_STARTER = BASE + ".mybatisplus.starter";

        String WEB_STARTER = BASE + ".web.starter";
    }
}
