package com.kute.appletmanage.lov.dao;


import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;

import java.util.List;
import java.util.Map;

/**
 * @Name: 值列表
 * @Description: 值列表
 */
public interface LovMapper {

    /**
     * 获取值列表定义列表
     */
    List<SysLovDefine> getLovDefineList() throws Exception;

    /**
     * 获取值列表视图列表
     *
     * @param schema 数据库名称
     */
    List<String> getLovViewList(String schema) throws Exception;

    /**
     * 获取值列表字段列表
     *
     * @param parameterMap 参数MAP
     */
    List<SysLovColumn> getLovColumnList(String  lovView) throws Exception;

    /**
     * 删除当前值列表的字段列表
     *
     * @param lovCode 值列表编码
     */
    void removeLovColumnList(String lovCode) throws Exception;



    List<Map<String, Object>> getLovViewColumnList(Map<String, Object> parameterMap);
    //List<Map<String, Object>> getLovViewColumnList();

    /**
     * 获取值列表视图字段列表
     */
    List<SysLovColumn> getLovViewColumnListBigData(Map<String, Object> map) throws Exception;

    /**
     * 获取值列表视图字段列表数量
     */
    int getLovViewColumnCount(Map<String, Object> map);
}
