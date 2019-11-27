package com.kute.appletmanage.technologyConflict.dao;


import com.kute.appletcore.entity.SysTechnologyConflict;

import java.util.List;
import java.util.Map;

/**
 * @Name: 工艺冲突管理
 * @Description: 工艺冲突管理
 */
public interface TechnologyConflictMangerMapper {

    /**
     * 获取工艺冲突列表
     */
    List<SysTechnologyConflict> getTechnologyConflictList(String search) throws Exception;

    /**
     * 获取工艺下拉选
     */
    List<Map<String,String>> getTechnologyList(String search) throws Exception;

    /**
     * 根据工艺冲突名获取工艺冲突信息
     *
     */
    SysTechnologyConflict getTechnologyConflictInfoByTechnologyConflictCode(SysTechnologyConflict stc) throws Exception;





}
