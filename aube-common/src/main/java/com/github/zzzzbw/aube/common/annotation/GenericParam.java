package com.github.zzzzbw.aube.common.annotation;

import java.lang.annotation.*;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/31 17:33
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenericParam {

    int index() default 0;
}
