package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:11
 */
@Mapper
public interface HouseResourceMapper {
    HouseResource getHouseResourceById(Long id);
    List<HouseResource> getHouseResourceListLimitSix();
}
