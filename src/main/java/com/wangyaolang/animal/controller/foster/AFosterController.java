package com.wangyaolang.animal.controller.foster;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.controller.foster.vo.*;
import com.wangyaolang.animal.dao.entity.AFoster;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.foster.IFosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "foster/")
public class AFosterController {

    @Autowired
    private IFosterService fosterService;


    /**
     * 添加寄样申请
     * @param fosterInfoVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody FosterInfoVo fosterInfoVo) throws CommonServiceExcetion, ParamErrorException {
        fosterInfoVo.checkParam();
        //获取当前登录用户的id
        Integer userId = Integer.valueOf(TraceUtil.getUserId());
        fosterInfoVo.setUserId(userId);
        fosterService.add(fosterInfoVo);
        return BaseResponseVO.success();
    }

    /**
     * 批量删除申请
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public BaseResponseVO del(@RequestBody List<String> list) throws CommonServiceExcetion {
        boolean isSuccess = fosterService.deleteBatchByIds(list);
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
    public BaseResponseVO updateFoster(@RequestBody FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        FosterInfoVo foster = fosterService.updateFoster(fosterInfoVo);
        return BaseResponseVO.success(foster);
    }

    /**
     * 根据id查询申请
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public BaseResponseVO getById(Integer id) throws CommonServiceExcetion {
        AFoster aFoster = fosterService.getById(id);
        return BaseResponseVO.success(aFoster);
    }

    /**
     * 根据动物查询条件查询动物列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<FosterInfoVo> list = fosterService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }

    /**
     * 审核申请
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "sh",method = RequestMethod.POST)
    public BaseResponseVO sh(@RequestBody FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        fosterService.sh(fosterInfoVo);
        return BaseResponseVO.success();
    }


    /**
     * 宠物到店
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "arrive",method = RequestMethod.POST)
    public BaseResponseVO arrive(@RequestBody ArriveInfoVo arriveInfoVo){
        fosterService.arrive(arriveInfoVo);
        return BaseResponseVO.success();
    }

    /**
     * 重置申请状态
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "reset")
    public BaseResponseVO arrive(Integer fosterId){
        fosterService.reset(fosterId);
        return BaseResponseVO.success();
    }

    /**
     * 结算前查询费用
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "getMoney")
    public BaseResponseVO getMoney(SettleResquestVo settleResquestVo) throws ParseException {
        SettleResponseVo settleResponseVo = fosterService.getMoney(settleResquestVo.getFosterId(), settleResquestVo.getSettleDate());
        return BaseResponseVO.success(settleResponseVo);
    }

    /**
     * 结算
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "settle",method = RequestMethod.POST)
    public BaseResponseVO settle(@RequestBody SettleVo settleVo){
        fosterService.settle(settleVo);
        return BaseResponseVO.success();
    }
}
