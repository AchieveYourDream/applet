package com.kute.appletmanage.imformation.dao;


import com.kute.appletcore.entity.AppInformation;
import com.kute.appletcore.entity.SysDataStructNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface InformationManageMapper  {

    	/**
	 *  获取小程序资讯管理菜单信息
	 * 
	 * @throws Exception
	 */
	 List<SysDataStructNode> getAppInformationMenuInfo() throws Exception ;
	/**
	 *  获取小程序资讯管理列表 -
	 * 
	 * @throws Exception
	 */
	 List<AppInformation> selectAppInformationList(String useModule);
	

        /**
         * 撤回or上线 资讯管理
         * 
         * @throws Exception
         */
     int updateInformationVisible(@Param("isvisible") String isvisible,@Param("informationId") String informationId);
    
//    /**
//     *  修改资讯管理照片
//     * 
//     * @throws Exception
//     */
//     int updateInformationImage(String information_id,String show_pic) throws Exception {
//	Map<String,String > map=new HashMap<String,String>();
//	map.put("information_id", information_id);
//	map.put("show_pic", show_pic);
//        return update(NAMESPACE + "." + "updateInformationImage", map);
//    }


    
}