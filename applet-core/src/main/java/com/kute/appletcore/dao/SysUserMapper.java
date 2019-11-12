package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysUser;
import java.util.List;

public interface SysUserMapper {
    int insert(SysUser record);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    int  deleteByPrimaryKey(String userName);

    SysUser selectUserByUserName(String userName);
}