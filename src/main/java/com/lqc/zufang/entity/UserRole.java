package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 14:54
 */
@Data
public class UserRole extends BaseDto {
    private static final long serialVersionUID = -7032812068465888736L;
    private Long userId;
    private Long roleId;
}
