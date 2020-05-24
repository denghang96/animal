package com.wangyaolang.animal.service.support;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.common.utils.MD5Util;
import com.wangyaolang.animal.common.utils.TimeUtils;
import com.wangyaolang.animal.controller.supprot.vo.QueryListVo;
import com.wangyaolang.animal.controller.supprot.vo.SupportInfoVo;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.wangyaolang.animal.dao.entity.ASupport;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AConsumeMapper;
import com.wangyaolang.animal.dao.mapper.ASupportMapper;
import com.wangyaolang.animal.service.animal.IAnimalService;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import com.wangyaolang.animal.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service("supprortService")
public class SupprortService extends ServiceImpl<ASupportMapper, ASupport> implements ISupportService{

    @Resource
    private ASupportMapper aSupportMapper;

    @Resource
    private AConsumeMapper aConsumeMapper;

    @Autowired
    IAnimalService animalService;

    @Autowired
    IUserService userService;

    @Override
    @Transactional
    public void add(SupportInfoVo supportInfoVo) throws CommonServiceExcetion {
        ASupport aSupport = new ASupport();
        BeanUtils.copyProperties(supportInfoVo,aSupport); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        //动物
        AAnimal animal = animalService.getById(aSupport.getAnimalId());
        if(!Objects.equals(animal.getAnimalStatus(),"待助养")) {
            throw new CommonServiceExcetion(501,"助养失败！当前动物已被他人助养咯");
        }
        //用户
        AUser aUser = userService.getById(aSupport.getUserId());
        if(!Objects.equals(aUser.getPayPwd(), MD5Util.encrypt(supportInfoVo.getPayPwd()))) {
            throw new CommonServiceExcetion(501,"支付密码错误，助养失败");
        }
        if(aUser.getUserMoney() < animal.getAnimalMoney()) {
            throw new CommonServiceExcetion(501,"助养失败！余额已经不足咯");
        }
        animal.setAnimalStatus("已助养");
        SimpleDateFormat format2 = new SimpleDateFormat( "yyyy-MM-dd");
        animal.setAnimalDate(format2.format(new Date()));
        aUser.setUserMoney(aUser.getUserMoney() - animal.getAnimalMoney());
        userService.updateById(aUser);
        animalService.updateById(animal);
        String date = TimeUtils.getStringDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        //3.插入一条消费记录
        AConsume aConsume = new AConsume();
        aConsume.setConsumeDate(date);
        aConsume.setMoney((int) (animal.getAnimalMoney()));
        aConsume.setType("助养");
        aConsume.setUserId(aSupport.getUserId());
        aConsume.setAnimalId(Integer.valueOf(aSupport.getAnimalId()));
        aConsumeMapper.insert(aConsume);

        //4助养信息
        aSupport.setHelpDate(date);
        aSupport.setHelpMoney(animal.getAnimalMoney());
        // 数据插入
        int isSuccess = aSupportMapper.insert(aSupport);
        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"助养失败！请重试");
        }
    }

    @Override
    @Transactional
    public SupportInfoVo updateSupport(SupportInfoVo supportInfoVo) throws CommonServiceExcetion {
        ASupport aSupport = new ASupport();
        BeanUtils.copyProperties(supportInfoVo,aSupport); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aSupportMapper.updateById(aSupport);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑失败！请重试");
        }

        return supportInfoVo;
    }

    @Override
    public List<SupportInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aSupportMapper.getList(page, queryListVo);
    }

    @Override
    @Transactional
    public boolean deleteBatchByIds(List<Integer> delIds) {
        return  aSupportMapper.deleteBatchIds(delIds)>0?true:false;
    }
}
