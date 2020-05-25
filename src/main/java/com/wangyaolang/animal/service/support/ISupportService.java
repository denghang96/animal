package com.wangyaolang.animal.service.support;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.supprot.vo.QueryListVo;
import com.wangyaolang.animal.controller.supprot.vo.SupportInfoVo;
import com.wangyaolang.animal.dao.entity.ASupport;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.List;

public interface ISupportService  extends IService<ASupport> {
    /**
     * 新增
     * @param supportInfoVo
     */
    void add(SupportInfoVo supportInfoVo) throws CommonServiceExcetion;

    /**
     * 编辑申请信息
     * @param supportInfoVo
     * @return
     */
    SupportInfoVo updateSupport(SupportInfoVo supportInfoVo) throws CommonServiceExcetion;

    /**
     * 根据条件查询申请信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<SupportInfoVo> getList(Page page, QueryListVo queryListVo);

    /**
     * 要删除的主键
     * @param delIds
     * @return
     */
    boolean deleteBatchByIds(List<Integer> delIds);
}
