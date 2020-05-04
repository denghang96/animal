package com.wangyaolang.animal.controller.user.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 重置密码/修改密码时传递的参数
 */
@Data
public class RePayPwdVo extends BaseVO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 旧密码
     */
    private String oldPwd;

    /**
     * 新密码
     */
    private String payPwd;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
