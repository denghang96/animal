package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 领养回访实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
@Data
public class AInterview extends Model<AInterview> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String userTel;

    private Integer userId;

    private String adoptDate;

    private Integer animalId;

    private String adoptDesc;

    public Integer getId() {
        return id;
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
        ", animalId=" + animalId +
        ", adoptDesc=" + adoptDesc +
        "}";
    }
}
