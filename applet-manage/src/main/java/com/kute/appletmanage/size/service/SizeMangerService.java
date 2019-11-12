package com.kute.appletmanage.size.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppSize;
import com.kute.appletcore.vo.ResponseResult;

public interface SizeMangerService {
    /**
     * 获取尺码列表
     */
    PageInfo<AppSize> getSizeList(Integer pageNum, Integer pageSize, String search) throws Exception;
    /**
     * 获取尺码信息
     */
    AppSize getSizeInfoBySizeId(Integer SizeId) throws Exception;
    /**
     * 新增尺码
     */
    ResponseResult addSize(AppSize size) throws Exception;
    /**
     * 编辑尺码
     */
    ResponseResult editSize(AppSize size) throws Exception;

    /**
     * 删除尺码
     */
    void removeSize(Integer sizeId) throws Exception;

}
