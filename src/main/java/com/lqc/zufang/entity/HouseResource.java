package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;
import lombok.*;
import lombok.Data;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 17:30
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HouseResource extends BaseDto {

    private static final long serialVersionUID = 8981586382428821589L;
    private Long belonguser;//房东id
    private String province;//省
    private String city;//市
    private String district;//区
    private String place;//详细地址
    private Integer price;//每月房租价格
    private String description;//房源描述
    private Integer size;//房间大小
    private Integer status;//0已发布,1未发布
    private Integer beds;//床个数
    private Integer bathroom;//浴室个数
    private String type;//出租类型,首租或转租
    private Integer like;//收藏次数
    private Integer aircondition;
    private Integer tv;
    private Integer kitchen;
    private Integer fan;
    private Integer sofa;
    private Integer singleWc;
    private Integer collect;

}
