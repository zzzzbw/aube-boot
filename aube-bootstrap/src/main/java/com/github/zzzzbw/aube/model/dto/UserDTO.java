package com.github.zzzzbw.aube.model.dto;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.model.entity.User;
import com.github.zzzzbw.aube.model.enums.UserTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/07 9:49
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO implements BaseDTO<UserDTO, User> {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("用户类型")
    private UserTypeEnum userType;
}
