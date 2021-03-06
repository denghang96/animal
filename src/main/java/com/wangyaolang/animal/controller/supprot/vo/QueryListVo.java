package com.wangyaolang.animal.controller.supprot.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class QueryListVo extends BaseVO {

    private Integer userId;

    private String helpDate;

    private String animalNo;

    private String userName;

    private String animalName;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
