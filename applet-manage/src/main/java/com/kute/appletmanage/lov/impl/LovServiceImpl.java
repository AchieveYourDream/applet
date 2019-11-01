package com.kute.appletmanage.lov.impl;

import com.kute.appletcore.dao.SysLovColumnMapper;
import com.kute.appletcore.dao.SysLovDefineMapper;
import com.kute.appletcore.entity.SysLovColumn;
import com.kute.appletcore.entity.SysLovDefine;
import com.kute.appletmanage.lov.dao.LovMapper;
import com.kute.appletmanage.lov.service.LovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name: 值列表
 * @Description: 值列表
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-18
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-18
 */
@Service
public class LovServiceImpl implements LovService {

    @Value("applet")
    private String schema;

    @Autowired
    private LovMapper lovMapper;

    @Autowired
    private SysLovDefineMapper sysLovDefineMapper;

    @Autowired
    private SysLovColumnMapper sysLovColumnMapper;

    /**
     * 获取值列表定义列表
     */
    public List<SysLovDefine> getLovDefineList() throws Exception {
        return lovMapper.getLovDefineList();
    }

    /**
     * 获取值列表视图列表
     */
    public List<String> getLovViewList() throws Exception {
        return lovMapper.getLovViewList(schema);
    }

    /**
     * 删除值列项
     */
    public void removeLovDefine(String lovCode) throws Exception {
        sysLovDefineMapper.deleteByPrimaryKey(lovCode);
    }

    /**
     * 删除值列表
     */
    public void removeLovColumnList(String lovCode) throws Exception {
        lovMapper.removeLovColumnList(lovCode);
    }


    /**
     * 获取值列表定义信息
     */
    public SysLovDefine getLovDefineInfo(String lovCode) throws Exception {
        return sysLovDefineMapper.selectByPrimaryKey(lovCode);
    }

    /**
     * 获取值列表视图字段列表
     *
     * @param viewName 视图名称
     * @param lovCode  值列表编码
     */
    public List<SysLovColumn> getLovColumnList(String viewName, String lovCode) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("schema", schema);
        parameterMap.put("viewName", viewName);
        parameterMap.put("lovCode", lovCode);

        List<SysLovColumn> slcList = null;
        slcList = lovMapper.getLovColumnList(parameterMap);
        /*if (lovCode != null && !"".equals(lovCode)) {
            slcList = lovMapper.getLovColumnList(parameterMap);
        } else {
            slcList = lovMapper.getLovViewColumnList(parameterMap);
        }*/

        return slcList;
    }

    public List<Map<String, Object>> getLovViewColumnList(String viewName) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("viewName", viewName);
        return lovMapper.getLovViewColumnList(parameterMap);
    }

    /**
     * 保存值列表信息
     */
    @Transactional
    public void saveLovInfo(SysLovDefine sld, List<SysLovColumn> slcList) throws Exception {
        SysLovDefine oldSLD = sysLovDefineMapper.selectByPrimaryKey(sld.getLovCode());

        if (oldSLD == null) {
            sysLovDefineMapper.insert(sld);
        } else {
            sysLovDefineMapper.updateByPrimaryKey(sld);
        }

        lovMapper.removeLovColumnList(sld.getLovCode());

        for (SysLovColumn slc : slcList) {
            sysLovColumnMapper.insert(slc);
        }
    }

    /**
     * 获取值列表视图字段列表
     */
    public List<SysLovColumn> getLovViewColumnListBigData(String offset, String limit, String search, String viewName, String appSearch) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", offset);
        map.put("limit", limit);
        map.put("search", search);
        map.put("viewName", viewName);
        map.put("appSearch", appSearch);
        return lovMapper.getLovViewColumnListBigData(map);
    }

    /**
     * 获取值列表视图字段列表数量
     */
    public int getLovViewColumnCount(String search, String viewName, String appSearch) {
        Map<String, Object> map = new HashMap<>();
        map.put("search", search);
        map.put("viewName", viewName);
        map.put("appSearch", appSearch);
        int count = lovMapper.getLovViewColumnCount(map);
        return count;
    }

}
