package com.wangyaolang.animal.service.interview;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.interview.vo.InterviewInfoVo;
import com.wangyaolang.animal.controller.interview.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AInterview;
import com.wangyaolang.animal.dao.mapper.AInterviewMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("interviewService")
public class InterviewService extends ServiceImpl<AInterviewMapper, AInterview> implements IInterviewService {

    @Resource
    private AInterviewMapper aInterviewMapper;

    @Override
    @Transactional
    public void add(InterviewInfoVo interviewInfoVo) throws CommonServiceExcetion {
        AInterview aInterview = new AInterview();
        BeanUtils.copyProperties(interviewInfoVo,aInterview); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        // 数据插入
        int isSuccess = aInterviewMapper.insert(aInterview);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加领养回执失败");
        }
    }

    @Override
    @Transactional
    public InterviewInfoVo updateInterview(InterviewInfoVo interviewInfoVo) throws CommonServiceExcetion {
        AInterview aInterview = new AInterview();
        BeanUtils.copyProperties(interviewInfoVo,aInterview); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aInterviewMapper.updateById(aInterview);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑领养回执失败");
        }

        return interviewInfoVo;
    }

    @Override
    public List<InterviewInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aInterviewMapper.getList(page, queryListVo);
    }

    @Override
    public boolean deleteBatchByIds(ArrayList<Integer> delIds) {
        return aInterviewMapper.deleteBatchIds(delIds)>0?true:false;
    }
}
