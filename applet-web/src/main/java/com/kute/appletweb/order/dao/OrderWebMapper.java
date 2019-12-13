package com.kute.appletweb.order.dao;

import com.kute.appletcore.entity.*;
import com.kute.appletcore.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderWebMapper {

    //根据大类获取面料信息
    List<SysFabric> selectFabricListByCategory(String goodsId);

    //根据大类获取尺码信息
    List<AppSize> selectSizeListByCategory(String category);

    //根据大类获取工艺节点信息
    List<AppTechnologyNodeVO> selectTechnologyTreeListByCategory(String category);

    //检查工艺冲突
    List<SysTechnologyConflict> checkTechnologyConflict( @Param("technologyCode") String technologyCode ,@Param("arrayList")  String[] arrayList);


    //根据大类获取工艺列表
    List<AppTechnologyAttribute> selectTechnologyListByCategory(@Param("category") String category);

    //根据大类获取刺绣位置
    List<AppStitchWorkVO> selectStitchWorkPositionByCategory(String category);

    //根据刺绣位置 获取刺绣图案
    List<AppStitchWork> selectStitchWorkByPositionId(Integer positionId);

    //插入订单头信息
    int insertOrderHead(OrderHeadVO oh);

    //插入订单行详情
    int insertOrderInfo(OrderInfoVO oi);

    //插入订单行信息
    int insertOrderLine(OrderLine ol);

    //添加订单工艺
    int insertOrderLineTechnology(@Param("technologyList") List<OrderTechnology> technologyList);

    //添加订单刺绣
    int insertOrderLineStitchWork(@Param("stitchWorkList") List<OrderStitchWork> stitchWorkList);


    //获取订单列表根据客户手机号
    List<OrderListVO> getOrderListByMemberTel(@Param("memberTel") String memberTel,@Param("orderState") String orderState) ;

    //添加订单刺绣
    int updateOrderPayState(@Param("packagecode") String packagecode,@Param("payMessage") String payMessage );

    //根据infoId 获取订单详情
    List<OrderDetails> selectOrderDetailByInfoId(@Param("infoId") Integer infoId) ;

    //根据LineId 获取订单工艺详情
    List<OrderTechnology> selectOrderTechnologyByLineId(@Param("lineId") Integer lineId) ;
    
    //根据lineId 获取订单刺绣详情
    List<OrderStitchWork> selectOrderStitchWorkByLineId(@Param("lineId") Integer lineId) ;
    //根据lineId 获取订单尺寸详情
    List<AppSizeSub> selectOrderSizeByLineId(@Param("sizeId") String sizeId,@Param("category") String category) ;

    void updateOrderPushState(@Param("pushFactoryState") String pushFactoryState,@Param("pushFactoryMessage") String pushFactoryMessage,@Param("deliveryDate") String deliveryDate,@Param("infoId") Integer infoId);


    AppGoods selectGoodsInfoByGoodsId(String goodsId);
}
