package com.github.zzzzbw.aube.common.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 * <p>
 * 使用jackson库解析
 *
 * @author by zzzzbw
 * @since 2020/08/12 16:08
 */
@UtilityClass
public class JsonUtils {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Object转json
     *
     * @param o 转换的Object
     * @return json字符串
     */
    @SneakyThrows
    public String toJson(Object o) {
        return OBJECT_MAPPER.writeValueAsString(o);
    }

    /**
     * json转Object
     *
     * @param json      json字符串
     * @param valueType 转换的class类型
     * @param <T>
     * @return 转换后对象
     */
    @SneakyThrows
    public <T> T toObject(String json, @NonNull Class<T> valueType) {
        Assert.hasText(json, "json not hasText");
        Assert.notNull(valueType, "valueType is null");
        return OBJECT_MAPPER.readValue(json, valueType);
    }

    /**
     * json转List
     *
     * @param json      json字符串
     * @param valueType List中的class类型
     * @param <T>
     * @return 转换后List
     */
    @SneakyThrows
    public <T> List<T> toList(String json, @NonNull Class<T> valueType) {
        Assert.hasText(json, "json not hasText");
        Assert.notNull(valueType, "valueType is null");

        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, valueType);

        return OBJECT_MAPPER.readValue(json, javaType);
    }

    /**
     * json转Map
     *
     * @param json      json字符串
     * @param keyType   Map中Key的class类型
     * @param valueType Map中Value的class类型
     * @param <K>
     * @param <V>
     * @return 转换后的Map
     */
    @SneakyThrows
    public <K, V> Map<K, V> toMap(String json, @NonNull Class<K> keyType, @NonNull Class<V> valueType) {
        Assert.hasText(json, "json not hasText");
        Assert.notNull(keyType, "keyType is null");
        Assert.notNull(valueType, "valueType is null");

        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyType, valueType);
        return OBJECT_MAPPER.readValue(json, javaType);
    }

}
