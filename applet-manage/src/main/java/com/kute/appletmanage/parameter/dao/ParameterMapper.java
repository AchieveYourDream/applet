package com.kute.appletmanage.parameter.dao;


import com.kute.appletcore.entity.SysParameterType;
import com.kute.appletcore.vo.SysParameterDefineVO;

import java.util.List;

/**
 * @Name: 系统设置
 * @Description: 包括系统参数定义和系统参数设置
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-06
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-06
 */
public interface ParameterMapper {

    /**
     * 获取参数类型列表
     */
    List<SysParameterType> getParameterTypeList() throws Exception;

    /**
     * 获取参数定义列表
     *
     * @param typeCode 参数类型编码
     */
    List<SysParameterDefineVO> getParameterDefineList(String typeCode) throws Exception;

    /**
     * 获取参数定义信息
     *
     * @param parameterCode 参数编码
     */
    SysParameterDefineVO getParameterDefineInfo(String parameterCode) throws Exception;

    /**
     * 获取参数配置列表
     *
     * @param typeCode 参数类型编码
     */
    List<SysParameterDefineVO> getParameterConfigList(String typeCode) throws Exception;

    /**
     * 删除参数定义列表
     *
     * @param typeCode 参数类型编码
     */
    void removeParameterDefineList(String typeCode) throws Exception;

    /**
     * 删除参数配置列表
     *
     * @param typeCode 参数类型编码
     */
    void removeParameterConfigList(String typeCode) throws Exception;

}
