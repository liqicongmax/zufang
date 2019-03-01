package com.lqc.zufang.entity;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/1 17:25
 */
public class Collect {
    private Long id;
    private Long userId;
    private Long houseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }
}
