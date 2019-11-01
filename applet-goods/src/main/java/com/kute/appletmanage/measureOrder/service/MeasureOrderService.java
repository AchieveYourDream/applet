package com.kute.appletmanage.measureOrder.service;

import com.kute.appletcore.entity.AppMeasureOrder;

public interface MeasureOrderService {
    /**
     *  插入预约量体订单信息
     */
    int insert(AppMeasureOrder amo) throws Exception;

    void sendTextMessage(String memberName,String memebrTel) throws Exception;
    /**
     *  删除量体订单并填写撤单原因
     */
    int delMeasureOrder(String measure_id,String order_cancle_dict_id,String order_cancle_extra_content) throws Exception;
}
