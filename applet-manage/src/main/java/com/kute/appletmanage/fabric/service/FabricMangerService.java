package com.kute.appletmanage.fabric.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysFabric;

public interface FabricMangerService {
    /**
     * 获取面料列表
     */
    PageInfo<SysFabric> getFabricList(Integer pageNum, Integer pageSize, String search) throws Exception;
    /**
     * 获取面料信息
     */
    SysFabric getFabricInfoByFabricCode(String fabricCode) throws Exception;
    /**
     * 新增面料
     */
    void addFabric(SysFabric sf) throws Exception;
    /**
     * 编辑面料
     */
    void editFabric(SysFabric sf) throws Exception;

    /**
     * 修改面料状态
     */
    void updateFabricStatus(String fabricCode, String fabricState) throws Exception;
    /**
     * 删除面料
     */
    void removeFabric(String fabricCode) throws Exception;

}
