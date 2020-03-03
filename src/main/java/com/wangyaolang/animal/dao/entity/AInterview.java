package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 领养回访实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AInterview extends Model<AInterview> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private Integer userTel;

    private Integer userId;

    private String adoptDate;

    private Integer adopAnimalId;

    private String adoptDesc;

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

    public Integer getUserTel() {
        return userTel;
    }

    public void setUserTel(Integer userTel) {
        this.userTel = userTel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(String adoptDate) {
        this.adoptDate = adoptDate;
    }

    public Integer getAdopAnimalId() {
        return adopAnimalId;
    }

    public void setAdopAnimalId(Integer adopAnimalId) {
        this.adopAnimalId = adopAnimalId;
    }

    public String getAdoptDesc() {
        return adoptDesc;
    }

    public void setAdoptDesc(String adoptDesc) {
        this.adoptDesc = adoptDesc;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AInterview{" +
        ", id=" + id +
        ", userName=" + userName +
        ", userTel=" + userTel +
        ", userId=" + userId +
        ", adoptDate=" + adoptDate +
        ", adopAnimalId=" + adopAnimalId +
        ", adoptDesc=" + adoptDesc +
        "}";
    }
}
