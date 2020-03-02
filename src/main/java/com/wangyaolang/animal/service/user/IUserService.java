package com.wangyaolang.animal.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.user.vo.*;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.List;

public interface IUserService extends IService<AUser> {

    /*
        用户登记接口
     */
    void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceExcetion;

    /*
        验证用户名是否存在
     */
    boolean checkUserName(String userName) throws CommonServiceExcetion;

    /*
        用户名密码验证
     */
    boolean userAuth(String userName,String userPwd) throws CommonServiceExcetion;

    /*
        获取用户信息
     */
    UserInfoVO describeUserInfo(String userId) throws CommonServiceExcetion;


    /*
        修改用户信息
     */
    UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceExcetion;

    /*
        根据条件查询用户列表
     */
    List<UserInfoVO> getList(Page page, QueryListVo queryListVo);

    /*
        重置、修改密码
     */
    boolean rePwd(RePwdVo rePwdVo) throws CommonServiceExcetion;
    /*
        设置支付密码
     */
    boolean setPayPwd(PayPwdVo payPwdVo);

    boolean consum(PayPwdVo payPwdVo);
}
