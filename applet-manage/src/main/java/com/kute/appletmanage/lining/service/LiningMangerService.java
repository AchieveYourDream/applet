package com.kute.appletmanage.lining.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppLining;

import java.util.List;
import java.util.Map;

public interface LiningMangerService {
    /**
     * 获取衬类型列表
     */
    PageInfo<AppLining> getLiningList(Integer pageNum, Integer pageSize, String search) throws Exception;

    /**
     * 获取衬类型信息
     */
    AppLining getLiningInfoById(Integer Id) throws Exception;
    /**
     * 获取衬类型信息
     */
    AppLining getLiningInfoByLiningCode(String liningCode,String category) throws Exception;
    /**
     * 新增衬类型
     */
    void addLining(AppLining sf) throws Exception;
    /**
     * 编辑衬类型
     */
    void editLining(AppLining sf) throws Exception;

    /**
     * 删除衬类型
     */
    void removeLining(Integer id) throws Exception;

    /**
     * 根据品类获取衬类型
     */
    List<Map> getLiningListByCategory(String category) throws Exception;

}
