package com.wangyaolang.animal.controller.interview;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.controller.interview.vo.InterviewInfoVo;
import com.wangyaolang.animal.controller.interview.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AInterview;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.interview.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 领养s申请控制层
 */
@RequestMapping(value = "adopt")
@RestController
public class AInterviewController {

    @Autowired
    private IInterviewService interviewService;

    /**
     * 添加申请
     * @param interviewInfoVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody InterviewInfoVo interviewInfoVo) throws CommonServiceExcetion, ParamErrorException {
        interviewInfoVo.checkParam();
        interviewService.add(interviewInfoVo);

        return BaseResponseVO.success();
    }

    /**
     * 批量删除
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public BaseResponseVO del(@RequestParam(value = "delIds") List<AInterview> list) throws CommonServiceExcetion {
        boolean isSuccess = interviewService.removeByIds(list);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除申请，请重试");
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
    public BaseResponseVO updateInterview(@RequestBody InterviewInfoVo interview) throws CommonServiceExcetion {
        InterviewInfoVo interviewInfoVo = interviewService.updateInterview(interview);
        return BaseResponseVO.success(interviewInfoVo);
    }

    /**
     * 根据id查询申请
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public BaseResponseVO getById(Integer id) throws CommonServiceExcetion {
        AInterview interview = interviewService.getById(id);
        return BaseResponseVO.success(interview);
    }

    /**
     * 根据查询条件查询动物列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<InterviewInfoVo> list = interviewService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }

}
