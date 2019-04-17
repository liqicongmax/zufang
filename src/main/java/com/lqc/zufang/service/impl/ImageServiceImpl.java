package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.Image;
import com.lqc.zufang.mapper.ImageMapper;
import com.lqc.zufang.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/16 18:29
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;
    @Override
    public Long addImage(Image image) {
        return imageMapper.addImage(image);
    }

    @Override
    public List<Long> getIdListByHid(Long hid) {
        return imageMapper.getIdListByHid(hid);
    }

    @Override
    public void deletePic(Long id) {
        imageMapper.deletePic(id);
    }

    @Override
    public Long getTopImageId(Long houseId) {
        return imageMapper.getTopImageId(houseId);
    }
}
