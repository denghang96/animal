package com.wangyaolang.animal.service.animal;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.animal.vo.AnimalInfoVo;
import com.wangyaolang.animal.controller.animal.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.ArrayList;
import java.util.List;

public interface IAnimalService extends IService<AAnimal> {
    /**
     * 新增动物
     * @param aAnimal
     */
    void add(AnimalInfoVo aAnimal) throws CommonServiceExcetion;

    /**
     * 修改动物
     * @param aAnimal
     * @return
     */
    AnimalInfoVo updateAnimal(AnimalInfoVo aAnimal) throws CommonServiceExcetion;

    /**
     * 根据条件查询动物信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<AnimalInfoVo> getList(Page page, QueryListVo queryListVo);


    /**
     * 根据id批量删除
     * @param delIds
     * @return
     */
    boolean deleteBatchByIds(ArrayList<Integer> delIds);
}
