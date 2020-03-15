package com.wangyaolang.animal.service.consume;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.consume.vo.ConsumeInfoVo;
import com.wangyaolang.animal.controller.consume.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-03-14
 */
public interface IAConsumeService extends IService<AConsume> {

    /**
     * 查询消费列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<ConsumeInfoVo> getList(Page page, QueryListVo queryListVo);
}
