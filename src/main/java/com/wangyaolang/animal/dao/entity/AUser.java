package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 用户基本信息实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AUser extends Model<AUser> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 电话
     */
    private String userTel;

    /**
     * 支付密码
     */
    private String payPwd;

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
    private Integer userMoney = 0;

    /**
     * 会员到期日期
     */
    private String expireTime = "1970-01-01";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AUser{" +
        ", id=" + id +
        ", userName=" + userName +
        ", loginPwd=" + loginPwd +
        ", userTel=" + userTel +
        ", payPwd=" + payPwd +
        ", userAge=" + userAge +
        ", userSex=" + userSex +
        ", userImage=" + userImage +
        ", userType=" + userType +
        ", userMoney=" + userMoney +
        ", expireTime=" + expireTime +
        "}";
    }
}
