package com.github.zzzzbw.aube.common.exception;

import com.github.zzzzbw.aube.common.constants.ResponseCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author by zzzzbw
 * @since 2020/08/10 14:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends BaseException {

    public NotFoundException() {
        super(ResponseCodes.NOT_FOUND);
    }

    public NotFoundException(String msg) {
        super(msg, ResponseCodes.NOT_FOUND.getCode());
    }
}
