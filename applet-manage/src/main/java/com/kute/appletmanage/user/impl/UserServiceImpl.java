package com.kute.appletmanage.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.SysUserMapper;
import com.kute.appletcore.dao.SysUserRoleMapper;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletmanage.user.dao.UserMapper;
import com.kute.appletmanage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 用户管理
 * @Description: 用户管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 获取用户列表
     */
    public PageInfo<SysUser> getUserList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<SysUser> list = userMapper.getUserList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取用户信息
     *
     * @param userName 用户名
     */
    public SysUser getUserInfoByUserName(String userName) throws Exception {
        return userMapper.getUserInfoByUserName(userName);
    }

    /**
     * 新增用户
     */
    
    public void addUser(SysUser su) throws Exception {
        sysUserMapper.insert(su);
    }

    /**
     * 编辑用户
     */
    
    public void editUser(SysUser su) throws Exception {
        sysUserMapper.updateByPrimaryKey(su);
    }

    /**
     * 修改用户状态
     *
     */
    
    public void updateUserStatus(String userName, String userState) throws Exception {
        userMapper.updateUserState(userName,userState);
    }


    /**
     * 删除用户
     */
    
    public void removeUser(String userName) throws Exception {
        sysUserMapper.deleteByPrimaryKey(userName);    //删除用户
        userMapper.deleteUserRoleByUserName(userName); //删除用户关联的角色

    }

    @Override
    public void resetPassword(String userName) {
        userMapper.resetPassword(userName);
    }
}
