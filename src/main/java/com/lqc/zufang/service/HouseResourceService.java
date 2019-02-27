package com.lqc.zufang.service;

import com.lqc.zufang.entity.HouseResource;

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
}
