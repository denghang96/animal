package com.wangyaolang.animal.service.adopt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.adopt.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.wangyaolang.animal.dao.mapper.AAdoptMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class AdoptService extends ServiceImpl<AAdoptMapper, AAdopt> implements IAdoptService {

    @Resource
    private AAdoptMapper aAdoptMapper;

    @Override
    @Transactional
    public void add(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAdopt aAdopt = new AAdopt();
        BeanUtils.copyProperties(adoptInfoVo,aAdopt); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aAdoptMapper.insert(aAdopt);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加申请失败");
        }
    }

    @Override
    @Transactional
    public AdoptInfoVo updateAdopt(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAdopt aAdopt = new AAdopt();
        BeanUtils.copyProperties(adoptInfoVo,aAdopt); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aAdoptMapper.updateById(aAdopt);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑申请失败");
        }

        return adoptInfoVo;
    }

    @Override
    public List<AdoptInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aAdoptMapper.getList(page, queryListVo);
    }
}
