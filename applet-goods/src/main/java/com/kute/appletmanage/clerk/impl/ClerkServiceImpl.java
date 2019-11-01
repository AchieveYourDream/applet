package com.kute.appletmanage.clerk.impl;


import com.kute.appletcore.entity.AppClerk;
import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.clerk.dao.ClerkMapper;
import com.kute.appletmanage.clerk.service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClerkServiceImpl implements ClerkService {



    @Autowired
    ClerkMapper clerkMapper;


    /**
     * 获取量体师数据
     * @return
     */
    //Integer currentPage,Integer pageSize
    @Cacheable(cacheNames="appletAlways",key="methodName")
    public ResponseResult selectAppClerkList() throws Exception{
        ResponseResult result =new ResponseResult();
        //PageHelper.startPage(currentPage, pageSize,true,false);
        List<AppClerk> allItems = clerkMapper.selectAppClerkList();
        //int countNums =clerkMapper.selectAppClerkListNum();
        //int size=  (int)Math.ceil(Double.valueOf(countNums)/pageSize);
        //PageBean<AppClerk> pageData = new PageBean<>(currentPage, pageSize, countNums);
        //pageData.setItems(allItems);
        result.setCode( EnumResultType.SUCCESS.toString());
        result.setData(allItems);
        return result;
    }


    /**
     *  修改量体师头像
     *
     * @throws Exception
     */
    public int updateClerkImage(String store_code,String clerk_id,String clerk_image) throws Exception {
        Map<String,String > map=new HashMap<String,String>();
        map.put("store_code", store_code);
        map.put("clerk_id", clerk_id);
        map.put("clerk_image", clerk_image);
        return clerkMapper.updateClerkImage(map);
    }


}
