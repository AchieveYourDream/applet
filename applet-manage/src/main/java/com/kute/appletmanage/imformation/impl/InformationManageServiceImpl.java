package com.kute.appletmanage.imformation.impl;

import com.kute.appletcore.dao.AppInformationMapper;
import com.kute.appletcore.entity.AppInformation;
import com.kute.appletcore.entity.SysDataStructNode;
import com.kute.appletmanage.imformation.dao.InformationManageMapper;
import com.kute.appletmanage.imformation.service.InformationManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@SuppressWarnings("all")
public class InformationManageServiceImpl implements InformationManageService {

    @Resource
    private AppInformationMapper appinformationMapper;
    @Resource
    private InformationManageMapper informationManageMapper;


    /**
     *  获取小程序资讯管理菜单信息
     *
     * @throws Exception
     */
    public List<SysDataStructNode> getAppInformationMenuInfo() throws Exception {
        return informationManageMapper.getAppInformationMenuInfo();
    }

    /**
     *  获取小程序资讯管理列表 -
     *
     * @throws Exception
     */
    public List<AppInformation> selectAppInformationList(String useModule) {
        return informationManageMapper.selectAppInformationList(useModule);

    }
    /**
     * 新增小程序资讯管理
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public int insertAppInformation(AppInformation obj) {
        return appinformationMapper.insert(obj);
    }

    /**
     * 修改小程序资讯管理
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public int updateAppInformation(AppInformation obj) {
        return appinformationMapper.updateByPrimaryKey(obj);
    }

    /**
     * 撤回or上线 资讯管理
     *
     * @throws Exception
     */
    public int updateInformationVisible(String isvisible,String informationId) {
        return informationManageMapper.updateInformationVisible(isvisible, informationId);
    }

    /**
     * 根据资讯管理证号门店查询资讯管理信息
     */
    public AppInformation selectAppInformationByPk(Integer informationId) {
        return appinformationMapper.selectByPrimaryKey(informationId);
    }

//    /**
//     *  修改资讯管理照片
//     *
//     * @throws Exception
//     */
//    public int updateInformationImage(String informationId,String show_pic) {
// return informationManageMapper.updateInformationImage(informationId, show_pic);
//    }

}

