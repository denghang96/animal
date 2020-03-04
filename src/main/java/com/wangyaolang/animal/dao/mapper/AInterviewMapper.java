package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.interview.vo.InterviewInfoVo;
import com.wangyaolang.animal.controller.interview.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AInterview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public interface AInterviewMapper extends BaseMapper<AInterview> {

    List<InterviewInfoVo> getList(Page page,@Param("queryListVo")  QueryListVo queryListVo);
}
