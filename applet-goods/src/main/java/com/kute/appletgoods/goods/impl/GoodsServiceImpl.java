package com.kute.appletgoods.goods.impl;


import com.kute.appletcore.dao.AppGoodsMapper;
import com.kute.appletcore.entity.AppGoods;
import com.kute.appletcore.entity.SysParameterDefine;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.GoodsMenu;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletgoods.goods.dao.GoodsMapper;
import com.kute.appletgoods.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public  class GoodsServiceImpl implements GoodsService {



    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    AppGoodsMapper appGoodsMapper;


    /**
     * 获取小程序商品列表 根据品类
     * @return
     */
    public ResponseResult selectAppGoodsListByCategory(String category) throws Exception{
        ResponseResult result =new ResponseResult();
        List<AppGoods> list = goodsMapper.selectAppGoodsListByCategory(category);
        result.setCode( EnumResultType.SUCCESS.toString());
        result.setData(list);
        return result;
    }



    /**
     * 获取商品主品类下拉选
     *
     * @throws Exception
     */
//    @Cacheable(cacheNames="appletAlways",key="methodName")
    public ResponseResult getMainSelectInfo() throws Exception{
        ResponseResult result =new ResponseResult();
        List<GoodsMenu> list=goodsMapper.getMainSelectInfo();
        result.setCode( EnumResultType.SUCCESS.toString());
        result.setData(list);
        return result;
    };

    /**
     *  获取首页APP显示品类及数量
     *
     */
//    @Cacheable(value="appletAlways",key="methodName")
    public ResponseResult getAppMainShowTypeAndNum(){
        ResponseResult result =new ResponseResult();
        List<SysParameterDefine> pdList=goodsMapper.getAppMainShowTypeAndNum();
        List<Map> list=new ArrayList<>();
        for(SysParameterDefine pd:pdList){
            Map<String,Object > map=new HashMap<>();
            map.put("main_style", pd.getParameterCode());
            map.put("quantity", Integer.valueOf(pd.getDescription()) );//条数
            List<AppGoods> goods=goodsMapper.selectAppMainShowGoods(map);
            if(goods.size()!=0){
                Map<String,Object> goodsMap=new HashMap();
                goodsMap.put("title",pd.getParameterName());
                goodsMap.put("list",goods);
                list.add(goodsMap);
            }

        }
        result.setCode( EnumResultType.SUCCESS.toString());
        result.setData(list);
        return result;
    };

    /**
     * 根据商品id获取商品详情
     *
     * @throws Exception
     */
    @Cacheable(value="appletAlways",key="methodName+'_'+#goods_id")
    public ResponseResult selectByPrimaryKey(String goods_id) throws Exception{
        ResponseResult result =new ResponseResult();
        AppGoods goods=appGoodsMapper.selectByPrimaryKey(goods_id);
        result.setCode( EnumResultType.SUCCESS.toString());
        result.setData(goods);
        return result;
    };
}
