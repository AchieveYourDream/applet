package com.kute.appletmanage.user.dao;


import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.vo.SysUserRoleVO;
import org.apache.ibatis.annotations.Param;

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
    List<SysUser> getUserList(String search) throws Exception;

    /**
     * 根据用户名获取用户信息
     *
     * @param userName 用户名
     */
    SysUser getUserInfoByUserName(String userName) throws Exception;


    /**
     * 删除用户关联的角色
     *
     * @param user_id
     */
    void deleteUserRoleByUserName(String userName);
    
    /** 
    * @Description: 失效启用用户
    * @Author: 王斌
    * @Date: 2019/11/6 
    */
    void updateUserState(@Param("userName") String  userName, @Param("userState") String userState);
    
    /** 
    * @Description: 重置密码
    * @Author: 王斌
    * @Date: 2019/11/7 
    */

   void  resetPassword(String userName);

}
