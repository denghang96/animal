package com.wangyaolang.animal.controller.adopt.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class AdoptInfoVo extends BaseVO {

    private Integer id;

    private Integer userId;

    private Integer animalId;

    private String animalTiltleImg;

    private String animal_features;

    private String applyDate;

    private String applyStatus;

    private String adoptTel;

    private String adoptAddress;

    private String adoptReason;

    private String familyDesc;

    private String familyImg;

    private String hasChildren;

    private String traffiType;

    //以下为关联查询的属性

    private String userName;

    private String animalName;

    private String animalNo;

    private String opinion;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
