package com.kute.appletgoods.measureOrder.impl;


import com.kute.appletcore.dao.AppMeasureOrderMapper;
import com.kute.appletcore.entity.AppMeasureOrder;
import com.kute.appletcore.util.submail.SubmailUtil;
import com.kute.appletgoods.measureOrder.service.MeasureOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MeasureOrderServiceImpl implements MeasureOrderService {



    @Autowired
    AppMeasureOrderMapper appMeasureOrderMapper;




    /**
     *  插入预约量体订单信息
     *
     * @throws Exception
     */
    public int insert(AppMeasureOrder amo) throws Exception {
       sendTextMessage(amo.getMemberName(),amo.getMemberTel());
        return appMeasureOrderMapper.insert(amo);
    }


    @Async
    public void sendTextMessage(String memberName,String memebrTel) throws Exception {
        String vars = "{\"name\":\"" + memberName + "\"}";
		String appId = "12858";
		String appKey = "5e1f6aa019d2dd869b5a8bb1c887f413";
		String templateId = "wpZqS4";
		String apiUrl = "https://api.mysubmail.com/message/xsend";
		SubmailUtil.sendSMS(memebrTel, vars, appId, appKey, templateId, apiUrl);
    }


    /**
     *  删除量体订单并填写撤单原因
     *
     * @throws Exception
     */
    public int delMeasureOrder(String measure_id,String order_cancle_dict_id,String order_cancle_extra_content) throws Exception {
       AppMeasureOrder amo=new AppMeasureOrder();
       amo.setMeasureId(measure_id);
       amo.setOrderCancleDictId(order_cancle_dict_id);
       amo.setOrderCancleExtraContent(order_cancle_extra_content);
       return appMeasureOrderMapper.updateByPrimaryKey(amo);
    }


}
