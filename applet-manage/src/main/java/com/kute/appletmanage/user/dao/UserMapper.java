package com.kute.appletmanage.user.dao;


import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.vo.SysUserRoleVO;
import com.kute.appletcore.vo.SysUserVO;

import java.util.List;

/**
 * @Name: 用户管理
 * @Description: 用户管理
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-20
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-20
 */
public interface UserMapper {

    /**
     * 获取用户列表
     */
    List<SysUserVO> getUserList() throws Exception;

    /**
     * 根据用户名获取用户信息
     *
     * @param userName 用户名
     */
    SysUser getUserInfoByUserName(String userName) throws Exception;

    /**
     * 获取用户角色列表
     *
     * @param userId 用户ID
     */
    List<SysUserRoleVO> getUserRoleList(String userId) throws Exception;

    /**
     * 删除用户关联的角色
     *
     * @param user_id
     */
    void deleteByUserId(String user_id);
}
