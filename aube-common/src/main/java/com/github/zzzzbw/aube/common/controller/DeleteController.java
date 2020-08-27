package com.github.zzzzbw.aube.common.controller;

import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author by zzzzbw
 * @since 2020/08/26 17:39
 */
public interface DeleteController<ENTITY extends BaseEntity<ID>, ID>
        extends IBaseController<ENTITY> {

    @DeleteMapping("{id}")
    default void delete(@PathVariable long id) {
        getCrudService().removeById(id);
    }
}
