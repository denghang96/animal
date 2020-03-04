package com.wangyaolang.animal.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.comment.vo.CommentInfoVo;
import com.wangyaolang.animal.controller.comment.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AComment;
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
public interface ACommentMapper extends BaseMapper<AComment> {

    List<CommentInfoVo> getList(Page page,@Param("queryListVo") QueryListVo queryListVo);
}
