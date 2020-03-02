package com.wangyaolang.animal.controller.animal.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class AnimalInfoVo extends BaseVO {

    private Integer id;

    private String animalType;

    private Integer animalNo;

    private String animalName;

    private Integer animalAge;

    private String animalImg;

    private String animalTiltleImg;

    private String animalFeatures;

    private Integer projectType;

    private Integer animalStatus;

    private Integer animalMoney;

    private String animalDate;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
