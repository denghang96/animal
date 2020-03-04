package com.wangyaolang.animal.service.comment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangyaolang.animal.controller.comment.vo.CommentInfoVo;
import com.wangyaolang.animal.controller.comment.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AComment;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;

import java.util.List;

public interface ICommentService  extends IService<AComment> {
    /**
     * 新增动物
     * @param commentInfoVo
     */
    void add(CommentInfoVo commentInfoVo) throws CommonServiceExcetion;

    /**
     * 修改动物
     * @param comment
     * @return
     */
    CommentInfoVo updateComment(CommentInfoVo comment) throws CommonServiceExcetion;

    /**
     * 根据条件查询动物信息列表
     * @param page
     * @param queryListVo
     * @return
     */
    List<CommentInfoVo> getList(Page page, QueryListVo queryListVo);
}
