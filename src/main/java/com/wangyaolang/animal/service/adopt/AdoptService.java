package com.wangyaolang.animal.service.adopt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangyaolang.animal.common.utils.TimeUtils;
import com.wangyaolang.animal.controller.adopt.vo.AdoptInfoVo;
import com.wangyaolang.animal.controller.adopt.vo.QueryListVo;
import com.wangyaolang.animal.dao.entity.AAdopt;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.entity.AConsume;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.AAdoptMapper;
import com.wangyaolang.animal.dao.mapper.AConsumeMapper;
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

@Service("adoptService")
public class AdoptService extends ServiceImpl<AAdoptMapper, AAdopt> implements IAdoptService {

    @Resource
    private AAdoptMapper aAdoptMapper;

    @Autowired
    private IAnimalService animalService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AConsumeMapper aConsumeMapper;

    private Object lock = new Object(); //定义一把锁，防止多个管理员同时审核一个申请

    @Override
    @Transactional
    public void add(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAdopt aAdopt = new AAdopt();
        BeanUtils.copyProperties(adoptInfoVo,aAdopt); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",adoptInfoVo.getUserId());
        queryWrapper.eq("apply_status","审批通过");
        int count = this.count(queryWrapper);
        if (count > 3) { //如果领养超过三个
            throw new CommonServiceExcetion(501,"领养不能超过三个");
        }

        // 数据插入
        int isSuccess = aAdoptMapper.insert(aAdopt);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"添加申请失败");
        }
    }

    @Override
    @Transactional
    public AdoptInfoVo updateAdopt(AdoptInfoVo adoptInfoVo) throws CommonServiceExcetion {
        // AnimalInfoVo -> Animal 转换
        AAdopt aAdopt = new AAdopt();
        BeanUtils.copyProperties(adoptInfoVo,aAdopt); // 讲两个对象中属性名想同的属性值进行拷贝，就不用一个一个手动先get再set

        // 数据插入
        int isSuccess = aAdoptMapper.updateById(aAdopt);

        // 判断插入是否成功
        if(isSuccess!=1){
            throw new CommonServiceExcetion(501,"编辑申请失败");
        }

        return adoptInfoVo;
    }

    @Override
    public List<AdoptInfoVo> getList(Page page, QueryListVo queryListVo) {
        return aAdoptMapper.getList(page, queryListVo);
    }

    @Override
    @Transactional
    public AdoptInfoVo sh(AdoptInfoVo adopt) throws CommonServiceExcetion {
        AAnimal animal = animalService .getById(adopt.getAnimalId()) ;
        if("审批通过".equals(adopt.getApplyStatus())) {
            synchronized (lock) {
                AUser user = userService.getById(adopt.getUserId());
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("user_id",adopt.getUserId());
                queryWrapper.eq("apply_status","审批通过");
                int count = this.count(queryWrapper);
                if (count > 3) { //如果领养超过三个
                    throw new CommonServiceExcetion(501,"领养不能超过三个");
                }
                if(!"待领养".equals(animal.getAnimalStatus())) {
                    throw new CommonServiceExcetion(501,"动物状态不合法，领养失败");
                }
                if(user.getUserMoney() < animal.getAnimalMoney()) {
                    throw new CommonServiceExcetion(502,"用户余额已不足，领养失败");
                }
                animal.setAnimalStatus("已领养");
                SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
                animal.setAnimalDate(sdf.format(new Date()));
                user.setUserMoney(user.getUserMoney() - animal.getAnimalMoney()); //扣钱
                userService.updateById(user);
                animalService.updateById(animal);
            }
        }
        //3.插入一条消费记录
        AConsume aConsume = new AConsume();
        aConsume.setConsumeDate(TimeUtils.getStringDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        aConsume.setMoney(animal.getAnimalMoney()

        );
        aConsume.setType("领养");
        aConsume.setUserId(adopt.getUserId());
        aConsume.setAnimalId(adopt.getAnimalId());
        aConsumeMapper.insert(aConsume);

        updateAdopt(adopt);
        return adopt;
    }

    @Override
    public boolean deleteBatchByIds(List<String> list) {
        return aAdoptMapper.deleteBatchIds(list)>0?true:false;
    }
}
