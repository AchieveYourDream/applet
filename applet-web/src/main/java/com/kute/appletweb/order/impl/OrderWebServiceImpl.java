package com.kute.appletweb.order.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.*;
import com.kute.appletcore.util.redis.RedisUtil;
import com.kute.appletcore.vo.OrderHeadVO;
import com.kute.appletcore.vo.OrderLine;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletweb.order.dao.OrderWebMapper;
import com.kute.appletweb.order.service.OrderWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderWebServiceImpl implements OrderWebService {

    private final Logger logger = LoggerFactory.getLogger(OrderWebService.class);


    @Autowired
    RedisUtil redisUtil;
    @Autowired
    OrderWebMapper orderWebMapper;


    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    public PageInfo<SysFabric> selectFabricListByCategory(Integer pageNum, Integer pageSize, String category) {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<SysFabric> list = orderWebMapper.selectFabricListByCategory(category);
        return new PageInfo<>(list);
    }


    /**
     * 根据大类获取尺寸信息
     *
     * @return
     */
    public List<Map<String, Object>> selectSizeListByCategory(String category) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (category.equals("T")) {
            Map xf = new HashMap();
            xf.put("title", "上衣");
            xf.put("data", orderWebMapper.selectSizeListByCategory("MXF"));
            list.add(xf);
            Map xk = new HashMap();
            xk.put("title", "西裤");
            xk.put("data", orderWebMapper.selectSizeListByCategory("MXK"));
            list.add(xk);

        } else {
            Map cat = new HashMap();
            List<AppSize> asList = orderWebMapper.selectSizeListByCategory(category);
            if (asList != null && asList.size() != 0) {
                cat.put("title", asList.get(0).getCategoryName());
                cat.put("data", asList);
            } else {
                cat.put("title", "");
                cat.put("data", "");
            }
            list.add(cat);
        }
        return list;
    }


    /**
     * 根据大类获取工艺节点信息
     *
     * @return
     */
    public List<Map<String, Object>> selectTechnologyTreeListByCategory(String category) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (category.equals("T")) {
            Map xf = new HashMap();
            xf.put("title", "上衣");
            xf.put("data", orderWebMapper.selectTechnologyTreeListByCategory("MXF"));
            list.add(xf);
            Map xk = new HashMap();
            xk.put("title", "西裤");
            xk.put("data", orderWebMapper.selectTechnologyTreeListByCategory("MXK"));
            list.add(xk);

        } else {
            Map cat = new HashMap();
            List<AppTechnologyNode> asList = orderWebMapper.selectTechnologyTreeListByCategory(category);
            if (asList != null && asList.size() != 0) {
                cat.put("data", asList);
            } else {
                cat.put("title", "");
                cat.put("data", "");
            }
            list.add(cat);
        }
        return list;
    }

    /**
     * 根据大类获取工艺节点信息
     *
     * @return
     */
    public List<AppTechnologyAttribute> selectTechnologyListByCategory(String technologyArray, String nodeCode) {

        return orderWebMapper.selectTechnologyListByCategory(technologyArray, nodeCode);
    }


    //根据大类获取刺绣位置
   public  PageInfo<AppStitchWorkPosition> selectStitchWorkPositionByCategory(Integer pageNum, Integer pageSize, String category){
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppStitchWorkPosition> list = orderWebMapper.selectStitchWorkPositionByCategory(category);
        return new PageInfo<>(list);
    }

    //根据刺绣位置 获取刺绣图案
    public  PageInfo<AppStitchWork> selectStitchWorkByPositionId(Integer pageNum, Integer pageSize, Integer positionId){
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppStitchWork> list =orderWebMapper.selectStitchWorkByPositionId(positionId);
        return new PageInfo<>(list);
    }
    
    
    /** 
    * @Description: 插入订单
    * @Author: 王斌
    * @Date: 2019/11/23 
    */
    public ResponseResult insertOrder(OrderHeadVO oh){
        //判断订单行信息是否为空
        if(oh.getLinelist()==null || oh.getLinelist().size()==0){
            return  new  ResponseResult("W","订单行信息不能为空");
        }

        for( OrderLine line:oh.getLinelist()){
            if(line.getTechnologyList()==null || line.getTechnologyList().size()==0){
                return  new  ResponseResult("W","订单行工艺不能为空");
            }
            //插入订单行信息
            orderWebMapper.insertOrderLine(line);
            //循环工艺列表将订单行id塞入实体对象
            for(OrderTechnology ot:line.getTechnologyList()){
                ot.setOrderDetailId(line.getLineId());
            }
            //插入订单工艺
            orderWebMapper.insertOrderLineTechnology(line.getTechnologyList());

            //循环刺绣列表将订单行id塞入实体对象
            for(OrderStitchWork osw:line.getStitchWorkList()){
                osw.setOrderDetailId(line.getLineId());
            }
            //插入订单刺绣
            orderWebMapper.insertOrderLineStitchWork(line.getStitchWorkList());

        }
        //插入订单头信息
        orderWebMapper.insertOrderHead(oh);
        return  new  ResponseResult("S","保存成功");

    }


}
