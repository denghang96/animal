package com.wangyaolang.animal.controller.supprot.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询列表的响应VO
 */
@Data
public class SupportListVo implements Serializable {

    private Integer id;

    private String animalNo;

    private String animalName;

    private String userName;

    private String helpDate;

    private Float helpMoney;

    private String animalTiltleImg;
}
