package com.kute.appletmanage.technologyConflict.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysTechnologyConflict;
import com.kute.appletcore.vo.ResponseResult;

import java.util.List;
import java.util.Map;

public interface TechnologyConflictMangerService {
    /**
     * 获取工艺冲突列表
     */
    PageInfo<SysTechnologyConflict> getTechnologyConflictList(Integer pageNum, Integer pageSize, String search) throws Exception;

    /**
     * 获取工艺冲突信息
     */
    SysTechnologyConflict getTechnologyConflictInfoByTechnologyConflictId(Integer id) throws Exception;

    /**
     * 获取工艺下拉选
     */
    List<Map<String, String>> getTechnologyList(String search) throws Exception;

    /**
     * 新增工艺冲突
     */
    ResponseResult addTechnologyConflict(SysTechnologyConflict sf) throws Exception;

    /**
     * 删除工艺冲突
     */
    void removeTechnologyConflict(Integer id) throws Exception;

}
