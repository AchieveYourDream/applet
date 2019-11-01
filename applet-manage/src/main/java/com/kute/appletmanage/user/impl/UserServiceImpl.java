//package com.kute.appletmanage.user.impl;
//
//import com.kute.appletcore.dao.SysUserMapper;
//import com.kute.appletcore.dao.SysUserRoleMapper;
//import com.kute.appletcore.entity.SysUser;
//import com.kute.appletcore.entity.SysUserRole;
//import com.kute.appletcore.vo.SysUserRoleVO;
//import com.kute.appletcore.vo.SysUserVO;
//import com.kute.appletmanage.user.dao.UserMapper;
//import com.kute.appletmanage.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @Name: 用户管理
// * @Description: 用户管理
// */
//@Service
//public class UserServiceImpl  implements UserService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    @Autowired
//    private SysUserRoleMapper sysUserRoleMapper;
//
//    /**
//     * 获取用户列表
//     */
//    public List<SysUserVO> getUserList() throws Exception {
//        return userMapper.getUserList();
//    }
//
//    /**
//     * 获取用户信息
//     *
//     * @param userId 用户ID
//     */
////    public SysUser getUserInfoByUserId(String userId) throws Exception {
////        return sysUserMapper.selectByPrimaryKey(userId);
////    }
//
//    /**
//     * 获取用户信息
//     *
//     * @param userName 用户名
//     */
//    public SysUser getUserInfoByUserName(String userName) throws Exception {
//        return userMapper.getUserInfoByUserName(userName);
//    }
//
//    /**
//     * 新增用户
//     */
//    @Transactional
//    public void addUser(SysUser su) throws Exception {
//        Date date = new Date();
//        su.setStart_date(date);
//        su.setCreate_date(date);
//        su.setLast_update_date(date);
//        sysUserMapper.insert(su);
//    }
//
//    /**
//     * 编辑用户
//     */
//    @Transactional
//    public void editUser(SysUser su) throws Exception {
//        su.setLast_update_date(new Date());//最后修改时间
//        sysUserMapper.updateByPrimaryKey(su);
//    }
//
//    /**
//     * 修改用户状态
//     *
//     * @param userId     用户ID
//     * @param userStatus 用户状态
//     */
//    @Transactional
//    public void updateUserStatus(String userId, String userStatus) throws Exception {
//        SysUser su = this.getUserInfoByUserId(userId);
//
//        su.setUser_status(userStatus);
//
//        Date date = new Date();
//
//        if ("valid".equals(userStatus)) {
//            su.setStart_date(date);
//            su.setEnd_date(null);
//        } else if ("unvalid".equals(userStatus)) {
//            su.setEnd_date(date);
//        }
//
//        su.setLast_update_date(date);
//
//        sysUserMapper.updateByPrimaryKey(su);
//    }
//
//    /**
//     * 修改用户皮肤
//     *
//     * @param userId 用户ID
//     * @param skin   皮肤
//     */
//    @Transactional
//    public void updateUserSkin(String userId, String skin) throws Exception {
//        SysUser su = this.getUserInfoByUserId(userId);
//        su.setSkin(skin);
//        su.setLast_update_date(new Date());
//        sysUserMapper.updateByPrimaryKey(su);
//    }
//
//    /**
//     * 获取用户角色信息
//     *
//     * @param userId 用户ID
//     */
//    public List<SysUserRoleVO> getUserRoleList(String userId) throws Exception {
//        return userMapper.getUserRoleList(userId);
//    }
//
//    /**
//     * 新增用户角色
//     */
//    @Transactional
//    public void addUserRole(SysUserRole sur) throws Exception {
//        sysUserRoleMapper.insert(sur);
//    }
//
//    /**
//     * 删除用户
//     */
//    @Transactional
//    public void removeUser(String user_id) throws Exception {
//        sysUserMapper.deleteByPrimaryKey(user_id);    //删除用户
//        userMapper.deleteByUserId(user_id); //删除用户关联的角色
//
//    }
//
//    /**
//     * 删除用户角色
//     */
//    @Transactional
//    public void removeUserRole(String user_id, String role_id) throws Exception {
//        sysUserRoleMapper.deleteByPrimaryKey(user_id, role_id);
//    }
//}
