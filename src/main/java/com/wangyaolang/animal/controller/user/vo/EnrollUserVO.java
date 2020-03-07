package com.wangyaolang.animal.controller.user.vo;


import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 用户注册时填写的表单
 */
@Data
public class EnrollUserVO extends BaseVO {
    private String userName;
    private String loginPwd;
    private String userTel;
    private String userType;
    @Override
    public void checkParam() throws ParamErrorException {

    }
}
