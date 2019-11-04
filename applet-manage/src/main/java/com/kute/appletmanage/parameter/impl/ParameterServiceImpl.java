package com.kute.appletmanage.parameter.impl;

import com.kute.appletcore.dao.SysParameterConfigMapper;
import com.kute.appletcore.dao.SysParameterDefineMapper;
import com.kute.appletcore.dao.SysParameterTypeMapper;
import com.kute.appletcore.entity.SysParameterConfig;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.entity.SysParameterType;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.util.ApplicationConstant;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletcore.vo.SysParameterDefineVO;
import com.kute.appletmanage.parameter.dao.ParameterMapper;
import com.kute.appletmanage.parameter.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 系统设置
 * @Description: 包括系统参数定义和系统参数设置
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-06
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterMapper parameterMapper;

    @Autowired
    private SysParameterTypeMapper sysParameterTypeMapper;

    @Autowired
    private SysParameterDefineMapper sysParameterDefineMapper;

    @Autowired
    private SysParameterConfigMapper sysParameterConfigMapper;


    /**
     * 获取参数类型列表
     */
    public List<SysParameterType> getParameterTypeList() throws Exception {
        return parameterMapper.getParameterTypeList();
    }

    /**
     * 获取参数类型信息
     *
     * @param typeCode 参数类型编码
     */
    public SysParameterType getParameterTypeInfo(String typeCode) throws Exception {
        return sysParameterTypeMapper.selectByPrimaryKey(typeCode);
    }

    /**
     * 新建参数类型
     *
     * @param spt 参数类型
     */
    @Transactional
    public void addParameterType(SysParameterType spt) throws Exception {
        sysParameterTypeMapper.insert(spt);
    }

    /**
     * 编辑参数类型
     *
     * @param spt 参数类型
     */
    @Transactional
    public void editParameterType(SysParameterType spt) throws Exception {
        sysParameterTypeMapper.updateByPrimaryKey(spt);
    }

    /**
     * 删除参数类型
     *
     * @param typeCode 参数类型编码
     */
    @Transactional
    public void removeParameterType(String typeCode) throws Exception {
        // 1.删除当前参数类型的参数配置列表
        parameterMapper.removeParameterConfigList(typeCode);

        // 2.删除当前参数类型的参数定义列表
        parameterMapper.removeParameterDefineList(typeCode);

        // 3.删除参数类型
        sysParameterTypeMapper.deleteByPrimaryKey(typeCode);
    }

    /**
     * 获取参数定义列表
     *
     * @param typeCode 参数类型
     */
    public List<SysParameterDefineVO> getParameterDefineList(String typeCode) throws Exception {
        return parameterMapper.getParameterDefineList(typeCode);
    }

    /**
     * 获取参数定义信息
     *
     * @param parameterCode 参数编码
     */
    public SysParameterDefineVO getParameterDefineInfo(String parameterCode) throws Exception {
        return parameterMapper.getParameterDefineInfo(parameterCode);
    }

    /**
     * 新建参数
     */
    @Transactional
    public void addParameterDefine(SysParameterDefine spd) throws Exception {
        // 1.新增参数
        sysParameterDefineMapper.insert(spd);

//        // 2.更新Redis缓存
//        parameterRedisDao.addParameter(spd.getParameter_code(), null);
    }

    /**
     * 编辑参数
     */
    @Transactional
    public void editParameterDefine(SysParameterDefine spd) throws Exception {
        sysParameterDefineMapper.updateByPrimaryKey(spd);
    }

    /**
     * 删除参数
     *
     * @param parameterCode 参数编码
     */
    @Transactional
    public void removeParameterDefine(String parameterCode) throws Exception {
        // 1.删除当前参数配置
        sysParameterConfigMapper.deleteByPrimaryKey(parameterCode);

        // 2.删除当前参数
        sysParameterDefineMapper.deleteByPrimaryKey(parameterCode);

//        // 3.清除Redis缓存
//        parameterRedisDao.removeParameter(parameterCode);
    }

    /**
     * 获取参数配置列表
     *
     * @param typeCode 参数类型
     */
    public List<SysParameterDefineVO> getParameterConfigList(String typeCode) throws Exception {
        return parameterMapper.getParameterConfigList(typeCode);
    }

    /**
     * 保存参数设置
     */
    @Transactional
    public void saveParameterConfig(List<SysParameterConfig> spcList) throws Exception {
        for (SysParameterConfig spc : spcList) {
            SysParameterConfig spcEntity = sysParameterConfigMapper.selectByPrimaryKey(spc.getParameterCode());

            if (spcEntity != null) {
                sysParameterConfigMapper.updateByPrimaryKey(spc);
            } else {
                sysParameterConfigMapper.insert(spc);
            }

//            parameterRedisDao.saveParameterConfig(spcList);
        }
    }

    public ResponseResult<SysParameterConfig> getParameterValue(String parameterCode) {
        SysParameterConfig config = sysParameterConfigMapper.selectByPrimaryKey(parameterCode);
        return new ResponseResult<SysParameterConfig>(EnumResultType.SUCCESS.toString(),
                ApplicationConstant.FIND_SUCCESS, config);
    }

}
