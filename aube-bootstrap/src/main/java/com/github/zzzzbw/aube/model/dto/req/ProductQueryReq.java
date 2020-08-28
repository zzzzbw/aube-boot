package com.github.zzzzbw.aube.model.dto.req;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.model.entity.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author by zzzzbw
 * @since 2020/08/27 16:43
 */
@Data
public class ProductQueryReq implements BaseDTO<ProductQueryReq, Product> {

    @ApiModelProperty("订单id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("商品名")
    private String name;
}
