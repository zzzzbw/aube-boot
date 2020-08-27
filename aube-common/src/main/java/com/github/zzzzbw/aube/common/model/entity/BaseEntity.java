package com.github.zzzzbw.aube.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/06 17:25
 */
@Data
public class BaseEntity<T> {

    @TableId(type = IdType.AUTO)
    protected T id;

    protected Date createTime = new Date();

    @TableField(value = "update_time", update = "now()")
    protected Date updateTime = new Date();

    /**
     * 逻辑删除 0:未删除 1: 已删除
     */
    @TableLogic
    protected Integer deleted = 0;
}
