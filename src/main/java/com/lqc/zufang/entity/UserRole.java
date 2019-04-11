package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 14:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseDto {
    private static final long serialVersionUID = -7032812068465888736L;
    private Long userId;
    private Long roleId;
}
