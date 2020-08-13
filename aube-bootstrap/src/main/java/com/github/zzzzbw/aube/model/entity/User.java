package com.github.zzzzbw.aube.model.entity;

import com.github.zzzzbw.aube.common.model.entity.BaseEntity;
import com.github.zzzzbw.aube.model.enums.UserTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/10 10:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {

    private String name;

    private Date birthday;

    private UserTypeEnum userType;
}
