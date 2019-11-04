package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRoleMenuRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMenuRelationMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("menuCode") String menuCode);

    int insert(@Param("menuList") List<SysRoleMenuRelation> menuList);

    List<SysRoleMenuRelation> selectAll();


    int  removeRoleMenuAuthList(Integer roleId);
}