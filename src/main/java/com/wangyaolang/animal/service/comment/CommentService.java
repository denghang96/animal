package com.wangyaolang.animal.service.comment;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.controller.comment.vo.CommentInfoVo;
import com.wangyaolang.animal.controller.comment.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AComment;
import com.wangyaolang.animal.dao.mapper.ACommentMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentService extends ServiceImpl<ACommentMapper, AComment> implements ICommentService {
    @Resource
    private ACommentMapper aCommentMapper;

    @Override
    @Transactional
    public void add(CommentInfoVo commentInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AComment aComment = new AComment();
        BeanUtils.copyProperties(commentInfoVo,aComment); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aCommentMapper.insert(aComment);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"评论失败");
        }
    }

    @Override
    @Transactional
    public CommentInfoVo updateComment(CommentInfoVo commentInfoVo) throws CommonServiceExcetion {
        AComment aComment = new AComment();
        BeanUtils.copyProperties(commentInfoVo,aComment); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aCommentMapper.updateById(aComment);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑评论失败");
        }

        return commentInfoVo;
    }

    @Override
    public List<CommentInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aCommentMapper.getList(page, queryListVo);
    }
}
