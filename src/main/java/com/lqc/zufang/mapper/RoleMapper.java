package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:28
 */
@Mapper
public interface RoleMapper {
    Role selectById(Integer id);
}
