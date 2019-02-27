package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 17:30
 */
public class HouseResource extends BaseDto {

    private static final long serialVersionUID = 8981586382428821589L;
    private Long belongUser;
    private String provice;
    private String city;
    private String district;
    //每月房租价格
    private Integer price;
    private String description;
    //房间大小
    private Integer size;
    private Integer status;//0未出租,1已出租
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBelongUser() {
        return belongUser;
    }

    public void setBelongUser(Long belongUser) {
        this.belongUser = belongUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
