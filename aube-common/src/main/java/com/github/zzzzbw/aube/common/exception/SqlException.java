package com.github.zzzzbw.aube.common.exception;

import com.github.zzzzbw.aube.common.constants.ResponseCodes;

/**
 * @author by zzzzbw
 * @since 2020/08/13 17:26
 */
public class SqlException extends BaseException {

    public SqlException() {
        super(ResponseCodes.INTERNAL_SERVER_ERROR);
    }

    public SqlException(String msg) {
        super(msg, ResponseCodes.INTERNAL_SERVER_ERROR.getCode());
    }

}
