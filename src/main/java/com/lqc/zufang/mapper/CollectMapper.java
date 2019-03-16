package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/16 14:37
 */
@Mapper
public interface CollectMapper {
    /**
     * 增加一条收藏记录
     * @param collect
     */
    void insertCollect(Collect collect);
    /**
     * 通过用户ID查询他所有的收藏列表
     * @param id 用户id
     * @return
     */
    List<Long> getCollectListByUserId(Long id);
}
