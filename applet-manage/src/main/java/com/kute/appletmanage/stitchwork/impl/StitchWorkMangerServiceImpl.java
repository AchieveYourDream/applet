package com.kute.appletmanage.stitchwork.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppStitchWorkMapper;
import com.kute.appletcore.dao.AppStitchWorkPositionMapper;
import com.kute.appletcore.dao.AppStitchWorkRelationMapper;
import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;
import com.kute.appletcore.vo.AppStitchWorkPositionVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.stitchwork.dao.StitchWorkMangerMapper;
import com.kute.appletmanage.stitchwork.service.StitchWorkMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 刺绣位置管理
 * @Description: 刺绣位置管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StitchWorkMangerServiceImpl implements StitchWorkMangerService {

    @Autowired
    private StitchWorkMangerMapper stitchWorkMangerMapper;

    @Autowired
    private AppStitchWorkPositionMapper appStitchWorkPositionMapper;
    @Autowired
    private AppStitchWorkMapper appStitchWorkMapper;
    @Autowired
    private AppStitchWorkRelationMapper appStitchWorkRelationMapper;


    /**
     * 获取刺绣位置列表
     */
    public PageInfo<AppStitchWorkPosition> getStitchWorkPositionList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppStitchWorkPosition> list = stitchWorkMangerMapper.getStitchWorkPositionList(search);
        return new PageInfo<>(list);
    }



    /**
     * 根据工厂编码获取是否已经添加
     *
     */
    public AppStitchWorkPosition getStitchWorkPositionInfoByFactoryCode(String factoryCode) throws Exception {
        return stitchWorkMangerMapper.getStitchWorkPositionInfoByFactoryCode(factoryCode);
    }


    /**
     * 获取刺绣位置信息
     *
     */
    public AppStitchWorkPosition getStitchWorkPositionInfoById(Integer id) throws Exception {
      return   appStitchWorkPositionMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增刺绣位置
     */
    
    public void addStitchWorkPosition(AppStitchWorkPosition asp) throws Exception {
        appStitchWorkPositionMapper.insert(asp);
    }

    /**
     * 编辑刺绣位置
     */
    
    public void editStitchWorkPosition(AppStitchWorkPosition asp) throws Exception {
        appStitchWorkPositionMapper.updateByPrimaryKey(asp);
    }


    /**
     * 删除刺绣位置
     */
    
    public void removeStitchWorkPosition(Integer id) throws Exception {
        appStitchWorkPositionMapper.deleteByPrimaryKey(id);    //删除刺绣位置

    }




    /**
     * 获取刺绣列表
     */
    public PageInfo<AppStitchWork> getStitchWorkList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppStitchWork> list = stitchWorkMangerMapper.getStitchWorkList(search);
        return new PageInfo<>(list);
    }

    /**
     * 检查刺绣工厂编码是否存在
     *
     */
    public AppStitchWork getStitchWorkInfoByFactoryCode(String fabricCode) throws Exception {
        return stitchWorkMangerMapper.getStitchWorkInfoByStitchWorkCode(fabricCode);
    }
    /**
     * 获取刺绣信息
     *
     */
    public AppStitchWork getStitchWorkInfoById(Integer id )throws Exception {
        return appStitchWorkMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增刺绣
     */

    public void addStitchWork(AppStitchWork sf) throws Exception {
        appStitchWorkMapper.insert(sf);
    }

    /**
     * 编辑刺绣
     */

    public void editStitchWork(AppStitchWork sf) throws Exception {
        appStitchWorkMapper.updateByPrimaryKey(sf);
    }

    /**
     * 删除刺绣
     */

    public void removeStitchWork(Integer id) throws Exception {
        appStitchWorkMapper.deleteByPrimaryKey(id);    //删除刺绣

    }


    /**
     * 获取刺绣列表
     */
    public List<AppStitchWorkPositionVO> getStitchWorkRelationList(Integer stitchWorkId) throws Exception{

        return  stitchWorkMangerMapper.getStitchWorkRelationList(stitchWorkId);
    }




    /**
     * @Description: 修改刺绣与位置关系
     * @Author: 王斌
     * @Date: 2019/11/21
     */

    public ResponseResult updateStitchWorkPositionRelation(Integer stitchWorkId, String  positionArray){
        appStitchWorkRelationMapper.deleteByPrimaryKey(stitchWorkId);
        stitchWorkMangerMapper.insertStitchWorkPositionRelation(stitchWorkId,positionArray);
        return  new  ResponseResult("S","保存成功");

    }



}
