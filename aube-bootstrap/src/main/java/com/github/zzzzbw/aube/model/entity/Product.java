package com.github.zzzzbw.aube.model.entity;

import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/27 15:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends BaseEntity<Long> {

    private Long userId;

    private String name;

    private Long amount;

    private Date orderDate;
}
