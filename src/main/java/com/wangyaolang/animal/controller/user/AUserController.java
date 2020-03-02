package com.wangyaolang.animal.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.controller.user.vo.*;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.user.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user/")
public class AUserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     * @param enrollUserVO
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResponseVO register(@RequestBody EnrollUserVO enrollUserVO) throws CommonServiceExcetion, ParamErrorException {
        enrollUserVO.checkParam();

        userService.userEnroll(enrollUserVO);

        return BaseResponseVO.success();
    }

    /**
     * 批量注销用户
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public BaseResponseVO del(@RequestParam(value = "delIds") List<AUser> list) throws CommonServiceExcetion {
        boolean isSuccess = userService.removeByIds(list);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除用户时出错，请重试");
        }
        return BaseResponseVO.success();
    }

    /**
     * 修改用户信息
     * @param userInfoVO
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public BaseResponseVO del(@RequestBody UserInfoVO userInfoVO) throws CommonServiceExcetion {
        UserInfoVO u = userService.updateUserInfo(userInfoVO);
        return BaseResponseVO.success(u);
    }

    /**
     * 查询当前登录用户的信息
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public BaseResponseVO describeUserInfo() throws CommonServiceExcetion, ParamErrorException {

        String userId = TraceUtil.getUserId();//获取当前登录用户的id

        UserInfoVO userInfoVO = userService.describeUserInfo(userId);

        userInfoVO.checkParam();

        return BaseResponseVO.success(userInfoVO);
    }

    /**
     * 根据条件查询用户列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws  ParamErrorException {
        queryListVo.checkParam();

        List<UserInfoVO> userInfoVO = userService.getList(page, queryListVo);

        page.setRecords(userInfoVO);

        return BaseResponseVO.success(page);
    }

    /**
     * 重置、修改密码
     * @param rePwdVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "rePwd",method = RequestMethod.POST)
    public BaseResponseVO rePwd(@RequestBody RePwdVo rePwdVo) throws CommonServiceExcetion {
        boolean isSuccess = userService.rePwd(rePwdVo);
        if (!isSuccess) {
            return BaseResponseVO.serviceFailed("修改密码失败！");
        }
        return BaseResponseVO.success();
    }

    /**
     * 设置支付密码
     * @param payPwdVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "setPayPwd",method = RequestMethod.POST)
    public BaseResponseVO setPayPwd(@RequestBody PayPwdVo payPwdVo) throws CommonServiceExcetion {
        Integer userId = Integer.valueOf(TraceUtil.getUserId());//获取当前登录用户的id
        payPwdVo.setId(userId);
        boolean isSuccess = userService.setPayPwd(payPwdVo);
        if (!isSuccess) {
            return BaseResponseVO.serviceFailed("设置支付密码失败！");
        }
        return BaseResponseVO.success();
    }

    /**
     * 消费
     * @param payPwdVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "consum",method = RequestMethod.POST)
    public BaseResponseVO consum(@RequestBody PayPwdVo payPwdVo) throws CommonServiceExcetion {
        Integer userId = Integer.valueOf(TraceUtil.getUserId());//获取当前登录用户的id
        payPwdVo.setId(userId);
        boolean isSuccess = userService.consum(payPwdVo);
        if (!isSuccess) {
            return BaseResponseVO.serviceFailed("设置支付密码失败！");
        }
        return BaseResponseVO.success();
    }
}
