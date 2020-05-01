package com.wangyaolang.animal.service.foster;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.common.utils.TimeUtils;
import com.wangyaolang.animal.controller.foster.vo.*;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.wangyaolang.animal.dao.entity.AFoster;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AAnimalMapper;
import com.wangyaolang.animal.dao.mapper.AConsumeMapper;
import com.wangyaolang.animal.dao.mapper.AFosterMapper;
import com.wangyaolang.animal.dao.mapper.AUserMapper;
import com.wangyaolang.animal.service.animal.IAnimalService;
import com.wangyaolang.animal.service.common.exception.CommonServiceExcetion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("fosterService")
public class FosterService extends ServiceImpl<AFosterMapper, AFoster> implements IFosterService {

    @Resource
    private AFosterMapper aFosterMapper;

    @Resource
    private AAnimalMapper aAnimalMapper;


    @Resource
    private AUserMapper aUserMapper;


    @Resource
    private AConsumeMapper aConsumeMapper;

    @Autowired
    IAnimalService animalService;


    @Override
    @Transactional
    public void add(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        AFoster aFoster = new AFoster();
        BeanUtils.copyProperties(fosterInfoVo,aFoster); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        // 数据插入
        int isSuccess = aFosterMapper.insert(aFoster);
        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加申请失败");
        }
    }

    @Override
    @Transactional
    public FosterInfoVo updateFoster(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        AFoster aFoster = new AFoster();
        BeanUtils.copyProperties(fosterInfoVo,aFoster); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set
        if(fosterInfoVo.getApplyPrice()>0) {
            //数据库里的钱是以分为单位存的，所以乘以100
            aFoster.setApplyPrice((int) (fosterInfoVo.getApplyPrice()*100));
        }
        // 数据插入
        int isSuccess = aFosterMapper.updateById(aFoster);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑申请失败");
        }

        return fosterInfoVo;
    }

    @Override
    public List<FosterInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aFosterMapper.getList(page, queryListVo);
    }

    @Override
    @Transactional
    public void sh(FosterInfoVo fosterInfoVo) throws CommonServiceExcetion {
        this.updateFoster(fosterInfoVo);
    }

    @Override
    @Transactional
    public void arrive(ArriveInfoVo arriveInfoVo) {
        //获取到寄养申请的基本信息
        AFoster aFoster = this.getById(arriveInfoVo.getApplyId());
        AAnimal animal = new AAnimal();

        BeanUtils.copyProperties(aFoster,animal);
        //添加一条动物信息
        animal.setAnimalDate(arriveInfoVo.getArriveDate());
        animal.setAnimalStatus("正在寄养");
        animal.setAnimalFeatures(aFoster.getAnimalDesc());
        animal.setAnimalMoney(aFoster.getApplyPrice());
        animal.setProjectType("寄养");
        animal.setAnimalNo(arriveInfoVo.getAnimalNo());
        aAnimalMapper.insert(animal);

        aFoster.setApplyStatus("正在寄养");
        aFoster.setAnimalId(animal.getId());
        this.updateById(aFoster);
    }

    @Override
    @Transactional
    public void reset(Integer fosterId) {
        AFoster aFoster = this.getById(fosterId);
        animalService.removeById(aFoster.getAnimalId());
        aFoster.setApplyStatus("待审批");
        aFoster.setOpinion("");
        aFoster.setAnimalId(0);
        aFoster.setApplyPrice(0);
        this.updateById(aFoster);
    }

    @Override
    public SettleResponseVo getMoney(Integer fosterId, String date) throws ParseException {
        SettleResponseVo settleResponseVo = aFosterMapper.getMoney(fosterId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Integer days = TimeUtils.differentDays(simpleDateFormat.parse(settleResponseVo.getArriveDate()),simpleDateFormat.parse(date));
        settleResponseVo.setAnimalTotleMoney(days * (settleResponseVo.getAnimalSingleMoney()*100) / 100 );
        return settleResponseVo;
    }

    @Override
    @Transactional
    public void settle(SettleVo settleVo) {
        //1.将寄养状态改为已结算
        AFoster aFoster = this.getById(settleVo.getFosterId());
        aFoster.setApplyStatus("已结算");
        this.updateById(aFoster);
        AUser aUser = aUserMapper.selectById(aFoster.getUserId());
        //2.如果是直接结算，则用户余额减下来 否则 余额清零
        if("直接结算".equals(settleVo.getSettleType())) {
            int money = (int) (settleVo.getAnimalTotleMoney()*100);
            aUser.setUserMoney(aUser.getUserMoney() - money );
        } else {
            aUser.setUserMoney(0);
        }
        aUserMapper.updateById(aUser);
        //3.插入一条消费记录
        AConsume aConsume = new AConsume();
        aConsume.setConsumeDate(settleVo.getSettleDate());
        aConsume.setMoney((int) (settleVo.getAnimalTotleMoney()*100));
        aConsume.setType("寄养");
        aConsume.setUserId(aFoster.getUserId());
        aConsume.setAnimalId(aFoster.getAnimalId());
        aConsumeMapper.insert(aConsume);
        //4.更新动物状态
        AAnimal animal = aAnimalMapper.selectById(aFoster.getAnimalId());
        animal.setAnimalStatus("寄养结束");
        aAnimalMapper.updateById(animal);
    }
}
