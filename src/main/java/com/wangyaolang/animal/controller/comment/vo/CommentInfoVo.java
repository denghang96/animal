package com.wangyaolang.animal.controller.comment.vo;

import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class CommentInfoVo extends BaseVO {

    private Integer id;

    private Integer userId;

    private String comment;

    private Integer animalId;

    private String animalName;

    private String animalNo;

    private String userName;

    private String userImage;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
