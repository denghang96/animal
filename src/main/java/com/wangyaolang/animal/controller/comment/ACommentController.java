package com.wangyaolang.animal.controller.comment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.comment.vo.CommentInfoVo;
import com.wangyaolang.animal.controller.comment.vo.QueryListVo;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.common.TraceUtil;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import com.wangyaolang.animal.dao.entity.AComment;
import com.wangyaolang.animal.service.comment.ICommentService;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 领养s申请控制层
 */
@RequestMapping(value = "comment/")
@RestController
public class ACommentController {

    @Autowired
    private ICommentService commentService;

    /**
     * 评论
     * @param commentInfoVo
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseResponseVO add(@RequestBody CommentInfoVo commentInfoVo) throws CommonServiceExcetion, ParamErrorException {
        commentInfoVo.checkParam();
        Integer userId = Integer.valueOf(TraceUtil.getUserId());//获取当前登录用户的id
        commentInfoVo.setUserId(userId);
        commentService.add(commentInfoVo);

        return BaseResponseVO.success();
    }

    /**
     * 批量删除
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public BaseResponseVO del(@RequestBody ArrayList<Integer> delIds) throws CommonServiceExcetion {
        boolean isSuccess = commentService.removeByIds(delIds);
        if (!isSuccess) {
            throw new CommonServiceExcetion(500,"删除失败，请重试");
        }
        return BaseResponseVO.success();
    }

    /**
     * 根据id修评论
     * @return
     * @throws CommonServiceExcetion
     * @throws ParamErrorException
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseResponseVO updateComment(@RequestBody CommentInfoVo comment) throws CommonServiceExcetion {
        CommentInfoVo commentInfoVo = commentService.updateComment(comment);
        return BaseResponseVO.success(commentInfoVo);
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public BaseResponseVO getById(Integer id) throws CommonServiceExcetion {
        AComment comment = commentService.getById(id);
        return BaseResponseVO.success(comment);
    }

    /**
     * 根据查询条件查询评论列表
     * @param queryListVo
     * @return
     * @throws CommonServiceExcetion
     */
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public BaseResponseVO getList(Page page, QueryListVo queryListVo) throws CommonServiceExcetion {
        List<CommentInfoVo> list = commentService.getList(page, queryListVo);
        page.setRecords(list);
        return BaseResponseVO.success(page);
    }


}
