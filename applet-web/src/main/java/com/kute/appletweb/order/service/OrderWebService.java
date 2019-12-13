package com.kute.appletweb.order.service;

import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.SysFabric;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletcore.vo.OrderListVO;
import com.kute.appletcore.vo.ResponseResult;

import java.util.List;
import java.util.Map;

public interface OrderWebService {

    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    List<SysFabric> selectFabricListByCategory( String goodsId);

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


    ResponseResult checkTechnologyConflict( String technologyCode , String technologyList) throws Exception;

//    /**
//     * @Description: 根据大类获取工艺列表(排除冲突工艺)
//     * @Author: 王斌
//     * @Date: 2019/11/19
//     */
//    List<AppTechnologyAttribute> selectTechnologyListByCategory(String technologyArray, String nodeCode);


    /**
     * @Description: 根据大类获取刺绣位置
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    List<Map<String, Object>> selectStitchWorkPositionByCategory( String category);

//    /**
//     * @Description: 根据刺绣位置 获取刺绣图案
//     * @Author: 王斌
//     * @Date: 2019/11/23
//     */
//    PageInfo<AppStitchWork> selectStitchWorkByPositionId(Integer pageNum, Integer pageSize, Integer positionId);

    /**
     * @Description: 插入订单
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    ResponseResult insertOrder(OrderHeadVO oh) throws Exception;


    /**
     * 获取订单列表根据客户手机号
     */
    PageInfo<OrderListVO> getOrderListByMemberTel(Integer pageNum, Integer pageOrder, String memberTel, String orderState) throws Exception;



}