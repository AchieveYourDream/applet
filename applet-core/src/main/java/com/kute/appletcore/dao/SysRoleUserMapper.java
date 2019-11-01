package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRoleUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleUserMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("userId") String userId);

    int insert(SysRoleUser record);

    List<SysRoleUser> selectAll();
}