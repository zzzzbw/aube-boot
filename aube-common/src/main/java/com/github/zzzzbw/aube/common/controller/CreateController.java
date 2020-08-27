package com.github.zzzzbw.aube.common.controller;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author by zzzzbw
 * @since 2020/08/26 16:51
 */
public interface CreateController<ENTITY extends BaseEntity<ID>, ID, CreateDTO extends BaseDTO<CreateDTO, ENTITY>>
        extends IBaseController<ENTITY> {

    @PostMapping
    @SuppressWarnings("unchecked")
    default ID create(@RequestBody CreateDTO dto) {
        Class<ENTITY> entityClass = (Class<ENTITY>) ClassUtil.getTypeArgument(this.getClass());
        ENTITY entity = ReflectUtil.newInstance(entityClass);
        dto.updateTo(entity);
        getCrudService().save(entity);
        return entity.getId();
    }
}
