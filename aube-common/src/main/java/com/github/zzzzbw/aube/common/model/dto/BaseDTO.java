package com.github.zzzzbw.aube.common.model.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;

import java.util.Objects;

/**
 * @author by zzzzbw
 * @since 2020/08/10 14:15
 */
public interface BaseDTO<DTO extends BaseDTO<DTO, ENTITY>, ENTITY> {

    /**
     * ENTITY转为DTO
     *
     * @param entity entity实体类
     * @return DTO实体类
     */
    @SuppressWarnings("unchecked")
    default DTO convertFrom(ENTITY entity) {
        Objects.requireNonNull(entity, "convertFrom entity can not be null");
        BeanUtil.copyProperties(entity, this);
        return (DTO) this;
    }

    /**
     * DTO生成ENTITY
     *
     * @return entity实体类
     */

    default ENTITY convertTo() {
        Class<ENTITY> entityClass = entityClass();
        ENTITY entity = ReflectUtil.newInstance(entityClass);
        BeanUtil.copyProperties(this, entity);
        return entity;
    }

    /**
     * 根据ENTITY更新DTO的数据
     *
     * @param entity     entity实体类
     * @param updateNull 是否更新null值
     */
    default void updateFrom(ENTITY entity, boolean updateNull) {
        Objects.requireNonNull(entity, "convertFrom entity can not be null");
        if (!updateNull) {
            BeanUtil.copyProperties(entity, this, CopyOptions.create().ignoreNullValue());
        } else {
            BeanUtil.copyProperties(entity, this);
        }
    }

    /**
     * 根据ENTITY更新DTO的数据, 不更新null值
     *
     * @param entity entity实体类
     */
    default void updateFrom(ENTITY entity) {
        Objects.requireNonNull(entity, "convertFrom entity can not be null");
        updateFrom(entity, false);
    }

    /**
     * 根据DTO更新ENTITY的数据
     *
     * @param entity     entity实体类
     * @param updateNull 是否更新null值
     */
    default void updateTo(ENTITY entity, boolean updateNull) {
        Objects.requireNonNull(entity, "convertFrom entity can not be null");
        if (!updateNull) {
            BeanUtil.copyProperties(this, entity, CopyOptions.create().ignoreNullValue());
        } else {
            BeanUtil.copyProperties(this, entity);
        }
    }

    /**
     * 根据DTO更新ENTITY的数据, 不更新null值
     *
     * @param entity entity实体类
     */
    default void updateTo(ENTITY entity) {
        updateTo(entity, false);
    }


    /**
     * 获取ENTITY Class
     *
     * @return 实体类Class
     */
    @SuppressWarnings("unchecked")
    default Class<ENTITY> entityClass() {
        return (Class<ENTITY>) ClassUtil.getTypeArgument(this.getClass(), 1);
    }
}
