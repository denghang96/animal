package com.wangyaolang.animal.controller.statistics;

import com.wangyaolang.animal.controller.common.BaseResponseVO;
import com.wangyaolang.animal.controller.statistics.vo.AnimalTypeVo;
import com.wangyaolang.animal.controller.statistics.vo.WebsiteNumVo;
import com.wangyaolang.animal.service.statistics.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "statistics/")
@RestController
public class StatisticsController {

    @Autowired
    private IStatisticsService statisticsService;

    /**
     * 数据统计-查询总数
     * @return
     */
    @RequestMapping(value = "getWebsiteNum/")
    public BaseResponseVO getWebsiteNum() {
        WebsiteNumVo websiteNumVo = statisticsService.getWebsiteNum();
        return BaseResponseVO.success(websiteNumVo);
    }
    /**
     * 数据统计-统计不同类型的动物数量
     * @return
     */
    @RequestMapping(value = "getAnimalTypeNum/")
    public BaseResponseVO getAnimalTypeNum() {
        List<AnimalTypeVo> animalTypeNum = statisticsService.getAnimalTypeNum();
        return BaseResponseVO.success(animalTypeNum);
    }
}
