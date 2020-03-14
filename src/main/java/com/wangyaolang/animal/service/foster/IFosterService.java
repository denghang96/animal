package com.wangyaolang.animal.service.foster;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.foster.vo.*;
import com.wangyaolang.animal.dao.entity.AFoster;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IFosterService extends IService<AFoster> {
    /**
     * 申请
     * @param fosterInfoVo
     */
    void add(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion;

    /**
     * 编辑申请信息
     * @param fosterInfoVo
     * @return
     */
    FosterInfoVo updateFoster(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion;

    /**
     * 根据条件查询申请信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<FosterInfoVo> getList(Page page, QueryListVo queryListVo);

    /**
     * 审核寄养申请
     * @param fosterInfoVo
     */
    void sh(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion;

    /**
     * 宠物到店
     * @param arriveInfoVo
     */
    void arrive(ArriveInfoVo arriveInfoVo) ;

    /**
     * 重置申请状态
     * @param fosterId
     */
    void reset(Integer fosterId);

    /**
     * 结算前查询费用
     * @param fosterId
     */
    SettleResponseVo getMoney(Integer fosterId, String date) throws ParseException;

    /**
     * 结算
     * @param settleVo
     */
    void settle(SettleVo settleVo);
}
