package com.github.zzzzbw.aube.common.model.req;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by zzzzbw
 * @since 2020/08/06 17:16
 */
public abstract class BasePageReq extends BaseReq {
    @ApiModelProperty(value = "页数 从1开始", example = "1")
    protected int current = 1;
    @ApiModelProperty(value = "每页显示数量", example = "10")
    protected int size = 10;
    @ApiModelProperty(value = "根据字段排序 负号为倒序. 如: [-id, name]", example = "[-id, name]")
    protected List<String> orders = new ArrayList<>();

    public <T> Page<T> create() {
        Page<T> page = new Page<>(current, size);
        if (CollectionUtil.isEmpty(orders)) {
            return page;
        }

        List<OrderItem> orderItems = orders.stream().map(order -> {
            if (order.contains("-")) {
                return OrderItem.desc(order.substring(1));
            } else {
                return OrderItem.asc(order);
            }
        }).collect(Collectors.toList());

        page.setOrders(orderItems);

        return page;
    }
}
