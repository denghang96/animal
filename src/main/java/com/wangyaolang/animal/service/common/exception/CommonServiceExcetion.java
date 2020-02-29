package com.wangyaolang.animal.service.common.exception;

import lombok.Data;

/**
 * 定义一个业务异常
 */
@Data
public class CommonServiceExcetion extends Exception {

    private Integer code;
    private String errMsg;

    public CommonServiceExcetion(int code, String errMsg){
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }

}
