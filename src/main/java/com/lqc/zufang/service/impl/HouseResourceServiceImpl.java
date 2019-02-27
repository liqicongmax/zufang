package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.mapper.HouseResourceMapper;
import com.lqc.zufang.service.HouseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:08
 */
@Service
public class HouseResourceServiceImpl implements HouseResourceService {
    @Autowired
    HouseResourceMapper houseResourceMapper;
    /**
     * 通过房源id查询房源
     *
     * @param id
     */
    @Override
    public HouseResource getHouseResourceById(Long id) {
        return houseResourceMapper.getHouseResourceById(id);
    }
}
