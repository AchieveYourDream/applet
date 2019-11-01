package com.kute.appletmanage.member.controller;

import com.kute.appletcore.entity.AppMember;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
@Api(value = "MemberController", tags = "会员模块")
@RequestMapping(value = "/app/member")
public class MemberController {


    @Autowired
    private MemberService memberService;


    @PostMapping(value = "/updateByPrimaryKey")
    @ApiOperation(value = "根据某个会员手机号修改个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "令牌", required = true, dataType = "String", paramType = "header")
    })
    public ResponseResult updateByPrimaryKey(@RequestBody AppMember appMember) throws Exception {
        ResponseResult result = new  ResponseResult();
        memberService.updateByPrimaryKey(appMember);
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(ApplicationConstant.SAVE_SUCCESS);
        return result;
    }


}
