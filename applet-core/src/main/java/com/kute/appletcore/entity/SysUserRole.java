package com.kute.appletcore.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysUserRole", description = "用户角色关系")
public class SysUserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.user_id
     *
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    @ApiModelProperty(value = "用户ID")
    private String user_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.role_id
     *
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    @ApiModelProperty(value = "角色ID")
    private String role_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.user_id
     *
     * @return the value of sys_user_role.user_id
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.user_id
     *
     * @param user_id the value for sys_user_role.user_id
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.role_id
     *
     * @return the value of sys_user_role.role_id
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    public String getRole_id() {
        return role_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.role_id
     *
     * @param role_id the value for sys_user_role.role_id
     * @mbggenerated Tue Apr 10 16:09:16 CST 2018
     */
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}