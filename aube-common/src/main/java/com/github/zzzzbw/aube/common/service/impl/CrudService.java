package com.github.zzzzbw.aube.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.zzzzbw.aube.common.service.ICrudService;

/**
 * @author by zzzzbw
 * @since 2020/08/06 17:52
 */
public class CrudService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements ICrudService<T> {
}
