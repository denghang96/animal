package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.foster.vo.FosterInfoVo;
import com.wangyaolang.animal.controller.foster.vo.QueryListVo;
import com.wangyaolang.animal.controller.foster.vo.SettleResponseVo;
import com.wangyaolang.animal.dao.entity.AFoster;
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
public interface AFosterMapper extends BaseMapper<AFoster> {
    List<FosterInfoVo> getList(Page page,@Param("queryListVo") QueryListVo queryListVo);

    SettleResponseVo getMoney(@Param("fosterId") Integer fosterId);
}
