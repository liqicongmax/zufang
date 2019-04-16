package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/16 18:29
 */
@Mapper
public interface ImageMapper {
    Long addImage(Image image);
    List<Long> getIdListByHid(Long hid);
}
