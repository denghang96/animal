package com.wangyaolang.animal.controller.auth.vo;


import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class AuthRequestVO extends BaseVO {

    private String userName;
    private String loginPwd;

    @Override
    public void checkParam() throws ParamErrorException {
        // TODO 验证过程补充
    }
}
