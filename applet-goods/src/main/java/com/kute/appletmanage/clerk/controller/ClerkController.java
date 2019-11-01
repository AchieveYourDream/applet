package com.kute.appletmanage.clerk.controller;

import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.util.FileUtil;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.clerk.service.ClerkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@SuppressWarnings("all")
@Api(value = "AppClerkController", tags = "小程序")
@RequestMapping(value = "/open/goods/appClerk")
public class ClerkController {


    @Autowired
    private ClerkService clerkService;

    //图片存放地址
    @Value("${applet.imgSavePath}")
    private String imgSavePath;

    @GetMapping(value = "/selectAppClerkList")
    @ApiOperation(value = "获取小程序量体师列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "currentPage", value = "当前页", paramType = "query", dataType = "Integer", required = true),
//            @ApiImplicitParam(name = "pageSize", value = "页条数", paramType = "query", dataType = "Integer", required = true),
//
//    })
    public ResponseResult selectAppClerkList(//@Param("currentPage") Integer currentPage,
                                             //@Param("pageSize") Integer pageSize
                                             ) throws Exception {
        ResponseResult result = null;
        //currentPage, pageSize
        result  = clerkService.selectAppClerkList();
        return result;
    }


    @PostMapping("updateClerkImage/{path}")
    @ApiOperation(value = "修改量体师头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "store_code", value = "门店ID", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "clerk_id", value = "量体师id", paramType = "query", dataType = "String", required = true),

    })
    public @ResponseBody ResponseResult updateClerkImage(@PathVariable("path")String  path, @Param("store_code")String  store_code, @Param("clerk_id")String  clerk_id, @RequestParam MultipartFile pic) throws Exception {
        ResponseResult result = new ResponseResult();
            if(pic!=null){
                String clerk_image= FileUtil.uploadFile(imgSavePath+path,pic);
                clerkService.updateClerkImage(store_code,clerk_id,clerk_image);
                result.setCode(EnumResultType.SUCCESS.toString());
                result.setInfo(ApplicationConstant.SAVE_SUCCESS);
            }else{
                result.setCode(EnumResultType.ERROR.toString());
                result.setInfo("图片为空");
            }
        return result;
    }
}
