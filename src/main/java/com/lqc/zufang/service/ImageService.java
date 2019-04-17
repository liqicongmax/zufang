package com.lqc.zufang.service;

import com.lqc.zufang.entity.Image;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/16 18:28
 */
public interface ImageService {
    Long addImage(Image image);
    List<Long> getIdListByHid(Long Hid);
    void deletePic(Long id);
    Long getTopImageId(Long hosueId);
}
