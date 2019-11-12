package com.kute.appletmanage.fabric.dao;


import com.kute.appletcore.entity.SysFabric;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Name: 面料管理
 * @Description: 面料管理
 */
public interface FabricMangerMapper {

    /**
     * 获取面料列表
     */
    List<SysFabric> getFabricList(String search) throws Exception;

    /**
     * 根据面料名获取面料信息
     *
     */
    SysFabric getFabricInfoByFabricCode(String fabricCode) throws Exception;



    /** 
    * @Description: 修改面料状态
    * @Author: 王斌
    * @Date: 2019/11/6 
    */
    void updateFabricStatus(@Param("fabricCode") String fabricCode, @Param("fabricState") String fabricState);
    

}
