package com.kute.appletmanage.stitchwork.dao;


import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;
import com.kute.appletcore.vo.AppStitchWorkPositionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name: 刺绣位置管理
 * @Description: 刺绣位置管理
 */
public interface StitchWorkMangerMapper {

    /**
     * 获取刺绣位置列表
     */
    List<AppStitchWorkPosition> getStitchWorkPositionList(String search) throws Exception;

    /**
     * 根据刺绣位置工厂编码
     *
     */
    AppStitchWorkPosition getStitchWorkPositionInfoByFactoryCode(String factoryCode) throws Exception;



    /**
     * 获取刺绣列表
     */
    List<AppStitchWork> getStitchWorkList(String search) throws Exception;

    /**
     * 检查刺绣工厂编码是否存在
     *
     */
    AppStitchWork getStitchWorkInfoByStitchWorkCode(String fabricCode) throws Exception;


    /**
     * 获取刺绣列表
     */
    List<AppStitchWorkPositionVO> getStitchWorkRelationList(Integer stitchWorkId) throws Exception;




   int  insertStitchWorkPositionRelation(@Param("stitchWorkId") Integer stitchWorkId,@Param("positionArray")  String  positionArray);
    




}
