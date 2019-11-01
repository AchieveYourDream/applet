package com.kute.appletcore.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysRoleResource", description = "角色资源")
public class SysRoleResource {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_resource.role_id
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    @ApiModelProperty(value = "角色ID")
    private String role_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_resource.resource_id
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    @ApiModelProperty(value = "资源ID")
    private String resource_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_resource.resource_type
     *
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    @ApiModelProperty(value = "资源类型")
    private String resource_type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_resource.role_id
     *
     * @return the value of sys_role_resource.role_id
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public String getRole_id() {
        return role_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_resource.role_id
     *
     * @param role_id the value for sys_role_resource.role_id
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_resource.resource_id
     *
     * @return the value of sys_role_resource.resource_id
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public String getResource_id() {
        return resource_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_resource.resource_id
     *
     * @param resource_id the value for sys_role_resource.resource_id
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_resource.resource_type
     *
     * @return the value of sys_role_resource.resource_type
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public String getResource_type() {
        return resource_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_resource.resource_type
     *
     * @param resource_type the value for sys_role_resource.resource_type
     * @mbggenerated Tue Apr 10 16:09:15 CST 2018
     */
    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }
}