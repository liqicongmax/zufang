package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.Collect;
import com.lqc.zufang.mapper.CollectMapper;
import com.lqc.zufang.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/16 14:32
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public void insertCollect(Collect collect) {
        collectMapper.insertCollect(collect);
    }

    /**
     * 通过用户ID查询他所有的收藏列表
     *
     * @param id 用户id
     * @return
     */
    @Override
    public List<Long> getCollectListByUserId(Long id) {
        return collectMapper.getCollectListByUserId(id);
    }
}
