package com.kute.appletmanage.information.controller;

import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.util.FileUtil;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@SuppressWarnings("all")
@Api(value = "AppInformationController", tags = "小程序")
@RequestMapping(value = "/appInformation")
public class InformationCntroller {


    @Autowired
    private InformationService informationService;
    //图片存放地址
    @Value("${applet.imgSavePath}")
    private String imgSavePath;


    @GetMapping(value = "/selectAppInformationList")
    @ApiOperation(value = "获取资讯信息品类格局列表")
    public ResponseResult selectAppInformationList() throws Exception {
        ResponseResult result=null;
        result   = informationService.selectAppInformationList();

        return result;
    }

    @GetMapping(value = "/selectByBanner")
    @ApiOperation(value = "获取banner轮播图信息")
    public ResponseResult selectByBanner() throws Exception {
        ResponseResult result=null;
        result = informationService.selectByBanner();
        return result;
    }

    @PostMapping("updateInformationImage/{path}")
    @ApiOperation(value = "更新资讯信息图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "information_id", value = "资讯ID", paramType = "query", dataType = "String", required = true),

    })
    public @ResponseBody
    ResponseResult updateInformationImage(@PathVariable("path")String  path, @Param("information_id")String  information_id, @RequestParam MultipartFile pic) throws Exception {
        ResponseResult result = new ResponseResult();
        if(pic!=null){
            String imgName= FileUtil.uploadFile(imgSavePath+path,pic);
            informationService.updateInformationImage(information_id,imgName);
            result.setCode(EnumResultType.SUCCESS.toString());
            result.setInfo(ApplicationConstant.SAVE_SUCCESS);
        }else{
            result.setCode(EnumResultType.ERROR.toString());
            result.setInfo("图片为空");
        }
        return result;
    }


    @GetMapping(value = "/getHistoryInfo")
    @ApiOperation(value = "获取往期")
    public ResponseResult selectByBanner(@RequestParam String node_code ) throws Exception {
        ResponseResult result=new ResponseResult();
        List<HashMap<String,Object>> list=informationService.getHistoryInfo(node_code);
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(list);
        return result;
    }

}
