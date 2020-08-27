package com.github.zzzzbw.aube.controller;

import com.github.zzzzbw.aube.common.controller.CrudController;
import com.github.zzzzbw.aube.model.dto.ProductDTO;
import com.github.zzzzbw.aube.model.dto.req.ProductCreateReq;
import com.github.zzzzbw.aube.model.dto.req.ProductQueryReq;
import com.github.zzzzbw.aube.model.dto.req.ProductUpdateReq;
import com.github.zzzzbw.aube.model.entity.Product;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zzzzbw
 * @since 2020/08/27 15:57
 */
@Validated
@RestController
@RequestMapping("order")
public class ProductController extends CrudController<Product, Long, ProductDTO, ProductQueryReq, ProductCreateReq, ProductUpdateReq> {
}
