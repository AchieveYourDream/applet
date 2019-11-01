package com.kute.appletmanage.information.service;

import com.kute.appletcore.vo.ResponseResult;

import java.util.HashMap;
import java.util.List;

public interface InformationService {
    /**
     * 获取资讯信息品类格局列表
     */
    ResponseResult selectAppInformationList( ) throws Exception;
    /**
     * 获取banner轮播图信息
     */
    ResponseResult selectByBanner( ) throws Exception;
    /**
     *  修改资讯管理照片
     *
     * @throws Exception
     */
    int updateInformationImage(String information_id,String show_pic) throws Exception;
    /**
     * @Description: 获取往期
     * @Author: 王斌
     */
    List<HashMap<String,Object>> getHistoryInfo(String node_code);
}
