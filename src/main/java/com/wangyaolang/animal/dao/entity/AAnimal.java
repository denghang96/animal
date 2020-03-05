package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 动物基本信息实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AAnimal extends Model<AAnimal> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String animalType;

    private Integer animalNo;

    private String animalName;

    private Integer animalAge;

    private String animalImg;

    private String animalTiltleImg;

    private String animalFeatures;

    private Integer projectType;

    private Integer animalStatus;

    private Integer animalMoney;

    private String animalDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Integer getAnimalNo() {
        return animalNo;
    }

    public void setAnimalNo(Integer animalNo) {
        this.animalNo = animalNo;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Integer getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Integer animalAge) {
        this.animalAge = animalAge;
    }

    public String getAnimalImg() {
        return animalImg;
    }

    public void setAnimalImg(String animalImg) {
        this.animalImg = animalImg;
    }

    public String getAnimalTiltleImg() {
        return animalTiltleImg;
    }

    public void setAnimalTiltleImg(String animalTiltleImg) {
        this.animalTiltleImg = animalTiltleImg;
    }

    public String getAnimalFeatures() {
        return animalFeatures;
    }

    public void setAnimalFeatures(String animalFeatures) {
        this.animalFeatures = animalFeatures;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getAnimalStatus() {
        return animalStatus;
    }

    public void setAnimalStatus(Integer animalStatus) {
        this.animalStatus = animalStatus;
    }

    public Integer getAnimalMoney() {
        return animalMoney;
    }

    public void setAnimalMoney(Integer animalMoney) {
        this.animalMoney = animalMoney;
    }

    public String getAnimalDate() {
        return animalDate;
    }

    public void setAnimalDate(String animalDate) {
        this.animalDate = animalDate;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AAnimal{" +
        ", id=" + id +
        ", animalType=" + animalType +
        ", animalNo=" + animalNo +
        ", animalName=" + animalName +
        ", animalAge=" + animalAge +
        ", animalImg=" + animalImg +
        ", animalTiltleImg=" + animalTiltleImg +
        ", animalFeatures=" + animalFeatures +
        ", projectType=" + projectType +
        ", animalStatus=" + animalStatus +
        ", animalMoney=" + animalMoney +
        ", animalDate=" + animalDate +
        "}";
    }
}
