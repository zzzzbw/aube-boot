package com.github.zzzzbw.aube.common.controller;

import com.github.zzzzbw.aube.common.service.ICrudService;

/**
 * @author by zzzzbw
 * @since 2020/08/26 16:46
 */
public interface IBaseController<ENTITY> {

    ICrudService<ENTITY> getCrudService();
}
