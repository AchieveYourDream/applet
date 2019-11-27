package com.kute.appletweb.order.dao;

import com.kute.appletcore.entity.*;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletcore.vo.OrderLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderWebMapper {

    //根据大类获取面料信息
    List<SysFabric> selectFabricListByCategory(String category);

    //根据大类获取尺码信息
    List<AppSize> selectSizeListByCategory(String category);
    //根据大类获取工艺节点信息
    List<AppTechnologyNode> selectTechnologyTreeListByCategory(String category);

    //根据大类获取工艺列表(排除冲突工艺)
    List<AppTechnologyAttribute> selectTechnologyListByCategory(@Param("technologyArray") String technologyArray, @Param("category") String category);

    //根据大类获取刺绣位置
    List<AppStitchWorkPosition> selectStitchWorkPositionByCategory(String category);
    //根据刺绣位置 获取刺绣图案
    List<AppStitchWork> selectStitchWorkByPositionId(Integer positionId);
    //插入订单头信息
   int  insertOrderHead(OrderHeadVO oh);
    //插入订单行信息
    int  insertOrderLine(OrderLine ol);
    //添加订单工艺
    int  insertOrderLineTechnology(@Param("technologyList") List<OrderTechnology> technologyList);
    //添加订单刺绣
    int  insertOrderLineStitchWork(@Param("stitchWorkList") List<OrderStitchWork> stitchWorkList);





}
