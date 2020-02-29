package com.wangyaolang.animal.controller.user.vo;


import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class EnrollUserVO extends BaseVO {
    private String userName;
    private String loginPwd;
    private String userTel;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
