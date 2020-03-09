package com.wangyaolang.animal.controller.animal.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class QueryListVo extends BaseVO {
    /**
     * 动物分类 猫 狗！
     */
    private String animalType;
    /**
     * 动物编号
     */
    private String animalNo;
    /**
     * 动物昵称
     */
    private String animalName;

    /**
     * 动物状态 已领养，待领养，可助养
     */
    private String animalStatus;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
