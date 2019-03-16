package com.lqc.zufang.service;

import com.lqc.zufang.entity.Collect;

import java.util.List;

/**
 * 房源收藏的服务
 * @author liqicong@myhexin.com
 * @date 2019/3/16 14:29
 */
public interface CollectService {
    /**
     * 添加收藏记录
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
