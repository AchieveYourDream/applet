package com.kute.appletmanage.role.service;

import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.entity.SysUser;

import java.util.List;

public interface RoleService  {
    /**
     * 获取角色列表
     */
    List<SysRole> selectAll() throws Exception;
    /**
     * 获取角色信息
     *
     * @param roleId 角色ID
     */
    SysRole getRoleInfo(String roleId) throws Exception;
    /**
     * 获取角色信息
     *
     * @param roleName 角色名称
     */
    SysRole getRoleInfoByRoleName(String roleName) throws Exception;
    /**
     * 获取角色用户列表
     */
    List<SysUser>  getRoleUserList(String roleId) throws Exception;
    /**
     * 新增角色
     */
    void addRole(SysRole sr) throws Exception;
    /**
     * 编辑角色
     */
    void editRole(SysRole sr) throws Exception;
    /**
     * 获取菜单权限树结构
     * @param roleId 角色ID
     */
    String getMenuAuthTreeStruct(String roleId) throws Exception;
    /**
     * 获取菜单权限树
     *
     * @param roleId 角色ID
     */
    String  getMenuAuthTree(String roleId, String menuStructCode) throws Exception;


    void roleDelete(String roleId) throws Exception;

    void saveRoleMenuAuth(Integer roleId, String menu_code) throws Exception;

    /**
    * @Description:  删除角色用户关系
    * @Author: 王斌
    * @Date: 2019/11/4
    */
    void  delRoleUserRelation(String roleId,String userList) throws Exception;
}
