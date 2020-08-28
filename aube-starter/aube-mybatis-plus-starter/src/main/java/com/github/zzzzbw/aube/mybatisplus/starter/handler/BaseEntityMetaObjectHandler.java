package com.github.zzzzbw.aube.mybatisplus.starter.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * BaseEntity 数据自动填充
 * <p>
 * 用于填充 createTime、updateTime
 *
 * @author by ZHANGBOWEN469
 * @since 2020/08/28 14:28
 */
@Slf4j
@Component
public class BaseEntityMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
    }
}
