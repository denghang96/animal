package com.wangyaolang.animal.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangyaolang.animal.common.utils.MD5Util;
import com.wangyaolang.animal.common.utils.ToolUtils;
import com.wangyaolang.animal.controller.user.vo.EnrollUserVO;
import com.wangyaolang.animal.controller.user.vo.UserInfoVO;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AUserMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService implements IUserService{

    @Resource
    private AUserMapper aUserMapper;

    @Override
    public void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceExcetion {
        // EnrollUserVO -> AUser 转换
        AUser aUser = new AUser();
        BeanUtils.copyProperties(enrollUserVO,aUser);
        aUser.setLoginPwd(MD5Util.encrypt(enrollUserVO.getLoginPwd()));

        // 数据插入
        int isSuccess = aUserMapper.insert(aUser);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"用户登记失败！");
        }
    }

    @Override
    public boolean checkUserName(String userName) throws CommonServiceExcetion {
        return false;
    }

    @Override
    public boolean userAuth(String userName, String userPwd) throws CommonServiceExcetion {
        if(ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(userPwd)){
            throw new CommonServiceExcetion(400,"用户验证失败！");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        // 1、判断用户名是否存在
        List<AUser> list = aUserMapper.selectList(queryWrapper);
        if(list.size() == 0){
            return false;
        }else {
            // 2、如果存在，则判断密码是否正确
            AUser aUser = list.get(0);
            // 3、对用户输入的密码进行MD5加密，然后判断两个密码是否相等
            if(MD5Util.encrypt(userPwd).equals(aUser.getLoginPwd())){
                return true;
            }
        }
        return false;
    }

    @Override
    public UserInfoVO describeUserInfo(String userId) throws CommonServiceExcetion {
        AUser aUser = aUserMapper.selectById(userId);
        if(aUser != null && aUser.getId() != null){
            UserInfoVO userInfoVO = new UserInfoVO();
            BeanUtils.copyProperties(aUser,userInfoVO);
            return userInfoVO;
        }else{
            throw new CommonServiceExcetion(404,"用户编号为["+userId+"]的用户不存在");
        }
    }

    @Override
    public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceExcetion {
        return null;
    }
}
