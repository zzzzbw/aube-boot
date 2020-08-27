package com.github.zzzzbw.aube.common.controller;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author by zzzzbw
 * @since 2020/08/26 17:41
 */
public interface GetController<ENTITY extends BaseEntity<ID>, ID, DTO extends BaseDTO<DTO, ENTITY>>
        extends IBaseController<ENTITY> {

    @GetMapping("{id}")
    @SuppressWarnings("unchecked")
    default DTO get(@PathVariable long id) {
        ENTITY data = getCrudService().getById(id);
        Class<DTO> dtoClass = (Class<DTO>) ClassUtil.getTypeArgument(this.getClass(), 2);
        DTO dto = ReflectUtil.newInstance(dtoClass);
        return dto.convertFrom(data);
    }
}
