package com.lqc.zufang.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/16 16:32
 */
@Data
public class UploadImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
