package com.wangyaolang.animal.service.adopt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.common.utils.MD5Util;
import com.wangyaolang.animal.common.utils.ToolUtils;
import com.wangyaolang.animal.controller.user.vo.EnrollUserVO;
import com.wangyaolang.animal.controller.user.vo.QueryListVo;
import com.wangyaolang.animal.controller.user.vo.RePwdVo;
import com.wangyaolang.animal.controller.user.vo.UserInfoVO;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AAdoptMapper;
import com.wangyaolang.animal.dao.mapper.AUserMapper;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class AdoptService extends ServiceImpl<AAdoptMapper, AAdopt> implements IAdoptService {

}
