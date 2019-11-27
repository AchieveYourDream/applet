package com.kute.appletgoods.information.controller;

import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletgoods.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
