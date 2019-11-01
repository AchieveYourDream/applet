package com.kute.appletmanage.user.service;

import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.entity.SysUserRole;
import com.kute.appletcore.vo.SysUserRoleVO;
import com.kute.appletcore.vo.SysUserVO;

import java.util.List;

public interface UserService {
    /**
     * 获取用户列表
     */
    List<SysUserVO> getUserList() throws Exception;
    /**
     * 获取用户信息
     * @param userId 用户ID
     */
    SysUser getUserInfoByUserId(String userId) throws Exception;
    /**
     * 获取用户信息
     * @param userName 用户名
     */
    SysUser getUserInfoByUserName(String userName) throws Exception;
    /**
     * 新增用户
     */
    void addUser(SysUser su) throws Exception;
    /**
     * 编辑用户
     */
    void editUser(SysUser su) throws Exception;

    /**
     * 修改用户状态
     * @param userId     用户ID
     * @param userStatus 用户状态
     */
    void updateUserStatus(String userId, String userStatus) throws Exception;
    /**
     * 修改用户皮肤
     * @param userId 用户ID
     * @param skin   皮肤
     */
    void updateUserSkin(String userId, String skin) throws Exception;
    /**
     * 获取用户角色信息
     * @param userId 用户ID
     */
    List<SysUserRoleVO> getUserRoleList(String userId) throws Exception;
    /**
     * 新增用户角色
     */
    void addUserRole(SysUserRole sur) throws Exception;
    /**
     * 删除用户
     */
    void removeUser(String user_id) throws Exception;
    /**
     * 删除用户角色
     */
    void removeUserRole(String user_id, String role_id) throws Exception;


}
