package com.wangyaolang.animal.service.adopt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.adopt.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.List;


public interface IAdoptService extends IService<AAdopt> {

    /**
     * 申请
     * @param adoptInfoVo
     */
    void add(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion;

    /**
     * 编辑申请信息
     * @param adoptInfoVo
     * @return
     */
    AdoptInfoVo updateAdopt(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion;

    /**
     * 根据条件查询申请信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<AdoptInfoVo> getList(Page page, QueryListVo queryListVo);

    /**
     * 审核领养申请
     * @param adopt
     * @return
     */
    AdoptInfoVo sh(AdoptInfoVo adopt) throws CommonServiceExcetion;
}
