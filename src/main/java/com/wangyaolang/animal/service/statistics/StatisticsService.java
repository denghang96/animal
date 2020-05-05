package com.wangyaolang.animal.service.statistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangyaolang.animal.common.utils.TimeUtils;
import com.wangyaolang.animal.controller.statistics.vo.*;
import com.wangyaolang.animal.dao.entity.AAnimal;
import com.wangyaolang.animal.dao.entity.AUser;
import com.wangyaolang.animal.dao.mapper.StatisticsMapper;
import com.wangyaolang.animal.service.animal.IAnimalService;
import com.wangyaolang.animal.service.comment.ICommentService;
import com.wangyaolang.animal.service.consume.IAConsumeService;
import com.wangyaolang.animal.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatisticsService implements IStatisticsService{
    @Resource
    StatisticsMapper statisticsMapper;

    @Resource
    IUserService userService;

    @Resource
    ICommentService commentService;

    @Resource
    IAnimalService animalService;


    /**
     * 统计 用户总数、动物总数、评论总数、今日领养、今日助养、今日助养
     * @return
     */
    @Override
    public WebsiteNumVo getWebsiteNum() {
        WebsiteNumVo websiteNumVo = new WebsiteNumVo();

        //用户总数
        QueryWrapper<AUser> aUserQueryWrapper = new QueryWrapper<>();
        aUserQueryWrapper.eq("user_type","2"); //只统计普通会员
        int userNum = userService.count(aUserQueryWrapper);
        websiteNumVo.setUserNum(userNum);

        //动物总数
        int animalNum = animalService.count(null);
        websiteNumVo.setAnimalNum(animalNum);

        //评论总数
        int commentNum = commentService.count(null);
        websiteNumVo.setCommentNum(commentNum);

        SimpleDateFormat format2 = new SimpleDateFormat( "yyyy-MM-dd");

        //今日领养
        QueryWrapper<AAnimal> aAnimalAdoptQueryWrapper = new QueryWrapper<>();
        aAnimalAdoptQueryWrapper.eq("animal_date",format2.format(new Date())).eq("animal_status","已领养");
        int todayAdoptNum = animalService.count(aAnimalAdoptQueryWrapper);
        websiteNumVo.setTodayAdopt(todayAdoptNum);

        //今日助养
        QueryWrapper<AAnimal> aAnimalFosterQueryWrapper = new QueryWrapper<>();
        aAnimalFosterQueryWrapper.eq("animal_date",format2.format(new Date())).eq("animal_status","已助养");
        int todayFosterNum = animalService.count(aAnimalAdoptQueryWrapper);
        websiteNumVo.setTodayFoster(todayFosterNum);

        //今日寄养
        QueryWrapper<AAnimal> aAnimalSupportQueryWrapper = new QueryWrapper<>();
        aAnimalSupportQueryWrapper.eq("animal_date",format2.format(new Date())).eq("animal_status","正在寄养");
        int todaySupportNum = animalService.count(aAnimalSupportQueryWrapper);
        websiteNumVo.setTodaySupport(todaySupportNum);

        return websiteNumVo;
    }

    /**
     * 统计每个动物的数量
     * @return
     */
    @Override
    public List<AnimalTypeVo> getAnimalTypeNum() {
        List<AnimalTypeVo> getAnimalTypeNumMap = statisticsMapper.getAnimalTypeNum();
        return getAnimalTypeNumMap;
    }

    @Override
    public List<AnimalStatusVo> getAnimalStatusNum() {
        List<AnimalStatusVo> animalStatusVo = statisticsMapper.getAnimalStatusNum();
        return animalStatusVo;
    }

    @Override
    public List<MoneyResponseVo> getMoneyNum() {
        List<MoneyVo> moneyNum = statisticsMapper.getMoneyNum();
        Set<String> typeSet = new HashSet<>(); // 所有类型： 领养，寄养，助养
        for (int i = 0; i < moneyNum.size(); i++) {
            typeSet.add(moneyNum.get(i).getType());
        }
        List<MoneyResponseVo> moneyResponseVoList = new ArrayList<>();
        Iterator<String> iterator = typeSet.iterator();
        while (iterator.hasNext()) {
            MoneyResponseVo moneyResponseVo = new MoneyResponseVo();
            moneyResponseVo.setType(iterator.next());
            moneyResponseVoList.add(moneyResponseVo);
        }
        String[] recentDate = TimeUtils.getRecentDate(6);

        for (int i = 0; i < moneyResponseVoList.size(); i++) {
            for (int j = 0; j < recentDate.length; j++) {
                for (int k = 0; k < moneyNum.size(); k++) {
                    if (moneyResponseVoList.get(i).getType().equals(moneyNum.get(k).getType())
                            && recentDate[j].equals(moneyNum.get(k).getDate())) {
                        moneyResponseVoList.get(i).getMoney()[j] = moneyNum.get(k).getSumMoney();
                    }
                }
            }
        }
        System.out.println("=======");
        return moneyResponseVoList;
    }
}
