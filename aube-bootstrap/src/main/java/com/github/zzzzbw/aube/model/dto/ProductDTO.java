package com.github.zzzzbw.aube.model.dto;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.model.entity.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/27 15:57
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDTO implements BaseDTO<ProductDTO, Product> {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("商品名")
    private String name;

    @ApiModelProperty("金额")
    private long amount;

    @ApiModelProperty("下单日期")
    private Date orderDate;
}
