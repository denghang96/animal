package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.consume.vo.ConsumeInfoVo;
import com.wangyaolang.animal.controller.consume.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyaolang
 * @since 2020-03-14
 */
public interface AConsumeMapper extends BaseMapper<AConsume> {

    List<ConsumeInfoVo> getList(Page page, @Param("queryListVo") QueryListVo queryListVo);
}
