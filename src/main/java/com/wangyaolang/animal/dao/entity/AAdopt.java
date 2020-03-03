package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 领养申请实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AAdopt extends Model<AAdopt> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer animalId;

    private String applyDate;

    private Integer applyStatus;

    private String adoptTel;

    private Integer adoptAddress;

    private String adoptReason;

    private String familyDesc;

    private String familyImg;

    private String hasChildren;

    private String traffiType;

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

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getAdoptTel() {
        return adoptTel;
    }

    public void setAdoptTel(String adoptTel) {
        this.adoptTel = adoptTel;
    }

    public Integer getAdoptAddress() {
        return adoptAddress;
    }

    public void setAdoptAddress(Integer adoptAddress) {
        this.adoptAddress = adoptAddress;
    }

    public String getAdoptReason() {
        return adoptReason;
    }

    public void setAdoptReason(String adoptReason) {
        this.adoptReason = adoptReason;
    }

    public String getFamilyDesc() {
        return familyDesc;
    }

    public void setFamilyDesc(String familyDesc) {
        this.familyDesc = familyDesc;
    }

    public String getFamilyImg() {
        return familyImg;
    }

    public void setFamilyImg(String familyImg) {
        this.familyImg = familyImg;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getTraffiType() {
        return traffiType;
    }

    public void setTraffiType(String traffiType) {
        this.traffiType = traffiType;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AAdopt{" +
        ", id=" + id +
        ", userId=" + userId +
        ", animalId=" + animalId +
        ", applyDate=" + applyDate +
        ", applyStatus=" + applyStatus +
        ", adoptTel=" + adoptTel +
        ", adoptAddress=" + adoptAddress +
        ", adoptReason=" + adoptReason +
        ", familyDesc=" + familyDesc +
        ", familyImg=" + familyImg +
        ", hasChildren=" + hasChildren +
        ", traffiType=" + traffiType +
        "}";
    }
}
