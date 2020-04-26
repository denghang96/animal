package com.wangyaolang.animal.service.statistics;


import com.wangyaolang.animal.controller.statistics.vo.AnimalTypeVo;
import com.wangyaolang.animal.controller.statistics.vo.WebsiteNumVo;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {

    WebsiteNumVo getWebsiteNum();

    List<AnimalTypeVo> getAnimalTypeNum();
}
