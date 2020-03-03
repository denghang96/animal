package com.wangyaolang.animal.controller.animal;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.animal.vo.AnimalInfoVo;
import com.wangyaolang.animal.controller.animal.vo.QueryListVo;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.service.animal.IAnimalService;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "animal/")
public class AAnimalController {

    @Autowired
    private IAnimalService animalService;

    /**
     * 新增动物
     * @param aAnimal
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody AnimalInfoVo aAnimal) throws CommonServiceExcetion, ParamErrorException {
        aAnimal.checkParam();

        animalService.add(aAnimal);

        return BaseResponseVO.success();
    }

    /**
     * 批量删除动物信息
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public BaseResponseVO del(@RequestParam(value = "delIds") List<AAnimal> list) throws CommonServiceExcetion {
        boolean isSuccess = animalService.removeByIds(list);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除动物时出错，请重试");
        }
        return BaseResponseVO.success();
    }

    /**
     * 根据id修改动物信息
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public BaseResponseVO updateAnimal(@RequestBody AnimalInfoVo aAnimal) throws CommonServiceExcetion {
        AnimalInfoVo animalInfoVo = animalService.updateAnimal(aAnimal);
        return BaseResponseVO.success(animalInfoVo);
    }

    /**
     * 根据动物id查询动物
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "update",method = RequestMethod.GET)
    public BaseResponseVO updateAnimal(Integer id) throws CommonServiceExcetion {
        AAnimal aAnimal = animalService.getById(id);
        return BaseResponseVO.success(aAnimal);
    }

    /**
     * 根据动物查询条件查询动物列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<AnimalInfoVo> list = animalService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }
}
