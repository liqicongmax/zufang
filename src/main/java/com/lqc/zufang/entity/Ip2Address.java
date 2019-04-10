package com.lqc.zufang.entity;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/10 16:57
 */
@NoArgsConstructor
@AllArgsConstructor
public class Ip2Address {
    private Integer code;
    private Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}
