package com.wangyaolang.animal.service.statistics;


import com.wangyaolang.animal.controller.statistics.vo.*;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {

    WebsiteNumVo getWebsiteNum();

    List<AnimalTypeVo> getAnimalTypeNum();

    List<AnimalStatusVo> getAnimalStatusNum();

    List<MoneyResponseVo> getMoneyNum();
}
