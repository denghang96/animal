package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.adopt.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyaolang
 * @since 2020-02-29
 */
public interface AAdoptMapper extends BaseMapper<AAdopt> {

    List<AdoptInfoVo> getList(Page page, @Param("queryListVo") QueryListVo queryListVo);
}
