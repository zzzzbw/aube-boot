package com.github.zzzzbw.aube.model.dto.req;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import com.github.zzzzbw.aube.model.entity.User;
import com.github.zzzzbw.aube.model.enums.UserTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/11 14:16
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserCreateReq implements BaseDTO<UserCreateReq, User> {

    @NotBlank
    @ApiModelProperty("姓名")
    private String name;

    @NotNull
    @ApiModelProperty("生日")
    private Date birthday;

    @NotNull
    @ApiModelProperty("用户类型")
    private UserTypeEnum userType;

}
