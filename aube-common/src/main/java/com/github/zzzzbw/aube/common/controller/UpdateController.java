package com.github.zzzzbw.aube.common.controller;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author by zzzzbw
 * @since 2020/08/26 17:21
 */
public interface UpdateController<ENTITY extends BaseEntity<ID>, ID, UpdateDTO extends BaseDTO<UpdateDTO, ENTITY>>
        extends IBaseController<ENTITY> {

    @PutMapping
    @SuppressWarnings("unchecked")
    default void update(@RequestBody UpdateDTO dto) {
        Class<ENTITY> entityClass = (Class<ENTITY>) ClassUtil.getTypeArgument(this.getClass(), 2);
        ENTITY entity = ReflectUtil.newInstance(entityClass);
        dto.updateTo(entity);
        getCrudService().updateById(entity);
    }
}
