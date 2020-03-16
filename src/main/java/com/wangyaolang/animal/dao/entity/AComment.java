package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 评论实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
@Data
public class AComment extends Model<AComment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String comment;

    private Integer animalId;



    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AComment{" +
        ", id=" + id +
        ", userId=" + userId +
        ", comment=" + comment +
        ", amimalId=" + animalId +
        "}";
    }
}
