package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.HouseResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:11
 */
@Mapper
public interface HouseResourceMapper {
    HouseResource getHouseResourceById(Long id);
}
