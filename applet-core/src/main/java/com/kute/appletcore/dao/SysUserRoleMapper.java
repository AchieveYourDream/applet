package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    int deleteByPrimaryKey(@Param("user_id") String user_id, @Param("role_id") String role_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    int insert(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    List<SysUserRole> selectAll();
}