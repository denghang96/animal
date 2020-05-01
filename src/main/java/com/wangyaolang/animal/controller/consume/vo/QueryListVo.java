package com.wangyaolang.animal.controller.consume.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class QueryListVo extends BaseVO {

    private String consumeDate;

    private String type;

    private String userId;

    private String userName;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
