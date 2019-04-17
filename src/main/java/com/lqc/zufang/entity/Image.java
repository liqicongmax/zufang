package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/16 15:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseDto {
    private static final long serialVersionUID = 1360092898375239601L;
    private Long hid;//所属的房源id
    private Long status;
}
