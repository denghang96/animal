package com.wangyaolang.animal.controller.auth.vo;


import com.wangyaolang.animal.controller.common.BaseVO;
import com.wangyaolang.animal.controller.exception.ParamErrorException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseVO extends BaseVO {

    private String randomKey;
    private String token;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
