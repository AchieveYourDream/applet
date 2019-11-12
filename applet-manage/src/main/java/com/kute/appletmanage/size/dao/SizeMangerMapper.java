package com.kute.appletmanage.size.dao;


import com.kute.appletcore.entity.AppSize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name: 尺码管理
 * @Description: 尺码管理
 */
public interface SizeMangerMapper {

    /**
     * 获取尺码列表
     */
    List<AppSize> getSizeList(String search) throws Exception;

    /**
     * 根据欧码和体型获取尺码信息
     *
     */
    AppSize getSizeInfoBySizeBodyAndEur(@Param("bodyType") String bodyType,@Param("eurCode") String eurCode) throws Exception;



}
