package com.wangyaolang.animal.controller.supprot.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class SupportInfoVo extends BaseVO {
    private Integer id;

    private Integer userId;

    private String animalId;

    private String helpDate;

    private Integer helpMoney;

    private String helpDesc;

    private String payPwd;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
