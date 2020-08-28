package com.github.zzzzbw.aube.model.dto.req;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.model.entity.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/27 15:58
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductCreateReq implements BaseDTO<ProductCreateReq, Product> {

    @NotNull
    @ApiModelProperty("用户id")
    private Long userId;

    @NotBlank
    @ApiModelProperty("商品名")
    private String name;

    @Min(0)
    @ApiModelProperty("金额")
    private long amount;

    @ApiModelProperty("下单日期")
    private Date orderDate;
}
