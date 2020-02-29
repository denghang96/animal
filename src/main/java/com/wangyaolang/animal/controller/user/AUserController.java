package com.wangyaolang.animal.controller.user;

import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.controller.user.vo.EnrollUserVO;
import com.wangyaolang.animal.controller.user.vo.UserInfoVO;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user/")
public class AUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResponseVO register(@RequestBody EnrollUserVO enrollUserVO) throws CommonServiceExcetion, ParamErrorException {
        enrollUserVO.checkParam();

        userService.userEnroll(enrollUserVO);

        return BaseResponseVO.success();
    }



    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public BaseResponseVO describeUserInfo() throws CommonServiceExcetion, ParamErrorException {

        String userId = TraceUtil.getUserId();

        UserInfoVO userInfoVO = userService.describeUserInfo(userId);

        userInfoVO.checkParam();

        return BaseResponseVO.success(userInfoVO);
    }
}
