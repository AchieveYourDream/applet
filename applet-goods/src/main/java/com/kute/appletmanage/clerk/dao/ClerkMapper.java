package com.kute.appletmanage.clerk.dao;

import com.kute.appletcore.entity.AppClerk;

import java.util.List;
import java.util.Map;

public interface ClerkMapper {
    /**
     * 获取小程序量体师列表
     * @param appid
     * @return
     */
    List<AppClerk> selectAppClerkList();

    /**
     * 获取小程序量体师列表数量
     */
    int  selectAppClerkListNum();


    /**
     *  修改量体师头像
     *
     * @throws Exception
     */
    public int updateClerkImage(Map map);


}
