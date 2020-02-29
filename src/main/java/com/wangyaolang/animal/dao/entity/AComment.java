package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public class AComment extends Model<AComment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String comment;

    private Integer amimalId;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAmimalId() {
        return amimalId;
    }

    public void setAmimalId(Integer amimalId) {
        this.amimalId = amimalId;
    }

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
        ", amimalId=" + amimalId +
        "}";
    }
}
