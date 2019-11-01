package com.kute.appletmanage.role.service;

import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.util.tree.TreeNode;

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
     * 获取角色信息
     *
     * @param roleId   角色ID
     * @param roleName 角色名称
     */
    SysRole getRoleInfoByRoleIdName(String roleId, String roleName) throws Exception;
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
    TreeNode getMenuAuthTree(String roleId, String menuStructCode) throws Exception;


    void roleDelete(String roleId) throws Exception;

    void saveRoleMenuAuth(String roleId, String menu_code) throws Exception;
}
