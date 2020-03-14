package com.wangyaolang.animal.controller.foster.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class FosterInfoVo extends BaseVO {
    private Integer id;

    private Integer userId;

    private String userName;

    private String animalName;

    private String animalType;

    private Integer animalAge;

    private String applyDate;

    private String animalDesc;

    private String animalProve;

    private String applyStatus;

    private String userTel;

    private Float applyPrice;

    private String opinion;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
