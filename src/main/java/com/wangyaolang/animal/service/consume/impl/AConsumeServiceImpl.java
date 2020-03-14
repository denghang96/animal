package com.wangyaolang.animal.service.consume.impl;

import com.wangyaolang.animal.dao.entity.AConsume;
import com.wangyaolang.animal.dao.mapper.AConsumeMapper;
import com.wangyaolang.animal.dao.mapper.AFosterMapper;
import com.wangyaolang.animal.service.consume.IAConsumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyaolang
 * @since 2020-03-14
 */
@Service("consumeService")
public class AConsumeServiceImpl extends ServiceImpl<AConsumeMapper, AConsume> implements IAConsumeService {

    @Resource
    private AConsumeMapper aConsumeMapper;
}
