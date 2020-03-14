package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class SettleVo extends BaseVO {
    private String fosterId;
    private String animalName;
    private String userMoney;
    private String settleDate;
    private String animalSingleMoney;
    private Float animalTotleMoney;
    private String settleType;
    private String arriveDate;
    @Override
    public void checkParam() throws ParamErrorException {

    }
}
