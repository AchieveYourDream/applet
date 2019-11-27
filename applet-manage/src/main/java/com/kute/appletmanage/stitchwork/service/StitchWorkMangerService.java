package com.kute.appletmanage.stitchwork.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;
import com.kute.appletcore.vo.AppStitchWorkPositionVO;
import com.kute.appletcore.vo.ResponseResult;

import java.util.List;

public interface StitchWorkMangerService {
    /**
     * 获取刺绣位置列表
     */
    PageInfo<AppStitchWorkPosition> getStitchWorkPositionList(Integer pageNum, Integer pageSize, String search) throws Exception;

    /**
     * 获取根据id获取详细信息
     */
    AppStitchWorkPosition getStitchWorkPositionInfoById(Integer id) throws Exception;

    /**
     * 获取刺绣位置信息
     */
    AppStitchWorkPosition getStitchWorkPositionInfoByFactoryCode(String factoryCode) throws Exception;
    /**
     * 新增刺绣位置
     */
    void addStitchWorkPosition(AppStitchWorkPosition asp) throws Exception;
    /**
     * 编辑刺绣位置
     */
    void editStitchWorkPosition(AppStitchWorkPosition asp) throws Exception;

    /**
     * 删除刺绣位置
     */
    void removeStitchWorkPosition(Integer stitchWorkCode) throws Exception;





    /**
     * 获取刺绣列表
     */
    PageInfo<AppStitchWork> getStitchWorkList(Integer pageNum, Integer pageSize, String search) throws Exception;
    /**
     * 检查刺绣工厂编码是否存在
     */
    AppStitchWork getStitchWorkInfoByFactoryCode(String fabricCode) throws Exception;

    /**
     * 获取刺绣信息
     *
     */
     AppStitchWork getStitchWorkInfoById(Integer id )throws Exception;

    /**
     * 新增刺绣
     */
    void addStitchWork(AppStitchWork as) throws Exception;
    /**
     * 编辑刺绣
     */
    void editStitchWork(AppStitchWork as) throws Exception;

    /**
     * 删除刺绣
     */
    void removeStitchWork(Integer id) throws Exception;

    /**
     * 获取刺绣列表
     */
     List<AppStitchWorkPositionVO> getStitchWorkRelationList(Integer stitchWorkId) throws Exception;

    /**
     * @Description: 修改刺绣与位置关系
     * @Author: 王斌
     * @Date: 2019/11/21
     */

    ResponseResult updateStitchWorkPositionRelation(Integer stitchWorkId, String  positionArray);



}
