package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRoleMember;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMemberMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("memberId") String memberId);

    int insert(SysRoleMember record);

    List<SysRoleMember> selectAll();
}