package com.wangyaolang.animal.controller.comment.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class QueryListVo extends BaseVO {
    private Integer userId;
    private Integer amimalId;
    @Override
    public void checkParam() throws ParamErrorException {

    }
}
