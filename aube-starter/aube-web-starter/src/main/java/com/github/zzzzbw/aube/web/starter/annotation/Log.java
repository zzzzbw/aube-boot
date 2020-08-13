package com.github.zzzzbw.aube.web.starter.annotation;

import java.lang.annotation.*;

/**
 * @author by zzzzbw
 * @since 2020/08/13 10:59
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
