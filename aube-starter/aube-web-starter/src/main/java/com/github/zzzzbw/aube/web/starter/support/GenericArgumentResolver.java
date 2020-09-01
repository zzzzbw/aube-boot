package com.github.zzzzbw.aube.web.starter.support;

import cn.hutool.core.util.ReflectUtil;
import com.github.zzzzbw.aube.common.annotation.GenericParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/31 11:25
 */
@Slf4j
public class GenericArgumentResolver extends ModelAttributeMethodProcessor {


    public GenericArgumentResolver(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean supportsParameter = super.supportsParameter(parameter);
        if (!supportsParameter) {
            return false;
        }

        if (parameter.getParameterType().equals(parameter.getGenericParameterType())) {
            // 如果类与泛型类信息相同表示不是泛型类
            return false;
        }
        return !findGenericParam(parameter).isEmpty();
    }

    @Override
    protected Object constructAttribute(Constructor<?> ctor, String attributeName, MethodParameter parameter, WebDataBinderFactory binderFactory, NativeWebRequest webRequest) throws Exception {
        if (ctor.getParameterCount() != 0) {
            // 不支持无参构造函数的对象
            throw new IllegalArgumentException();
        }


        Class<?> parameterType = parameter.getParameterType();
        Object attribute = ReflectUtil.newInstance(parameterType);
        List<Field> genericParam = findGenericParam(parameter);
        for (Field field : genericParam) {
            Class<?> genericType = getGenericType(parameter, field);
            Object genericAttribute = ReflectUtil.newInstance(genericType);
            ReflectUtil.setFieldValue(attribute, field, genericAttribute);
        }


        return attribute;
    }


    private Class<?> getGenericType(MethodParameter parameter, Field field) {
        GenericParam genericParam = field.getAnnotation(GenericParam.class);
        return (Class<?>) ((ParameterizedTypeImpl) parameter.getGenericParameterType()).getActualTypeArguments()[genericParam.index()];
    }


    private List<Field> findGenericParam(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        Field[] fields = parameterType.getDeclaredFields();
        return Stream.of(fields)
                .filter(field -> null != field.getAnnotation(GenericParam.class))
                .collect(Collectors.toList());
    }
}
