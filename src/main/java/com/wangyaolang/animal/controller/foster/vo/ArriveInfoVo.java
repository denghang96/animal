package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class ArriveInfoVo  extends BaseVO {

    private String applyId;

    private String arriveDate;

    private String animalNo;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
