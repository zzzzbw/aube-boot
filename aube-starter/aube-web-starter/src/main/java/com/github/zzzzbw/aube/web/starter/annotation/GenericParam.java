package com.github.zzzzbw.aube.web.starter.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/31 17:33
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenericParam {

    @AliasFor("name")
    String value();

    @AliasFor("value")
    String name();
}
