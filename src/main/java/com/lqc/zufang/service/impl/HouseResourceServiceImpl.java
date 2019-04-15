package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.Collect;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.HouseResourceQuery;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.mapper.HouseResourceMapper;
import com.lqc.zufang.service.HouseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<HouseResource> getHouseResourceListLimitSix() {
        return houseResourceMapper.getHouseResourceListLimitSix();
    }

    @Override
    public List<HouseResource> query(HouseResourceQuery query) {
        return houseResourceMapper.query(query);

    }

    /**
     * 通过用户id查询所有他当前正在出租的房屋
     *
     * @param id
     * @return
     */
    @Override
    public List<HouseResource> getHouseResourceListByUserId(Long id) {
        return houseResourceMapper.getHouseResourceListByUserId(id);
    }

    /**
     * 通过用户id查询他所有当前正在出租的房屋
     *
     * @param id
     * @return 获取房屋id集合
     */
    @Override
    public List<Long> getHouseResourceIdListByUserId(Long id) {
        return houseResourceMapper.getHouseResourceIdListByUserId(id);
    }


    /**
     * 上架房源
     *
     * @param houseId
     */
    @Override
    public void export(Long houseId) {
        houseResourceMapper.export(houseId);
    }

    /**
     * 下架房源
     *
     * @param houseId
     */
    @Override
    public void unload(Long houseId) {
        houseResourceMapper.unload(houseId);
    }
}
