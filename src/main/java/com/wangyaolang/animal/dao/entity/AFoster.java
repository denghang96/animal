package com.wangyaolang.animal.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 寄样申请实体类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
@Data
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

    private String applyStatus;

    private String userTel;

    private Integer applyPrice;

    private String opinion;

    private Integer animalId;


}
