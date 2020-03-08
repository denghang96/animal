package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 动物基本信息实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
@Data
public class AAnimal extends Model<AAnimal> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String animalType;

    private String animalNo;

    private String animalName;

    private Integer animalAge;

    private String animalImg;

    private String animalTiltleImg;

    private String animalFeatures;

    private String projectType;

    private String animalStatus;

    private Integer animalMoney;

    private String animalDate;

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
