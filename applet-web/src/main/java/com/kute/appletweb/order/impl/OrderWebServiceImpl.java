package com.kute.appletweb.order.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.entity.*;
import com.kute.appletcore.util.JsonUtil;
import com.kute.appletcore.util.http.HttpClientConstant;
import com.kute.appletcore.util.http.HttpClientRequest;
import com.kute.appletcore.util.http.HttpClientResponse;
import com.kute.appletcore.util.http.HttpClientUtil;
import com.kute.appletcore.util.redis.RedisUtil;
import com.kute.appletcore.vo.*;
import com.kute.appletweb.number.service.NumberService;
import com.kute.appletweb.order.dao.OrderWebMapper;
import com.kute.appletweb.order.service.OrderWebService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    NumberService numberService;

    //小程序appid
    @Value("${wx.appid}")
    private String wxAppId;
    //小程序secret
    @Value("${wx.secret}")
    private String wxSecret;
    //订单推送工厂url
    @Value("${bl.pushFactory}")
    private String pushFactory;


    /**
     * 根据大类获取面料信息
     *
     * @return
     */
    public List<SysFabric> selectFabricListByCategory(String goodsId) {
        return orderWebMapper.selectFabricListByCategory(goodsId);
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
            List<AppTechnologyNodeVO> xfNodeList = orderWebMapper.selectTechnologyTreeListByCategory("MXF");
            for (AppTechnologyNodeVO vo : xfNodeList) {
                vo.setList(orderWebMapper.selectTechnologyListByCategory(vo.getNodeCode()));
            }
            xf.put("data", xfNodeList);
            list.add(xf);
            Map xk = new HashMap();
            xk.put("title", "西裤");
            List<AppTechnologyNodeVO> xkNodeList = orderWebMapper.selectTechnologyTreeListByCategory("MXK");
            for (AppTechnologyNodeVO vo : xkNodeList) {
                vo.setList(orderWebMapper.selectTechnologyListByCategory(vo.getNodeCode()));
            }
            xk.put("data", xkNodeList);
            list.add(xk);

        } else {
            Map cat = new HashMap();
            List<AppTechnologyNodeVO> nodeList = orderWebMapper.selectTechnologyTreeListByCategory(category);
            for (AppTechnologyNodeVO vo : nodeList) {
                vo.setList(orderWebMapper.selectTechnologyListByCategory(vo.getNodeCode()));
            }
            if (nodeList != null && nodeList.size() != 0) {
                cat.put("data", nodeList);
            } else {
                cat.put("title", "");
                cat.put("data", "");
            }
            list.add(cat);
        }
        return list;
    }

    /**
     * @Description: 检查工艺冲突
     * @Author: 王斌
     * @Date: 2019/12/12
     */
    public ResponseResult checkTechnologyConflict(String technologyCode, String technologyList) throws Exception {

        String[] array = technologyList.split(",");
        List<SysTechnologyConflict> list = orderWebMapper.checkTechnologyConflict(technologyCode, array);
        if (list == null || list.size() == 0) {
            return new ResponseResult("S", "没有冲突");
        } else {
            StringBuffer s = new StringBuffer("与工艺:");
            for (SysTechnologyConflict sc : list) {
                s.append(sc.getbTechnologyName() + ",");
            }
            s.append("冲突");
            return new ResponseResult("E", s.toString());
        }
    }
//    /**
//     * 根据大类获取工艺节点信息
//     *
//     * @return
//     */
//    public List<AppTechnologyAttribute> selectTechnologyListByCategory(String technologyArray, String nodeCode) {
//
//        return orderWebMapper.selectTechnologyListByCategory(technologyArray, nodeCode);
//    }


    //根据大类获取刺绣位置
    public List<Map<String, Object>> selectStitchWorkPositionByCategory(String category) {

        List<Map<String, Object>> list = new ArrayList<>();
        if (category.equals("T")) {
            Map xf = new HashMap();
            xf.put("title", "上衣");
            List<AppStitchWorkVO> xflist = orderWebMapper.selectStitchWorkPositionByCategory("MXF");
            for (AppStitchWorkVO vo : xflist) {
                vo.setList(orderWebMapper.selectStitchWorkByPositionId(vo.getId()));
            }
            xf.put("data", xflist);
            list.add(xf);
            Map xk = new HashMap();
            xk.put("title", "西裤");
            List<AppStitchWorkVO> xklist = orderWebMapper.selectStitchWorkPositionByCategory("MXK");
            for (AppStitchWorkVO vo : xklist) {
                vo.setList(orderWebMapper.selectStitchWorkByPositionId(vo.getId()));
            }
            xk.put("data", xklist);
            list.add(xk);

        } else {
            Map cat = new HashMap();
            List<AppStitchWorkVO> swlist = orderWebMapper.selectStitchWorkPositionByCategory(category);
            for (AppStitchWorkVO vo : swlist) {
                vo.setList(orderWebMapper.selectStitchWorkByPositionId(vo.getId()));
            }
            if (swlist != null && swlist.size() != 0) {
                cat.put("data", swlist);
            } else {
                cat.put("title", "");
                cat.put("data", "");
            }
            list.add(cat);
        }
        return list;


    }

//    //根据刺绣位置 获取刺绣图案
//    public PageInfo<AppStitchWork> selectStitchWorkByPositionId(Integer pageNum, Integer pageSize, Integer positionId) {
//        PageHelper.startPage(pageNum, pageSize, true, false);
//        List<AppStitchWork> list = orderWebMapper.selectStitchWorkByPositionId(positionId);
//        return new PageInfo<>(list);
//    }


    /**
     * @Description: 插入订单
     * @Author: 王斌
     * @Date: 2019/11/23
     */
    public ResponseResult insertOrder(OrderHeadVO oh) throws Exception {
        //判断订单行信息是否为空
        String zd_number = numberService.getNumber("ZD", "yyMMdd", 4);
        oh.setPackagecode(zd_number);
        if (oh.getInfolist() == null || oh.getInfolist().size() == 0) {
            return new ResponseResult("W", "订单行信息不能为空");
        }

        for (OrderInfoVO info : oh.getInfolist()) {
            String syscode = numberService.getNumber("AP", "yyMMdd", 4);
            String orderId = numberService.getNumber("APDD", "yyMM", 4);

            info.setPackagecode(zd_number);
            info.setOrderId(orderId);
            info.setSyscode(syscode);

            AppGoods goods = orderWebMapper.selectGoodsInfoByGoodsId(info.getClothId());
            if (goods == null) {

                return new ResponseResult("W", "未查询到商品信息");
            } else {
                info.setLiningType(goods.getLiningType());
                info.setClothName(goods.getGoodsNameEn());
            }


            if (info.getLinelist() == null || info.getLinelist().size() == 0) {
                return new ResponseResult("W", "订单明细信息不能为空");
            }
            //插入订单Info
            orderWebMapper.insertOrderInfo(info);

            //插入订单行
            for (OrderLine line : info.getLinelist()) {
                line.setInfoId(info.getInfoId());
                //塞入子品类零售价格
                if (line.getClothId().equals("MXF") && info.getClothCategory().equals("T")) {
                    line.setPrice(goods.getXfPrice());
                } else if (line.getClothId().equals("MXK") && info.getClothCategory().equals("T")) {
                    line.setPrice(goods.getXkPrice());
                } else {
                    line.setPrice(goods.getGoodsSellPrice());
                }

                if (line.getTechnologyCode() == null || line.getTechnologyCode().equals("")) {
                    return new ResponseResult("W", "订单行工艺不能为空");
                }
                //插入订单行信息
                orderWebMapper.insertOrderLine(line);
//                //循环工艺列表将订单行id塞入实体对象
//                for (OrderTechnology ot : line.getTechnologyList()) {
//                    ot.setOrderDetailId(line.getLineId());
//                }
//                //插入订单工艺
//                orderWebMapper.insertOrderLineTechnology(line.getTechnologyList());

                //循环刺绣列表将订单行id塞入实体对象
                for (OrderStitchWork osw : line.getStitchWorkList()) {
                    osw.setOrderDetailId(line.getLineId());
                }
                //插入订单刺绣
                orderWebMapper.insertOrderLineStitchWork(line.getStitchWorkList());

            }
        }
        //插入订单头信息
        orderWebMapper.insertOrderHead(oh);


        return new ResponseResult("S", "保存成功");

    }


    /**
     * 获取订单列表根据客户手机号
     */
    public PageInfo<OrderListVO> getOrderListByMemberTel(Integer pageNum, Integer pageOrder, String memberTel, String orderState) throws Exception {
        PageHelper.startPage(pageNum, pageOrder, true, false);
        List<OrderListVO> list = orderWebMapper.getOrderListByMemberTel(memberTel, orderState);
        return new PageInfo<>(list);
    }


    /**
     * @Description: 订单推送工厂
     * @Author: 王斌
     * @Date: 2019/12/13
     */

    public void OrderPushFactory(PushFactoryInfoVO vo) {
        Map map = new HashMap();
        try {
            OrdersBean ob = new OrdersBean();
            ob.setOrderDate(vo.getCreate_date());//创建时间
            ob.setCustomerOrdersNo(vo.getOrderId());//客户订单号
            ob.setContractSerialNumber(vo.getSyscode());//系统订单号
            ob.setCreateman("Applet"); //创建人
            ob.setOperatorName("Applet01");//量体师
            ob.setCustomerName(vo.getMember_name());//客户名称
            ob.setOwnedStore("Applet");//创建门店
            ob.setHeight("170");//身高
            //性别
            if (vo.getClothId().equals("WXF")) {
                ob.setGender("0");
            } else {
                ob.setGender("1");
            }

            ob.setFabrics(vo.getFabricCode());//面料
            ob.setProduct(vo.getClothName());  //商品名称
            ob.setMoney(vo.getActualAmount().toString());//价格

            List<OrderDetails> detailsList = orderWebMapper.selectOrderDetailByInfoId(vo.getInfoId());
            List<OrdersDetailBean> ordersDetailBeans = new ArrayList<>();
            for (OrderDetails od : detailsList) {
                OrdersDetailBean odb = new OrdersDetailBean();
                odb.setModel("0");
                odb.setCategories(od.getClothId());
                odb.setInterliningType(od.getLiningType());
                odb.setQuantity(od.getAmount().toString());
                odb.setVersionStyle("H");
                odb.setClothingStyle("H");
                odb.setPrice(od.getActualAmount().toString());
//                //查询订单工艺
//                StringBuffer tech=new StringBuffer();
//                List<OrderTechnology> otList=orderWebMapper.selectOrderTechnologyByLineId(od.getLineId());
//                for(OrderTechnology ot:otList){
//                    if(ot.getTechnologyType().equals("A")){
//                        tech.append(ot.getFactoryCode()+",");
//                    }else{
//                        tech.append(ot.getFactoryCode()+":"+ot.getContent()+",");
//                    }
//                }
                odb.setOrdersProcess(od.getTechnologyCode());

                //查询订单刺绣
                StringBuffer sw = new StringBuffer();
                List<OrderStitchWork> swList = orderWebMapper.selectOrderStitchWorkByLineId(od.getLineId());
                for (OrderStitchWork osw : swList) {
                    sw.append(osw.getPositionId() + "," + osw.getColorId() + "," + osw.getFontId() + "," + osw.getSizeId() + "," + osw.getContent() + ",");
                }
                if (sw.length() > 0) {
                    odb.setEmbroidery(sw.substring(0, sw.length() - 1));
                }

                //查询订单尺码信息
                StringBuffer size = new StringBuffer();
                List<AppSizeSub> sizeList = orderWebMapper.selectOrderSizeByLineId(od.getSize(), od.getClothId());
                if (sizeList == null || sizeList.size() == 0) {
                    throw new Exception(od.getClothId() + "未找到尺寸信息");
                }
                for (AppSizeSub ass : sizeList) {
                    size.append(ass.getBlecode() + ":" + ass.getDefaultvalue() + ",");
                }
                odb.setClothingSize(size.substring(0, size.length() - 1));

                ordersDetailBeans.add(odb);
            }
            ob.setDetails(ordersDetailBeans);

            HttpClientUtil httpClientUtil = new HttpClientUtil();
            HttpClientRequest requestPost = new HttpClientRequest();
            requestPost.setRequestUrl(pushFactory);
            requestPost.setRequestMehtod(HttpClientConstant.REQUEST_METHOD_POST);
            requestPost.setRequestHeaders(null);
            requestPost.setRequestBody(JsonUtil.getJSONFromObject(ob));
            requestPost.setRequestParams(null);
            requestPost.setContentType(HttpClientConstant.CONTENT_TYPE_JSON);

            HttpClientResponse responePost = httpClientUtil.sendHttpRequest(requestPost);
            if (responePost.getResponseCode().equals("Y")) {
                JSONObject jsonObject = JSONObject.fromObject(responePost.getResponseData());
                String state = jsonObject.getString("s");
                if (state.equals("0")) {

                    orderWebMapper.updateOrderPushState("S", "推送成功", jsonObject.getJSONArray("rs").getJSONObject(0).getString("msg"), vo.getInfoId());
                } else {
                    orderWebMapper.updateOrderPushState("E", jsonObject.getString("rs"), "", vo.getInfoId());
                }
            } else {
                orderWebMapper.updateOrderPushState("E", "调用BL推送接口报错", "", vo.getInfoId());
            }

        } catch (Exception e) {
            orderWebMapper.updateOrderPushState("E", e.getMessage(), "", vo.getInfoId());
        }
    }

//    public static void main(String[] args) {
//        String s="{\"s\":1,\"rs\":[{\"msg\":\"2019-12-06\",\"cwdm\":\"\",\"cwz\":\"\"}],\"ok\":true}";
//
//        JSONObject jsonObject=JSONObject.fromObject(s);
//        String w=;
//
//        System.out.println(w);
//    }

}
