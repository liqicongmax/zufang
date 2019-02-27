package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 17:30
 */
public class HouseResource extends BaseDto {

    private static final long serialVersionUID = 8981586382428821589L;
    private Long belongUser;//房东id
    private String provice;//省
    private String city;//市
    private String district;//区
    private Integer price;//每月房租价格
    private String description;//房源描述
    private Integer size;//房间大小
    private Integer status;//0未出租,1已出租
    private Integer beds;//床个数
    private Integer bathroom;//浴室个数
    private String type;//出租类型,首租或转租
    private Integer like;//收藏次数

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

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
