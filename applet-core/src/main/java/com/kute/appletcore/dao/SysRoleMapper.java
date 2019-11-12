package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.entity.SysRoleUser;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.util.tree.TreeNodeData;
import com.kute.appletcore.util.tree.TreeNodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

    /**
     * 获取角色用户信息
     *
     * @param roleId 角色ID
     */
    List<SysUser>  getRoleUserList(String roleId) throws Exception;
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
     */
    List<TreeNodeVO> getMenuAuthTree(@Param("structCode") String  structCode, @Param("roleId") String roleId) throws Exception;

    /**
     * 获取操作权限列表
     *
     * @param parameterMap 参数MAP
     */
    List<TreeNodeData> getOperationAuthList(Map<String, Object> parameterMap) throws Exception;

    /**
    * @Description: 添加用户角色关系
    * @Author: 王斌
    * @Date: 2019/11/5
    */
    int addRoleUserRelation(@Param("userList") List<SysRoleUser> userList);
    /**
     * @Description: 删除用户角色关系
     * @Author: 王斌
     * @Date: 2019/11/5
     */
    void delRoleUserRelation(@Param("roleId") String roleId,@Param("userList")  String userList)throws Exception;
}