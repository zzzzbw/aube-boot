package com.github.zzzzbw.aube.model.dto.req;

import com.github.zzzzbw.aube.common.model.req.BasePageReq;
import com.github.zzzzbw.aube.model.enums.UserTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/08/14 14:18
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserPageReq extends BasePageReq {
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("用户类型")
    private UserTypeEnum userType;

}
