package com.github.zzzzbw.aube.common.controller;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import com.github.zzzzbw.aube.common.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author by zzzzbw
 * @since 2020/08/26 17:54
 */
public class CrudController<ENTITY extends BaseEntity<ID>, ID,
        DTO extends BaseDTO<DTO, ENTITY>,
        QueryDTO extends BaseDTO<QueryDTO, ENTITY>,
        CreateDTO extends BaseDTO<CreateDTO, ENTITY>,
        UpdateDTO extends BaseDTO<UpdateDTO, ENTITY>>
        implements
        GetController<ENTITY, ID, DTO>,
        PageController<ENTITY, ID, QueryDTO>,
        CreateController<ENTITY, ID, CreateDTO>,
        UpdateController<ENTITY, ID, UpdateDTO>,
        DeleteController<ENTITY, ID> {

    @Autowired
    protected ICrudService<ENTITY> curdService;

    @Override
    public ICrudService<ENTITY> getCrudService() {
        return curdService;
    }
}
