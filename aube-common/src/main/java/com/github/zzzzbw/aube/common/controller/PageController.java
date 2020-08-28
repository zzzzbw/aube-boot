package com.github.zzzzbw.aube.common.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import com.github.zzzzbw.aube.common.model.req.PageReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by zzzzbw
 * @since 2020/08/27 13:54
 */
public interface PageController<ENTITY extends BaseEntity<ID>, ID, QueryDTO extends BaseDTO<QueryDTO, ENTITY>>
        extends IBaseController<ENTITY> {

    @GetMapping
    default IPage<ENTITY> page(@Validated PageReq<QueryDTO> req) {
        QueryWrapper<ENTITY> query;
        if (null != req.getQuery()) {
            Class<ENTITY> entityClass = (Class<ENTITY>) ClassUtil.getTypeArgument(this.getClass());
            ENTITY entity = BeanUtil.toBean(req.getQuery(), entityClass);
            query = Wrappers.query(entity);
        } else {
            query = Wrappers.query();
        }

        return getCrudService().page(req.create(), query);
    }
}
