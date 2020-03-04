package com.wangyaolang.animal.service.support;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.supprot.vo.QueryListVo;
import com.wangyaolang.animal.controller.supprot.vo.SupportInfoVo;
import com.wangyaolang.animal.dao.entity.ASupport;
import com.wangyaolang.animal.dao.mapper.ASupportMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("supprortService")
public class SupprortService extends ServiceImpl<ASupportMapper, ASupport> implements ISupportService{

    @Resource
    private ASupportMapper aSupportMapper;

    @Override
    @Transactional
    public void add(SupportInfoVo supportInfoVo) throws CommonServiceExcetion {
        ASupport aSupport = new ASupport();
        BeanUtils.copyProperties(supportInfoVo,aSupport); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        // 数据插入
        int isSuccess = aSupportMapper.insert(aSupport);
        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"助养失败！请重试");
        }
    }

    @Override
    @Transactional
    public SupportInfoVo updateSupport(SupportInfoVo supportInfoVo) throws CommonServiceExcetion {
        ASupport aSupport = new ASupport();
        BeanUtils.copyProperties(supportInfoVo,aSupport); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aSupportMapper.updateById(aSupport);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑失败！请重试");
        }

        return supportInfoVo;
    }

    @Override
    public List<SupportInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aSupportMapper.getList(page, queryListVo);
    }
}
