package com.github.zzzzbw.aube.swagger.starter.plugin;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.classmate.ResolvedType;
import com.github.zzzzbw.aube.swagger.starter.model.SwaggerEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import springfox.documentation.schema.Annotations;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.AllowableValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.schema.ApiModelProperties;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/06 18:56
 */
@Slf4j
@Component
public class SwaggerEnumPropertyPlugin implements ModelPropertyBuilderPlugin {
    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(ModelPropertyContext context) {
        //获取当前字段的类型
        final Class<?> fieldType = context.getBeanPropertyDefinition().get().getRawPrimaryType();

        //为枚举字段设置注释
        descForSwaggerEnumFields(context, fieldType);
    }

    @SuppressWarnings({"unchecked"})
    private void descForSwaggerEnumFields(ModelPropertyContext context, Class<?> fieldType) {
        //判断字段是否被定义为SwaggerEnum的枚举
        if (!fieldType.isEnum() || !SwaggerEnum.class.isAssignableFrom(fieldType)) {
            return;
        }
        Class<SwaggerEnum> swaggerEnumClass = (Class<SwaggerEnum>) fieldType;

        Optional<ApiModelProperty> annotation = Optional.empty();
        if (context.getAnnotatedElement().isPresent()) {
            annotation = ApiModelProperties.findApiModePropertyAnnotation(context.getAnnotatedElement().get());
        }
        if (context.getBeanPropertyDefinition().isPresent()) {
            annotation = Annotations.findPropertyAnnotation(
                    context.getBeanPropertyDefinition().get(),
                    ApiModelProperty.class);
        }
        try {
            //获得枚举并获取相关枚举对象属性
            SwaggerEnum[] enumConstants = swaggerEnumClass.getEnumConstants();

            String description = getSwaggerEnumDescription(enumConstants);
            List<String> allowableListValues = getSwaggerEnumValues(enumConstants);

            // 拼接ApiModelProperty上的注释信息
            String text = description;
            if (annotation.isPresent() && !StringUtils.isEmpty(annotation.get().value())) {
                text = annotation.get().value() + "\r\n" + description;
            }

            // 返回值class类型
            final ResolvedType resolvedType = context.getResolver().resolve(String.class);
            // 返回值允许的字段内容
            AllowableValues allowableValues = new AllowableListValues(allowableListValues, String.class.getName());
            // 设置Swagger内容
            context.getBuilder()
                    .allowableValues(allowableValues)    // 枚举字段内容回写
                    .description(text)               // 注释内容回写
                    .type(resolvedType);                 // 字段类型
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 获取IBaseEnum枚举的描述信息
     *
     * @param enumConstants
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    private String getSwaggerEnumDescription(SwaggerEnum[] enumConstants) {
        StringBuilder description = new StringBuilder();
        for (SwaggerEnum swaggerEnum : enumConstants) {
            Enum e = (Enum) swaggerEnum;
            description.append(e.name());
            if (StrUtil.isNotBlank(swaggerEnum.getDesc())) {
                // 如果有Desc值则用添加备注
                description.append(": ").append(swaggerEnum.getDesc());
            }
            description.append("; ");
        }
        return description.toString();
    }

    /**
     * 获取IBaseEnum的属性值
     *
     * @param enumConstants
     * @return
     */
    private List<String> getSwaggerEnumValues(SwaggerEnum[] enumConstants) {
        return Stream.of(enumConstants)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
