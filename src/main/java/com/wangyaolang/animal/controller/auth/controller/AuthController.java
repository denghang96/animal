package com.wangyaolang.animal.controller.auth.controller;

import com.wangyaolang.animal.controller.auth.util.JwtTokenUtil;
import com.wangyaolang.animal.controller.auth.vo.AuthRequestVO;
import com.wangyaolang.animal.controller.auth.vo.AuthResponseVO;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login/")
public class AuthController {
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 登录
     * @param authRequestVO
     * @return
     * @throws ParamErrorException
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public BaseResponseVO auth(@RequestBody AuthRequestVO authRequestVO) throws ParamErrorException, CommonServiceExcetion {

        //输入格式的检查
        authRequestVO.checkParam();

        //检查账号密码是否正确
        boolean isValid = userService.userAuth(authRequestVO.getUserName()
                , authRequestVO.getLoginPwd(), authRequestVO.getUserType());

        if(isValid){
            String randomKey = jwtTokenUtil.getRandomKey();
            String token = jwtTokenUtil.generateToken(authRequestVO.getUserName(),randomKey);

            AuthResponseVO authResponseVO = AuthResponseVO.builder()
                    .randomKey(randomKey)
                    .token(token).build();  //这段代码等价于AuthResponseVO authResponseVO = new AuthResponseVO(randomKey,token)

            return BaseResponseVO.success(authResponseVO);
        }else{
            return BaseResponseVO.serviceFailed(1,"用户名或密码不正确！！");
        }

    }
}
