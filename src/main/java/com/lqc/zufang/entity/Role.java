package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseDto {
    private static final long serialVersionUID = 7148810463557815989L;
    private String name;
}
