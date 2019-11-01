package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysUser;
import java.util.List;

public interface SysUserMapper {
    int insert(SysUser record);

    List<SysUser> selectAll();

    SysUser selectUserByUserName(String username);
}