package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 寄样申请实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AFoster extends Model<AFoster> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String animalName;

    private String animalType;

    private Integer animalAge;

    private String applyDate;

    private String animalDesc;

    private String animalProve;

    private Integer applyStatus;

    private String userTel;

    private Integer applyPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Integer getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Integer animalAge) {
        this.animalAge = animalAge;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public String getAnimalProve() {
        return animalProve;
    }

    public void setAnimalProve(String animalProve) {
        this.animalProve = animalProve;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(Integer applyPrice) {
        this.applyPrice = applyPrice;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AFoster{" +
        ", id=" + id +
        ", userId=" + userId +
        ", animalName=" + animalName +
        ", animalType=" + animalType +
        ", animalAge=" + animalAge +
        ", applyDate=" + applyDate +
        ", animalDesc=" + animalDesc +
        ", animalProve=" + animalProve +
        ", applyStatus=" + applyStatus +
        ", userTel=" + userTel +
        ", applyPrice=" + applyPrice +
        "}";
    }
}
