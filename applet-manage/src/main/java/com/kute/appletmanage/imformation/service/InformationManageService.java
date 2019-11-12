package com.kute.appletmanage.imformation.service;

import com.kute.appletcore.entity.AppInformation;
import com.kute.appletcore.entity.SysDataStructNode;

import java.util.List;

public interface InformationManageService {


	/**
	 *  获取小程序资讯管理菜单信息
	 * 
	 * @throws Exception
	 */
	public List<SysDataStructNode> getAppInformationMenuInfo() throws Exception;
	
	/**
	 *  获取小程序资讯管理列表 -
	 * 
	 * @throws Exception
	 */
	public List<AppInformation> selectAppInformationList(String useModule);
        /**
         * 新增小程序资讯管理
         * 
         * @param obj
         * @return
         * @throws Exception
         */
        public int insertAppInformation(AppInformation obj);

    /**
     * 修改小程序资讯管理
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public int updateAppInformation(AppInformation obj);

    /**
     * 撤回or上线 资讯管理
     * 
     * @throws Exception
     */
    public int updateInformationVisible(String isvisible,String informationId) ;
    
    /**
     * 根据资讯管理证号门店查询资讯管理信息
     */
    public AppInformation selectAppInformationByPk(Integer informationId) ;
    
//    /**
//     *  修改资讯管理照片
//     * 
//     * @throws Exception
//     */
//    public int updateInformationImage(String informationId,String show_pic) throws Exception {
//	return informationMapper.updateInformationImage(informationId, show_pic);
//    }

}
