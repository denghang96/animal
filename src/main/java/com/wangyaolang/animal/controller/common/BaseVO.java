package com.wangyaolang.animal.controller.common;

import com.wangyaolang.animal.controller.exception.ParamErrorException;

public abstract class BaseVO {


    public abstract void checkParam() throws ParamErrorException;

}
