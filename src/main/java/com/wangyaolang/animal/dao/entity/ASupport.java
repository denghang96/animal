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
public class ASupport extends Model<ASupport> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String animalId;

    private String helpDate;

    private Integer helpMoney;

    private String helpDesc;

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

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getHelpDate() {
        return helpDate;
    }

    public void setHelpDate(String helpDate) {
        this.helpDate = helpDate;
    }

    public Integer getHelpMoney() {
        return helpMoney;
    }

    public void setHelpMoney(Integer helpMoney) {
        this.helpMoney = helpMoney;
    }

    public String getHelpDesc() {
        return helpDesc;
    }

    public void setHelpDesc(String helpDesc) {
        this.helpDesc = helpDesc;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ASupport{" +
        ", id=" + id +
        ", userId=" + userId +
        ", animalId=" + animalId +
        ", helpDate=" + helpDate +
        ", helpMoney=" + helpMoney +
        ", helpDesc=" + helpDesc +
        "}";
    }
}
