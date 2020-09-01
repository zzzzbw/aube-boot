package com.github.zzzzbw.aube.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.zzzzbw.aube.common.controller.CrudController;
import com.github.zzzzbw.aube.common.model.req.PageReq;
import com.github.zzzzbw.aube.model.dto.ProductDTO;
import com.github.zzzzbw.aube.model.dto.req.GetReq;
import com.github.zzzzbw.aube.model.dto.req.ProductCreateReq;
import com.github.zzzzbw.aube.model.dto.req.ProductQueryReq;
import com.github.zzzzbw.aube.model.dto.req.ProductUpdateReq;
import com.github.zzzzbw.aube.model.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by zzzzbw
 * @since 2020/08/27 15:57
 */
@Slf4j
@RestController
@RequestMapping("order")
public class ProductController extends CrudController<Product, Long, ProductDTO, ProductQueryReq, ProductCreateReq, ProductUpdateReq> {

    @Override
    public IPage<Product> page(PageReq<ProductQueryReq> req) {
        return super.page(req);
    }

    @GetMapping("list")
    public void list(PageReq<ProductQueryReq> req, ProductCreateReq createReq) {
        log.info("{}", req);
        log.info("{}", createReq);
    }

    @GetMapping("get/{time}")
    public void get(@PathVariable String time, @RequestParam GetReq req) {
        log.info("time");
        log.info("{}", req);
    }

}
