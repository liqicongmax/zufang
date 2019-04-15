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

    /**
     * 通过用户id查询所有他当前正在出租的房屋
     * @param id
     * @return 获取房屋集合
     */
    List<HouseResource> getHouseResourceListByUserId(Long id);

    /**
     * 通过用户id查询他所有当前正在出租的房屋
     * @param id
     * @return 获取房屋id集合
     */
    List<Long> getHouseResourceIdListByUserId(Long id);

    /**
     * 上架房源
     * @param houseId
     */
    void export(Long houseId);

    /**
     * 下架房源
     * @param houseId
     */
    void unload(Long houseId);
}
