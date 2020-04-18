package com.wangyaolang.animal.controller.user.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * 查询用户时返回的字段，不会包含有密码的信息
 */
@Data
public class UserInfoVO extends BaseVO {

    private Integer id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 电话
     */
    private String userTel;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 头像
     */
    private String userImage;

    /**
     * 类型
     */
    private String userType;

    /**
     * 账号金额
     */
    private Integer userMoney;

    /**
     * 会员到期日期
     */
    private String expireTime;

    /**
     * 前段路由需要的权限数组
     */
    private String[] access;
    /**
     * 前段根据homeName展示不同的首页
     */
    private String homeName;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
