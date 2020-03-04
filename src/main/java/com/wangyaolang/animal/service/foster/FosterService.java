package com.wangyaolang.animal.service.foster;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.foster.vo.FosterInfoVo;
import com.wangyaolang.animal.controller.foster.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AFoster;
import com.wangyaolang.animal.dao.mapper.AFosterMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("fosterService")
public class FosterService extends ServiceImpl<AFosterMapper, AFoster> implements IFosterService {

    @Resource
    private AFosterMapper aFosterMapper;

    @Override
    @Transactional
    public void add(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        AFoster aFoster = new AFoster();
        BeanUtils.copyProperties(fosterInfoVo,aFoster); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        // 数据插入
        int isSuccess = aFosterMapper.insert(aFoster);
        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加申请失败");
        }
    }

    @Override
    @Transactional
    public FosterInfoVo updateFoster(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        AFoster aFoster = new AFoster();
        BeanUtils.copyProperties(fosterInfoVo,aFoster); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aFosterMapper.updateById(aFoster);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑申请失败");
        }

        return fosterInfoVo;
    }

    @Override
    public List<FosterInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aFosterMapper.getList(page, queryListVo);
    }
}
