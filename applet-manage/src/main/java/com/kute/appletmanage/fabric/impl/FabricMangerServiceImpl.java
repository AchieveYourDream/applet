package com.kute.appletmanage.fabric.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.SysFabricMapper;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletmanage.fabric.dao.FabricMangerMapper;
import com.kute.appletmanage.fabric.service.FabricMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 面料管理
 * @Description: 面料管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FabricMangerServiceImpl implements FabricMangerService {

    @Autowired
    private FabricMangerMapper fabricMangerMapper;

    @Autowired
    private SysFabricMapper sysFabricMapper;


    /**
     * 获取面料列表
     */
    public PageInfo<SysFabric> getFabricList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<SysFabric> list = fabricMangerMapper.getFabricList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取面料信息
     *
     */
    public SysFabric getFabricInfoByFabricCode(String fabricCode) throws Exception {
        return fabricMangerMapper.getFabricInfoByFabricCode(fabricCode);
    }

    /**
     * 新增面料
     */
    
    public void addFabric(SysFabric sf) throws Exception {
        sysFabricMapper.insert(sf);
    }

    /**
     * 编辑面料
     */
    
    public void editFabric(SysFabric sf) throws Exception {
        sysFabricMapper.updateByPrimaryKey(sf);
    }

    /**
     * 修改面料状态
     *
     */
    
    public void updateFabricStatus(String fabricCode, String userState) throws Exception {
        fabricMangerMapper.updateFabricStatus(fabricCode,userState);
    }


    /**
     * 删除面料
     */
    
    public void removeFabric(String fabricCode) throws Exception {
        sysFabricMapper.deleteByPrimaryKey(fabricCode);    //删除面料

    }

}
