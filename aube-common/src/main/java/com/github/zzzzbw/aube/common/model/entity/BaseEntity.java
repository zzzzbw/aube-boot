package com.github.zzzzbw.aube.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author by zzzzbw
 * @since 2020/08/06 17:25
 */
@Data
public class BaseEntity<T> {

    @TableId(type = IdType.AUTO)
    protected T id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    /**
     * 逻辑删除 0:未删除 1: 已删除
     */
    @TableLogic
    protected Integer deleted = 0;
}
