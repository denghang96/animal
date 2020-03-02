package com.wangyaolang.animal.controller.user.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class PayPwdVo extends BaseVO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 支付密码
     */
    private String payPwd;

    /**
     *金额
     */
    private Integer money;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
