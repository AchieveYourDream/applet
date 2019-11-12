package com.kute.appletmanage.user.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysUser;

public interface UserService {
    /**
     * 获取用户列表
     */
    PageInfo<SysUser> getUserList(Integer pageNum, Integer pageSize, String search) throws Exception;
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
    void updateUserStatus(String userName, String userState) throws Exception;
    /**
     * 删除用户
     */
    void removeUser(String userName) throws Exception;

    /**
     * @Description: 重置密码
     * @Author: 王斌
     * @Date: 2019/11/7
     */

    void  resetPassword(String userName);
}
