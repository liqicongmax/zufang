package com.lqc.zufang.entity;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/1 16:02
 */
public class HouseResourceQuery extends HouseResource {

    private static final long serialVersionUID = 7613365719936652595L;
    private Integer low;
    private Integer high;

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }
}
