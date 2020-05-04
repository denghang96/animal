package com.wangyaolang.animal.service.user;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.common.utils.MD5Util;
import com.wangyaolang.animal.common.utils.ToolUtils;
import com.wangyaolang.animal.controller.user.vo.*;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AUserMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserService extends ServiceImpl<AUserMapper, AUser> implements IUserService{

    @Resource
    private AUserMapper aUserMapper;

    /**
     * 用户注册
     * @param enrollUserVO
     * @throws CommonServiceExcetion
     */
    @Override
    @Transactional
    public void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceExcetion {
        // EnrollUserVO -> AUser 转换
        AUser aUser = new AUser();
        BeanUtils.copyProperties(enrollUserVO,aUser); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        aUser.setLoginPwd(MD5Util.encrypt(enrollUserVO.getLoginPwd()));//密码进行加密
        // 数据插入
        int isSuccess = aUserMapper.insert(aUser);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"用户登记失败！");
        }
    }

    /**
     * 检查用户名是否存在,存在返回true,失败返回false
     * @param userName
     * @return
     * @throws CommonServiceExcetion
     */
    @Override
    public boolean checkUserName(String userName) throws CommonServiceExcetion {
        if(ToolUtils.isEmpty(userName)){
            throw new CommonServiceExcetion(400,"用户名不能为空！");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);//查询条件
        int i = aUserMapper.selectCount(queryWrapper);
        return i > 0?true:false;
    }

    /**
     * 登录的service方法
     * @param userName
     * @param userPwd
     * @return
     * @throws CommonServiceExcetion
     */
    @Override
    public AUser userAuth(String userName, String userPwd) throws CommonServiceExcetion {
        if(ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(userPwd)){
            throw new CommonServiceExcetion(400,"用户验证失败！");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        // 1、判断用户名是否存在
        List<AUser> list = aUserMapper.selectList(queryWrapper);
        if(list.size() == 0){
            return null;
        }else {
            // 2、如果存在，则判断密码是否正确
            AUser aUser = list.get(0);
            // 3、对用户输入的密码进行MD5加密，然后判断两个密码是否相等
            if(MD5Util.encrypt(userPwd).equals(aUser.getLoginPwd())){
                return aUser;
            }
        }
        return null;
    }

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     * @throws CommonServiceExcetion
     */
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

    /**
     * 根据id更新用户信息
     * @param userInfoVO
     * @return
     * @throws CommonServiceExcetion
     */
    @Override
    @Transactional
    public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceExcetion {
        AUser aUser = new AUser();
        BeanUtils.copyProperties(userInfoVO,aUser);
        aUserMapper.updateById(aUser);
        return userInfoVO;
    }

    /**
     * 查询用户列表
     * @param page
     * @param queryListVo
     * @return
     */
    @Override
    public List<UserInfoVO> getList(Page page, QueryListVo queryListVo) {
        return aUserMapper.getList(page,queryListVo);
    }

    /**
     * 重置、修改密码
     * @param rePwdVo
     * @return
     */
    @Override
    @Transactional
    public boolean rePwd(RePwdVo rePwdVo) throws CommonServiceExcetion {
        AUser aUser = new AUser();
        BeanUtils.copyProperties(rePwdVo,aUser);
        if(ToolUtils.isNotEmpty(rePwdVo.getOldPwd())){ //旧密码不为空，说明是修改密码
            AUser preAUser = aUserMapper.selectById(rePwdVo.getId());
            boolean isSuccess = userAuth(preAUser.getUserName(),rePwdVo.getOldPwd())==null?false:true;
            if (isSuccess) {
                aUser.setLoginPwd(MD5Util.encrypt(rePwdVo.getLoginPwd()));//新密码进行加密
                aUserMapper.updateById(aUser);
                return true;
            }
        } else { //旧密码为空，说明是重置密码密码
            aUser.setLoginPwd(MD5Util.encrypt("123456"));//密码进行加密
            aUserMapper.updateById(aUser);
            return true;
        }
        //aUserMapper.updateById(aUser);
        return false;
    }

    /**
     * 设置支付密码
     * @param payPwdVo
     * @return
     */
    @Override
    public boolean setPayPwd(PayPwdVo payPwdVo) {
        AUser aUser = new AUser();
        BeanUtils.copyProperties(payPwdVo,aUser); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        aUser.setPayPwd(MD5Util.encrypt(aUser.getPayPwd()));
        int i = aUserMapper.updateById(aUser);
        return i > 0?true:false;
    }

    /**
     * 消费
     * @param payPwdVo
     * @return
     */
    @Override
    public boolean consum(PayPwdVo payPwdVo) {
        AUser aUser = aUserMapper.selectById(payPwdVo.getId());
        if(Objects.equals(MD5Util.encrypt(payPwdVo.getPayPwd()), aUser.getPayPwd()) ) {
            aUser.setUserMoney(aUser.getUserMoney() - payPwdVo.getMoney());//减掉钱
            aUserMapper.updateById(aUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBatchByIds(ArrayList<Integer> delIds) {
        return aUserMapper.deleteBatchIds(delIds)>0?true:false;
    }

    @Override
    public boolean checkPayPwd(Integer userId) {
        AUser user = this.getById(userId);
        return StringUtils.isEmpty(user.getPayPwd());
    }
}
