package com.wangyaolang.animal.controller.consume.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConsumeInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String userName;

    private String consumeDate;

    private String type;

    private Float money;

    private String animalNo;

    private String animalName;
}
