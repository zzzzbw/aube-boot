package com.github.zzzzbw.aube.web.starter.handler;

import com.github.zzzzbw.aube.common.constants.Consts;
import com.github.zzzzbw.aube.common.constants.Response;
import com.github.zzzzbw.aube.common.util.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author by zzzzbw
 * @since 2020/08/13 15:20
 */
@RestControllerAdvice(Consts.PACKAGE.BASE)
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getNestedParameterType().equals(Response.class);
    }

    @Override
    @NonNull
    public final Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType,
                                        MediaType contentType, Class<? extends HttpMessageConverter<?>> converterType,
                                        ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getNestedParameterType().equals(String.class)
                && StringHttpMessageConverter.class.isAssignableFrom(converterType)) {
            // 如果是String类型则手动JSON化返回值
            Response<Object> resp = Response.ok(body);
            return JsonUtils.toJson(resp);
        }

        return Response.ok(body);
    }
}
