package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class SettleResponseVo extends BaseVO {

    private Float userMoney;

    private Float animalSingleMoney;

    private Float animalTotleMoney;

    private String arriveDate;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
