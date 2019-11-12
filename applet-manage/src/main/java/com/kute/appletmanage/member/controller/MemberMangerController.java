package com.kute.appletmanage.member.controller;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppMember;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.member.service.MemberMangerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name: 会员管理
 * @Description: 会员管理
 */
@RestController
@RequestMapping("/app/system/member/")
@Api(value = "UserController", tags = " 系统模块-会员管理")
public class MemberMangerController {

    @Autowired
    private MemberMangerService memberMangerService;

    /**
     * 获取会员列表
     */
    @ApiOperation(value = "获取会员列表")
    @RequestMapping(value = "getMemberList", method = RequestMethod.GET)
    public Map getMemberList(Integer pageNum, Integer pageSize, String search) throws Exception {
        Map dataMap = new HashMap();
        PageInfo<AppMember> list =  memberMangerService.getMemberList( pageNum,  pageSize,  search);

        dataMap.put("total", list.getTotal());
        dataMap.put("rows", list.getList());

        return dataMap;
    }

    /**
     * 获取会员信息
     */
    @ApiOperation(value = "获取会员信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "memberTel", value = "会员ID", paramType = "query", required = true)})
    @RequestMapping(value = "getMemberInfoByMemberTel", method = RequestMethod.GET)
    public ResponseResult getMemberInfoByMemberTel(@RequestParam(value = "memberTel") String memberTel) throws Exception {
        AppMember su = memberMangerService.getMemberInfoByMemberTel(memberTel);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(su);
        return result;
    }

    /**
     * 检查会员名是否存在
     */
    @ApiOperation(value = "检查会员名是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "会员名", paramType = "query", required = true)})
    @RequestMapping(value = "checkMemberTel", method = RequestMethod.GET)
    public boolean checkMemberTel(@RequestParam(value = "memberTel") String memberTel) throws Exception {
        boolean result;

        AppMember su = memberMangerService.getMemberInfoByMemberTel(memberTel);

        if (su == null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 新增会员
     */
    @ApiOperation(value = "新增会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appMember", value = "会员对象[AppMember]", paramType = "body", dataType = "AppMember", required = true)})
    @RequestMapping(value = "addMember", method = RequestMethod.POST)
    public ResponseResult addMember( AppMember appMember) throws Exception {
        memberMangerService.addMember(appMember);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);

        return result;
    }

    /**
     * 编辑会员
     */
    @ApiOperation(value = "编辑会员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "su", value = "会员对象[AppMember]", paramType = "body", dataType = "AppMember", required = true)})
    @RequestMapping(value = "editMember", method = RequestMethod.POST)
    public ResponseResult editMember( AppMember appMember) throws Exception {
        memberMangerService.editMember(appMember);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }

    /**
     * 删除会员
     */
    @ApiOperation(value = "删除会员")
    @ApiImplicitParams({@ApiImplicitParam(name = "memberTel", value = "会员code", paramType = "query", required = true)})
    @RequestMapping(value = "removeMember", method = RequestMethod.POST)
    public ResponseResult removeMember(@RequestParam(value = "memberTel") String memberTel) throws Exception {
        memberMangerService.removeMember(memberTel);
        ResponseResult result = new ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setInfo(ApplicationConstant.REMOVE_SUCESS);

        return result;
    }





}
