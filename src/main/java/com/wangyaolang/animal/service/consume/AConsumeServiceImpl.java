package com.wangyaolang.animal.service.consume;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangyaolang.animal.controller.consume.vo.ConsumeInfoVo;
import com.wangyaolang.animal.controller.consume.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.wangyaolang.animal.dao.mapper.AConsumeMapper;
import com.wangyaolang.animal.dao.mapper.AFosterMapper;
import com.wangyaolang.animal.service.consume.IAConsumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<ConsumeInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aConsumeMapper.getList(page, queryListVo);
    }
}
