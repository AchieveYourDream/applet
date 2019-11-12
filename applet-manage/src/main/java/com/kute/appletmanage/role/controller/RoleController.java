package com.kute.appletmanage.role.controller;

import com.kute.appletcore.entity.SysRole;
import com.kute.appletcore.entity.SysUser;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.role.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Name: 角色管理
 * @Description: 角色管理
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-19
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-19
 */
@RestController
@RequestMapping("/app/system/role/")
@Api(value = "RoleController", tags = " 系统模块-角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     */
    @ApiOperation(value = "获取所有角色列表")
    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    public ResponseResult getRoleList() throws Exception {
        List<SysRole> list = roleService.selectAll();

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);

        return result;
    }

    /**
     * 获取角色信息
     */
    @ApiOperation(value = "获取角色相信信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true)})
    @RequestMapping(value = "getRoleInfo", method = RequestMethod.GET)
    public ResponseResult getRoleInfo(@RequestParam(value = "roleId") String roleId) throws Exception {

        SysRole sr = roleService.getRoleInfo(roleId);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(sr);
        return result;
    }
    /**
     * 获取角色用户列表
     */
    @ApiOperation(value = "获取角色用户列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true)})
    @RequestMapping(value = "getRoleUserList", method = RequestMethod.GET)
    public ResponseResult getRoleUserList(@RequestParam(value = "roleId") String roleId) throws Exception {

        List<SysUser> sr = roleService.getRoleUserList(roleId);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(sr);
        return result;
    }

    /**
     * 检查角色名称是否存在
     */
    @ApiOperation(value = "检查角色名称是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleName", value = "角色名称", paramType = "query", required = true)})
    @RequestMapping(value = "checkRoleName", method = RequestMethod.GET)
    public boolean checkRoleName(@RequestParam(value = "roleName") String roleName) throws Exception {
        boolean result;
        SysRole sr = roleService.getRoleInfoByRoleName(roleName);
        if (sr == null) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }


    /**
     * 新增角色
     */
    @ApiOperation(value = "新增角色")
    @ApiImplicitParams({@ApiImplicitParam(name = "sr", value = "角色对象[SysRole]", paramType = "body", dataType = "SysRole", required = true)})
    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public ResponseResult addRole( SysRole sr) throws Exception {
        roleService.addRole(sr);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }


    /**
     * 编辑角色
     */
    @ApiOperation(value = "编辑角色")
    @ApiImplicitParams({@ApiImplicitParam(name = "sr", value = "角色对象[SysRole]", paramType = "body", dataType = "SysRole", required = true)})
    @RequestMapping(value = "editRole", method = RequestMethod.POST)
    public ResponseResult editRole( SysRole sr) throws Exception {
        roleService.editRole(sr);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }


    /**
     * 获取菜单权限树
     */
    @ApiOperation(value = "获取菜单权限树  带勾选框")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true),
            @ApiImplicitParam(name = "menuStructCode", value = "菜单结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "getMenuAuthTree", method = RequestMethod.GET)
    public ResponseResult getMenuAuthTree(@RequestParam(value = "roleId") String roleId,
                                          @RequestParam(value = "menuStructCode") String menuStructCode) throws Exception {

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(roleService.getMenuAuthTree(roleId, menuStructCode));

        return result;
    }

    /**
     * 保存角色菜单权限信息
     */
    @ApiOperation(value = "保存角色菜单权限信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true),
            @ApiImplicitParam(name = "menuCode", value = "菜单结构编码", paramType = "query", required = true)})
    @RequestMapping(value = "saveRoleMenuAuth", method = RequestMethod.POST)
    public ResponseResult saveRoleMenuAuth(@RequestParam(value = "roleId") Integer roleId,
                                           @RequestParam(value = "menuCode") String menuCode) throws Exception {
        roleService.saveRoleMenuAuth(roleId, menuCode);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 删除角色信息
     */
    @ApiOperation(value = "删除角色信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true)})
    @RequestMapping(value = "roleDelete", method = RequestMethod.GET)
    public ResponseResult roleDelete(@RequestParam(value = "roleId") String roleId) throws Exception {

        roleService.roleDelete(roleId);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData("");

        return result;
    }
    /**
     * 添加角色用户关系
     */
    @ApiOperation(value = "删除角色用户关系")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true)})
    @RequestMapping(value = "addRoleUserRelation", method = RequestMethod.GET)
    public ResponseResult addRoleUserRelation(@RequestParam(value = "roleId") Integer roleId,String  userList) throws Exception {

        roleService.addRoleUserRelation(roleId,userList);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData("");

        return result;
    }




    /**
     * 删除角色用户关系
     */
    @ApiOperation(value = "删除角色用户关系")
    @ApiImplicitParams({@ApiImplicitParam(name = "roleId", value = "角色ID", paramType = "query", required = true)})
    @RequestMapping(value = "delRoleUserRelation", method = RequestMethod.GET)
    public ResponseResult delRoleUserRelation(@RequestParam(value = "roleId") String roleId,String  userList) throws Exception {

        roleService.delRoleUserRelation(roleId,userList);

        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData("");

        return result;
    }

}
