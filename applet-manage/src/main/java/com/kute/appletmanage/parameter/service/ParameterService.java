package com.kute.appletmanage.parameter.service;

import com.kute.appletcore.entity.SysParameterConfig;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.entity.SysParameterType;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletcore.vo.SysParameterDefineVO;

import java.util.List;

public interface ParameterService {
    /**
     * 获取参数类型列表
     */
    List<SysParameterType> getParameterTypeList() throws Exception;
    /**
     * 获取参数类型信息
     * @param typeCode 参数类型编码
     */
    SysParameterType getParameterTypeInfo(String typeCode) throws Exception;
    /**
     * 新建参数类型
     * @param spt 参数类型
     */
    void addParameterType(SysParameterType spt) throws Exception;
    /**
     * 编辑参数类型
     * @param spt 参数类型
     */
    void editParameterType(SysParameterType spt) throws Exception;
    /**
     * 删除参数类型
     * @param typeCode 参数类型编码
     */
    void removeParameterType(String typeCode) throws Exception;

    /**
     * 获取参数定义列表
     * @param typeCode 参数类型
     */
    List<SysParameterDefineVO> getParameterDefineList(String typeCode) throws Exception;

    /**
     * 获取参数定义信息
     * @param parameterCode 参数编码
     */
    SysParameterDefineVO getParameterDefineInfo(String parameterCode) throws Exception;
    /**
     * 新建参数
     */
    void addParameterDefine(SysParameterDefine spd) throws Exception;
    /**
     * 编辑参数
     */
    void editParameterDefine(SysParameterDefine spd) throws Exception;
    /**
     * 删除参数
     * @param parameterCode 参数编码
     */
    void removeParameterDefine(String parameterCode) throws Exception;
    /**
     * 获取参数配置列表
     * @param typeCode 参数类型
     */
    List<SysParameterDefineVO> getParameterConfigList(String typeCode) throws Exception;
    /**
     * 保存参数设置
     */
    void saveParameterConfig(List<SysParameterConfig> spcList) throws Exception;

    ResponseResult<SysParameterConfig> getParameterValue(String parameterCode);




}


