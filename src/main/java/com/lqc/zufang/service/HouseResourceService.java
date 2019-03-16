package com.lqc.zufang.service;

import com.lqc.zufang.entity.Collect;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.HouseResourceQuery;
import com.lqc.zufang.entity.User;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:07
 */
public interface HouseResourceService {
    /**
     * 通过房源id查询房源
     * @param id
     */
    HouseResource getHouseResourceById(Long id);

    List<HouseResource> getHouseResourceListLimitSix();

    List<HouseResource> query(HouseResourceQuery query);


}
