package com.wangyaolang.animal.dao.mapper;

import com.wangyaolang.animal.controller.statistics.vo.AnimalTypeVo;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {
    List<AnimalTypeVo> getAnimalTypeNum();
}
