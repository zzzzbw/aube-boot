package com.github.zzzzbw.aube.web.starter.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.zzzzbw.aube.common.model.req.PageReq;
import com.github.zzzzbw.aube.web.starter.annotation.GenericParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/31 11:25
 */
@Slf4j
public class PageReqArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 分页查询条件参数的名称
     */
    private static final String QUERY_PARAMETER_NAME = PageReq.QUERY_FIELD_NAME;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        GenericParam genericParam = parameter.getParameterAnnotation(GenericParam.class);
        return null != genericParam
                && StrUtil.isNotBlank(genericParam.value());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object pageReq = createPageReq(parameter, mavContainer, webRequest, binderFactory);

        Object pageDto = createQueryDto(parameter, mavContainer, webRequest, binderFactory);

        ReflectUtil.setFieldValue(pageReq, QUERY_PARAMETER_NAME, pageDto);

        return pageReq;

    }

    private Object createPageReq(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> parameterType = parameter.getParameterType();
        Field[] declaredFields = ClassUtil.getDeclaredFields(parameterType);

        String[] parameterValues;
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        for (Field field : declaredFields) {
            parameterValues = webRequest.getParameterValues(field.getName());
            if (null == parameterValues) {
                continue;
            }
            mutablePropertyValues.add(field.getName(), parameterValues);
        }

        return createWebDataObject(webRequest, binderFactory, parameterType, mutablePropertyValues);
    }

    private Object createQueryDto(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> elementClass = getQueryDtoType(parameter);
        Field[] fields = elementClass.getDeclaredFields();

        String[] parameterValues;
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        for (Field field : fields) {
            parameterValues = webRequest.getParameterValues(QUERY_PARAMETER_NAME + "." + field.getName());
            if (null == parameterValues) {
                continue;
            }
            mutablePropertyValues.add(field.getName(), parameterValues);
        }

        return createWebDataObject(webRequest, binderFactory, elementClass, mutablePropertyValues);
    }

    private Object createWebDataObject(NativeWebRequest webRequest, WebDataBinderFactory binderFactory, Class<?> clz, MutablePropertyValues values) throws Exception {
        String name = ClassUtils.getShortNameAsProperty(clz);
        Object attribute = BeanUtils.instantiateClass(clz);
        WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);
        binder.bind(values);
        return binder.getTarget();
    }


    private Class<?> getQueryDtoType(MethodParameter parameter) {
        Type queryDtoType = ((ParameterizedTypeImpl) parameter.getGenericParameterType()).getActualTypeArguments()[0];
        return (Class<?>) queryDtoType;
    }
}
