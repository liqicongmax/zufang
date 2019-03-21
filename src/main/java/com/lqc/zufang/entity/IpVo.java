package com.lqc.zufang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/21 15:13
 */
@Data
public class IpVo implements Serializable{
    private Integer code;
    private Address address;
    @Data
    public class Address implements Serializable {
        private String ip;
        private String region;
        private String city;
    }
}
