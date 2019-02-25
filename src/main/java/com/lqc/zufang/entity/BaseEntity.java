package com.lqc.zufang.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 310943826319554984L;
    private Long id;
    private Timestamp inputTime;
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getInputTime() {
        return inputTime;
    }

    public void setInputTime(Timestamp inputTime) {
        this.inputTime = inputTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
