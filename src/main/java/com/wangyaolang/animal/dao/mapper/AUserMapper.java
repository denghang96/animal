package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.user.vo.QueryListVo;
import com.wangyaolang.animal.controller.user.vo.UserInfoVO;
import com.wangyaolang.animal.dao.entity.AUser;
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
public interface AUserMapper extends BaseMapper<AUser> {
    /*
    根据条件查询用户列表
     */
    List<UserInfoVO> getList(Page page, @Param("queryListVo") QueryListVo queryListVo);
}
