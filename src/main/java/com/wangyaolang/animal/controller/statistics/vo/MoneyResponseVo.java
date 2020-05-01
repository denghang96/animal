package com.wangyaolang.animal.controller.statistics.vo;

import com.wangyaolang.animal.common.utils.TimeUtils;
import lombok.Data;

@Data
public class MoneyResponseVo {
    private String type;
    private String[] date = TimeUtils.getRecentDate(6);
    private Float[] money = {0f,0f,0f,0f,0f,0f,0f};
}
