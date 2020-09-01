package com.github.zzzzbw.aube.web.starter;

import com.github.zzzzbw.aube.web.starter.support.GenericArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/31 17:19
 */
@Configuration
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new GenericArgumentResolver(true));
    }
}
