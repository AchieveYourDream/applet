package com.kute.appletmanage.lov.service;

import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;

import java.util.List;
import java.util.Map;

public interface LovService {
    /**
     * 获取值列表定义列表
     */
    List<SysLovDefine> getLovDefineList() throws Exception;
    /**
        * 获取值列表视图列表
     */
    List<String> getLovViewList() throws Exception;
    /**
     * 删除值列项
     */
    void removeLovDefine(String lovCode) throws Exception;
    /**
     * 删除值列表
     */
    void removeLovColumnList(String lovCode) throws Exception;
    /**
     * 获取值列表定义信息
     */
    SysLovDefine getLovDefineInfo(String lovCode) throws Exception;

    /**
     * 获取值列表视图字段列表
     * @param viewName 视图名称
     * @param lovCode  值列表编码
     */
    List<SysLovColumn> getLovColumnList(String viewName, String lovCode) throws Exception;

    List<Map<String, Object>> getLovViewColumnList(String viewName) throws Exception;
    /**
     * 保存值列表信息
     */
    void saveLovInfo(SysLovDefine sld, List<SysLovColumn> slcList) throws Exception;
    /**
     * 获取值列表视图字段列表
     */
    List<SysLovColumn> getLovViewColumnListBigData(String offset, String limit, String search, String viewName, String appSearch) throws Exception;
    /**
     * 获取值列表视图字段列表数量
     */
    int getLovViewColumnCount(String search, String viewName, String appSearch);

}
