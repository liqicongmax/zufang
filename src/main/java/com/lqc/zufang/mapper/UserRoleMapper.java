package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:29
 */
@Mapper
public interface UserRoleMapper {
    UserRole listByUserId(Integer id);
}
