package com.kute.appletmanage.lining.dao;


import com.kute.appletcore.entity.AppLining;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Name: 衬类型管理
 * @Description: 衬类型管理
 */
public interface LiningMangerMapper {

    /**
     * 获取衬类型列表
     */
    List<AppLining> getLiningList(String search) throws Exception;

    /**
     * 根据衬类型名获取衬类型信息
     *
     */
    AppLining getLiningInfoByLiningCode(@Param("liningCode") String liningCode, @Param("category")String  category) throws Exception;



    /**
     * 根据品类获取衬类型
     */
    List<Map> getLiningListByCategory(String category) throws Exception;

}
