package com.wangyaolang.animal.controller.user.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 根据条件查询用户列表时的VO
 */
@Data
public class QueryListVo  extends BaseVO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 电话
     */
    private String userTel;
    /**
     * 性别
     */
    private String userSex;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
