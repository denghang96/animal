package com.wangyaolang.animal.controller.supprot;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.controller.supprot.vo.QueryListVo;
import com.wangyaolang.animal.controller.supprot.vo.SupportInfoVo;
import com.wangyaolang.animal.dao.entity.ASupport;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.support.ISupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("support/")
@RestController
public class SupportController {
    @Autowired
    private ISupportService supportService;


    /**
     * 添加助养信息
     * @param supportInfoVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody SupportInfoVo supportInfoVo) throws CommonServiceExcetion, ParamErrorException {
        supportInfoVo.checkParam();
        //获取当前登录用户的id
        Integer userId = Integer.valueOf(TraceUtil.getUserId());
        supportInfoVo.setUserId(userId);
        supportService.add(supportInfoVo);
        return BaseResponseVO.success();
    }

    /**
     * 批量删除
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public BaseResponseVO del(@RequestBody List<Integer> delIds) throws CommonServiceExcetion {
        boolean isSuccess = supportService.deleteBatchByIds(delIds);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除失败，请重试");
        }
        return BaseResponseVO.success();
    }

    /**
     * 根据id修改
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public BaseResponseVO updateSupport(@RequestBody SupportInfoVo supportInfoVo) throws CommonServiceExcetion {
        SupportInfoVo foster = supportService.updateSupport(supportInfoVo);
        return BaseResponseVO.success(foster);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public BaseResponseVO getById(Integer id) throws CommonServiceExcetion {
        ASupport aSupport = supportService.getById(id);
        return BaseResponseVO.success(aSupport);
    }

    /**
     * 根据动物查询条件查询动物列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<SupportInfoVo> list = supportService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }
}
