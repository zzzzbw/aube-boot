package com.github.zzzzbw.aube.service.impl;

import com.github.zzzzbw.aube.common.service.impl.CrudServiceImpl;
import com.github.zzzzbw.aube.dao.ProductMapper;
import com.github.zzzzbw.aube.model.entity.Product;
import com.github.zzzzbw.aube.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author by zzzzbw
 * @since 2020/08/27 16:03
 */
@Slf4j
@Service
public class ProductServiceImpl extends CrudServiceImpl<ProductMapper, Product> implements ProductService {
}
