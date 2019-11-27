package com.kute.appletweb.order.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.AppStitchWork;
import com.kute.appletcore.entity.AppStitchWorkPosition;
import com.kute.appletcore.entity.AppTechnologyAttribute;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletcore.vo.ResponseResult;

import java.util.List;
import java.util.Map;

public interface OrderWebService {

    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    PageInfo<SysFabric> selectFabricListByCategory(Integer pageNum, Integer pageSize, String category);

    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    List<Map<String, Object>> selectSizeListByCategory(String category);

    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    List<Map<String, Object>> selectTechnologyTreeListByCategory(String category);

    /**
     * @Description: 根据大类获取工艺列表(排除冲突工艺)
     * @Author: 王斌
     * @Date: 2019/11/19
     */
    List<AppTechnologyAttribute> selectTechnologyListByCategory(String technologyArray, String nodeCode);


    /**
     * @Description: 根据大类获取刺绣位置
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    PageInfo<AppStitchWorkPosition> selectStitchWorkPositionByCategory(Integer pageNum, Integer pageSize, String category);

    /**
     * @Description: 根据刺绣位置 获取刺绣图案
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    PageInfo<AppStitchWork> selectStitchWorkByPositionId(Integer pageNum, Integer pageSize, Integer positionId);

    /**
     * @Description: 插入订单
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    ResponseResult insertOrder(OrderHeadVO oh);

}