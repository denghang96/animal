package com.wangyaolang.animal.controller.statistics.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class WebsiteNumVo extends BaseVO {
    /*
        用户总数
     */
    private Integer userNum;
    /*
        动物总数
     */
    private Integer animalNum;
    /*
        评论总数
     */
    private Integer commentNum;
    /*
        今日领养
     */
    private Integer todayAdopt;
    /*
        今日寄养
     */
    private Integer todayFoster;
    /*
        今日助养
     */
    private Integer todaySupport;
    @Override
    public void checkParam() throws ParamErrorException {

    }
}
