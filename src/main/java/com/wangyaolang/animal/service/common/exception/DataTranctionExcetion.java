package com.wangyaolang.animal.service.common.exception;

import lombok.Data;

/**
 * 定义一个数据转换异常
 */
@Data
public class DataTranctionExcetion extends Exception {

    private Integer code;
    private String errMsg;

    public DataTranctionExcetion(int code, String errMsg){
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }

}
