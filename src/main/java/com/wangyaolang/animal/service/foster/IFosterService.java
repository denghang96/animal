package com.wangyaolang.animal.service.foster;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.foster.vo.FosterInfoVo;
import com.wangyaolang.animal.controller.foster.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AFoster;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

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
}
