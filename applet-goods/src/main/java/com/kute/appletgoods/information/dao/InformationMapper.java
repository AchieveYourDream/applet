package com.kute.appletgoods.information.dao;

import com.kute.appletcore.entity.AppInformation;
import com.kute.appletcore.vo.InformationVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InformationMapper {
    /**
     * 获取资讯信息品类格局列表
     * @param appid
     * @return
     */
    List<InformationVO> selectAppInformationList();

    /**
     * 获取资讯信息品类node_code获取资讯详情列表
     * @param appid
     * @return
     */
    List<AppInformation> selectAllByUseModule(String use_madule);

    /**
     * 获取banner轮播图信息
     * @param appid
     * @return
     */
    List<AppInformation> selectByBanner();

    /**
     *  修改资讯管理照片
     *
     * @throws Exception
     */
     int updateInformationImage(Map map);

    /**
     * @Description: 获取往期
     * @Author: 王斌
     * @Date: 2019/4/15
     */
    List<HashMap<String,Object>> getHistoryInfo(String node_code);
}
