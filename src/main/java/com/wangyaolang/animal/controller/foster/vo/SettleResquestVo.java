package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SettleResquestVo extends BaseVO {

    private Integer fosterId;

    private String settleDate;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
