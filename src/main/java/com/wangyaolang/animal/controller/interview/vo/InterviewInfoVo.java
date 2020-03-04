package com.wangyaolang.animal.controller.interview.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class InterviewInfoVo extends BaseVO {

    private Integer id;

    private String userName;

    private Integer userTel;

    private Integer userId;

    private String adoptDate;

    private Integer adopAnimalId;

    private String adoptDesc;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
