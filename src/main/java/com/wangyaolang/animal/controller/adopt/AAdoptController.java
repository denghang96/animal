package com.wangyaolang.animal.controller.adopt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.adopt.vo.QueryListVo;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.wangyaolang.animal.service.adopt.IAdoptService;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 领养s申请控制层
 */
@RequestMapping(value = "adopt/")
@RestController
public class AAdoptController {

    @Autowired
    private IAdoptService adoptService;

    /**
     * 添加申请
     * @param adoptInfoVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion, ParamErrorException {
        adoptInfoVo.checkParam();
        Integer userId = Integer.valueOf(TraceUtil.getUserId());//获取当前登录用户的id
        adoptInfoVo.setUserId(userId);
        adoptService.add(adoptInfoVo);

        return BaseResponseVO.success();
    }

    /**
     * 批量删除申请
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public BaseResponseVO del(@RequestParam(value = "delIds") List<AAdopt> list) throws CommonServiceExcetion {
        boolean isSuccess = adoptService.removeByIds(list);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除申请失败，请重试");
        }
        return BaseResponseVO.success();
    }

    /**
     * 根据id修改申请
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public BaseResponseVO updateAdopt(@RequestBody AdoptInfoVo adopt) throws CommonServiceExcetion {
        AdoptInfoVo adoptInfoVo = adoptService.updateAdopt(adopt);
        return BaseResponseVO.success(adoptInfoVo);
    }

    /**
     * 根据id查询申请
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public BaseResponseVO getById(Integer id) throws CommonServiceExcetion {
        AAdopt aAdopt = adoptService.getById(id);
        return BaseResponseVO.success(aAdopt);
    }

    /**
     * 根据查询条件查询动物列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<AdoptInfoVo> list = adoptService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }
}
