package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class QueryListVo extends BaseVO {

    private Integer userId;

    private String animalName;

    private String animalType;

    private String applyDate;


    @Override
    public void checkParam() throws ParamErrorException {

    }
}
