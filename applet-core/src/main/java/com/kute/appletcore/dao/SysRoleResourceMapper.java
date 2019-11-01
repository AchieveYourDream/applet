package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    int deleteByPrimaryKey(@Param("role_id") String role_id, @Param("resource_id") String resource_id, @Param("resource_type") String resource_type);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    int insert(SysRoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    List<SysRoleResource> selectAll();

    /**
     * 删除当前角色的菜单权限列表
     *
     * @param roleId 角色ID
     */
    void removeRoleMenuAuthList(String roleId);

}