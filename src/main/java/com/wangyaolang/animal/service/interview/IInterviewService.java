package com.wangyaolang.animal.service.interview;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.interview.vo.InterviewInfoVo;
import com.wangyaolang.animal.controller.interview.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AInterview;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.List;

public interface IInterviewService  extends IService<AInterview> {
    /**
     * 新增动物
     * @param interviewInfoVo
     */
    void add(InterviewInfoVo interviewInfoVo) throws CommonServiceExcetion;

    /**
     * 修改动物
     * @param interviewInfoVo
     * @return
     */
    InterviewInfoVo updateInterview(InterviewInfoVo interviewInfoVo) throws CommonServiceExcetion;

    /**
     * 根据条件查询动物信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<InterviewInfoVo> getList(Page page, QueryListVo queryListVo);
}
