package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.util.tree.TreeNodeData;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

    /**
     * 获取角色信息
     *
     * @param roleName 角色名称
     */
    SysRole getRoleInfoByRoleName(String roleName) throws Exception;

    /**
     * 获取角色信息
     *
     * @param parameterMap 参数MAP
     */
    SysRole getRoleInfoByRoleIdName(Map<String, Object> parameterMap) throws Exception;

    /**
     * 获取菜单权限树结构
     *
     * @param roleId 角色ID
     */
    String getMenuAuthTreeStruct(String roleId) throws Exception;

    /**
     * 查询当前节点 角色拥有权限的所有子节点
     *
     * @param parameterMap 参数MAP
     */
    List<TreeNodeData> getMenuAuthTree(Map<String, Object> parameterMap) throws Exception;

    /**
     * 获取操作权限列表
     *
     * @param parameterMap 参数MAP
     */
    List<TreeNodeData> getOperationAuthList(Map<String, Object> parameterMap) throws Exception;

    /**
     * 删除当前角色的菜单权限列表
     *
     * @param roleId 角色ID
     */
    void removeRoleMenuAuthList(String roleId) throws Exception;
}