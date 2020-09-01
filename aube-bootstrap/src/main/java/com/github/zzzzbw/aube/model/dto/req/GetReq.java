package com.github.zzzzbw.aube.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author by ZHANGBOWEN469
 * @since 2020/09/01 16:18
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetReq {
    private String flag;

    private ProductCreateReq createReq;
}
