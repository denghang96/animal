package com.wangyaolang.animal.service.animal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.animal.vo.AnimalInfoVo;
import com.wangyaolang.animal.controller.animal.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.mapper.AAnimalMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(("animalService"))
public class AnimalService extends ServiceImpl<AAnimalMapper, AAnimal> implements IAnimalService  {

    @Resource
    private AAnimalMapper animalMapper;

    @Override
    @Transactional
    public void add(AnimalInfoVo animalInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAnimal aAnimal = new AAnimal();
        BeanUtils.copyProperties(animalInfoVo,aAnimal); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        QueryWrapper queryWrapper = new QueryWrapper(); //判断动物编号是否重复
        queryWrapper.eq("animal_no", aAnimal.getAnimalNo());
        Integer integer = animalMapper.selectCount(queryWrapper);
        if (integer > 0) {
            throw new CommonServiceExcetion(501,"动物编号重复！添加失败");
        }
        // 数据插入
        int isSuccess = animalMapper.insert(aAnimal);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加动物失败");
        }
    }

    @Override
    @Transactional
    public AnimalInfoVo updateAnimal(AnimalInfoVo animalInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAnimal aAnimal = new AAnimal();
        BeanUtils.copyProperties(animalInfoVo,aAnimal); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = animalMapper.updateById(aAnimal);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"修改动物信息失败");
        }

        return animalInfoVo;
    }

    /**
     * 管理员处查询动物列表
     * @param page
     * @param queryListVo
     * @return
     */
    @Override
    public List<AnimalInfoVo> getList(Page page, QueryListVo queryListVo) {
        return animalMapper.getList(page, queryListVo);
    }

    @Override
    public boolean deleteBatchByIds(ArrayList<Integer> delIds) {
        return animalMapper.deleteBatchIds(delIds)>0?true:false;
    }

}
