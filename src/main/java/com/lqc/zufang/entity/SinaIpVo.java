package com.lqc.zufang.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/21 15:11
 */
@Data
public class SinaIpVo implements Serializable {
    private Integer ret;
    private String province;
    private String city;

}
