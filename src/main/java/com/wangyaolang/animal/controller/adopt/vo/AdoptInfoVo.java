package com.wangyaolang.animal.controller.adopt.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class AdoptInfoVo extends BaseVO {

    private Integer id;

    private Integer userId;

    private Integer animalId;

    private String applyDate;

    private Integer applyStatus;

    private String adoptTel;

    private Integer adoptAddress;

    private String adoptReason;

    private String familyDesc;

    private String familyImg;

    private String hasChildren;

    private String traffiType;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
