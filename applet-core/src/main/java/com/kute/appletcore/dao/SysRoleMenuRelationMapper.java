package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRoleMenuRelation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuRelationMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("menuCode") String menuCode);

    int insert(SysRoleMenuRelation record);

    List<SysRoleMenuRelation> selectAll();
}