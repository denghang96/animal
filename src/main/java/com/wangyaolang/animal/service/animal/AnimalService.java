package com.wangyaolang.animal.service.animal;

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
import java.util.List;

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

        // 数据插入
        int isSuccess = animalMapper.insert(aAnimal);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加用户失败");
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
            throw new CommonServiceExcetion(501,"修改用户信息失败");
        }

        return animalInfoVo;
    }

    @Override
    public List<AnimalInfoVo> getList(Page page, QueryListVo queryListVo) {
        return animalMapper.getList(page, queryListVo);
    }
}
