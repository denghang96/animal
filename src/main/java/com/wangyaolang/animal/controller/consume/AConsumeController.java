package com.wangyaolang.animal.controller.consume;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.consume.vo.ConsumeInfoVo;
import com.wangyaolang.animal.controller.consume.vo.QueryListVo;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.consume.IAConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  消费记录控制器
 * </p>
 *
 * @author wangyaolang
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/consume")
public class AConsumeController {

    @Autowired
    private IAConsumeService consumeService;
    /**
     * 查询消费记录
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<ConsumeInfoVo> list = consumeService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }
}
