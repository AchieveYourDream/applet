package com.kute.appletweb.member.controller;


import com.kute.appletcore.entity.AppCusAddress;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletweb.member.service.MemberWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("all")
@Api(value = "MemberWebController", tags = "前台用户登陆收货地址编辑模块模块")
@RequestMapping(value = "/api/")
public class MemberWebController {

	@Autowired
	private MemberWebService memberWebService;

	/**
	 * 登录
	 */
	@ApiOperation(value = "登录")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseResult login(@RequestParam String  username,@RequestParam String verificationCode ) throws Exception {
		ResponseResult result =null;
		result = memberWebService.login(  username, verificationCode );

		return result;
	}



	@ApiOperation(value = "获取验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "memberTel", value = "用户名", paramType = "query",  required = true) })
	@RequestMapping(value = "getVerificationCode", method = RequestMethod.POST)
	public ResponseResult getVerificationCode(@Param("memberTel") String  memberTel) throws Exception {
		ResponseResult result =null;
		result = memberWebService.getVerificationCode(memberTel);

		return result;
	}

	@ApiOperation(value = "获取会员收货地址列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "member_id", value = "会员id", paramType = "query", dataType = "String", required = true),
	})
	@GetMapping(value = "selectCusAddressList")
	public ResponseResult selectCusAddressList(@Param("member_id") String  member_id) throws Exception {
		ResponseResult result =new ResponseResult();
		List<AppCusAddress> list=memberWebService.selectCusAddressList(member_id);
		result.setCode( EnumResultType.SUCCESS.toString());
		result.setData(list);
		return result;
	}

	@ApiOperation(value = "插入收获地址")
	@PostMapping(value = "insetMemberAddress")
	public ResponseResult insetMemberAddress(@RequestBody AppCusAddress addredd) throws Exception {
		ResponseResult result =new ResponseResult();
		memberWebService.insetMemberAddress(addredd);
		result.setCode( EnumResultType.SUCCESS.toString());
		result.setData("保存成功");
		return result;
	}


	@ApiOperation(value = "修改收货地址")
	@PutMapping(value = "updateMemberAddress")
	public ResponseResult updateMemberAddress(@RequestBody AppCusAddress addredd) throws Exception {
		ResponseResult result =new ResponseResult();
		memberWebService.updateMemberAddress(addredd);
		result.setCode( EnumResultType.SUCCESS.toString());
		result.setData("修改成功");
		return result;
	}


	@ApiOperation(value = " 删除收获地址")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "address_id", value = "地址ID", paramType = "query", dataType = "String", required = true),
	})
	@DeleteMapping(value = "deleteMemberAddress")
	public ResponseResult deleteMemberAddress(@Param("address_id") String  address_id) throws Exception {
		ResponseResult result =new ResponseResult();
		memberWebService.deleteMemberAddress(address_id);
		result.setCode( EnumResultType.SUCCESS.toString());
		result.setData("刪除成功");
		return result;
	}


	@ApiOperation(value = " 修改默认地址")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "member_id", value = "会员id", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "address_id", value = "地址ID", paramType = "query", dataType = "String", required = true),
	})
	@PutMapping(value = "updateAddressDefault")
	public ResponseResult updateAddressDefault(@Param("member_id") String  member_id,@Param("address_id") String  address_id) throws Exception {
		ResponseResult result =new ResponseResult();
		memberWebService.updateAddressDefault(member_id,address_id);
		result.setCode( EnumResultType.SUCCESS.toString());
		result.setData("修改成功");
		return result;
	}


}
