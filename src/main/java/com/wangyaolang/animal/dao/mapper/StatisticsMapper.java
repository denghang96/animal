package com.wangyaolang.animal.dao.mapper;

import com.wangyaolang.animal.controller.statistics.vo.AnimalStatusVo;
import com.wangyaolang.animal.controller.statistics.vo.AnimalTypeVo;
import com.wangyaolang.animal.controller.statistics.vo.MoneyVo;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {
    List<AnimalTypeVo> getAnimalTypeNum();

    List<AnimalStatusVo> getAnimalStatusNum();

    List<MoneyVo> getMoneyNum();
}
