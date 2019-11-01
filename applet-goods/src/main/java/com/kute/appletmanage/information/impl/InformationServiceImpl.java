package com.kute.appletmanage.information.impl;


import com.kute.appletcore.enumeration.EnumResultType;
import com.kute.appletcore.vo.InformationVO;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.information.dao.InformationMapper;
import com.kute.appletmanage.information.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class InformationServiceImpl  implements InformationService {



    @Autowired
    InformationMapper informationMapper;

    /**
     * 获取资讯信息品类格局列表
     */
   @Cacheable(cacheNames="appletAlways",key="methodName")
    public ResponseResult selectAppInformationList( ) throws Exception{
       ResponseResult result=new  ResponseResult();
        List<InformationVO> list = informationMapper.selectAppInformationList();
            for(InformationVO vo:list) {
                vo.setList(informationMapper.selectAllByUseModule(vo.getNodeCode()));
            }
       result.setCode(EnumResultType.SUCCESS.toString());
       result.setData(list);
         return result;
    }

    /**
     * 获取banner轮播图信息
     */
    @Cacheable(cacheNames="appletAlways",key="methodName")
    public ResponseResult selectByBanner( ) throws Exception {
        ResponseResult result=new  ResponseResult();
        result.setCode(EnumResultType.SUCCESS.toString());
        result.setData(informationMapper.selectByBanner());
        return result;
    }
    /**
     *  修改资讯管理照片
     *
     * @throws Exception
     */
    public int updateInformationImage(String information_id,String show_pic) throws Exception {
        Map<String,String > map=new HashMap<String,String>();
        map.put("information_id", information_id);
        map.put("show_pic", show_pic);
        return informationMapper.updateInformationImage(map);
    }

    /**
     * @Description: 获取往期
     * @Author: 王斌
     */
    public List<HashMap<String,Object>> getHistoryInfo(String node_code){
       return  informationMapper.getHistoryInfo(node_code);
    }
}
