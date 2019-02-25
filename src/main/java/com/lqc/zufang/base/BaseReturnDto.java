package com.lqc.zufang.base;

/**
 * @description: 基础返回Json内容
 * @author: liqicong@myhexin.com
 * @date 2019/2/25 13:45
 */
import java.io.Serializable;

public class BaseReturnDto<T> implements Serializable {

    private static final long serialVersionUID = 4762408366604226889L;
    private int flag;
    private String msg;
    private T data;

    /**
     *
     * @param flag 标识,1表示成功,-1表示失败
     * @param msg 提示消息
     * @param data 返回的数据
     */
    public BaseReturnDto(int flag, String msg, T data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public BaseReturnDto(int flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public BaseReturnDto() {
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
