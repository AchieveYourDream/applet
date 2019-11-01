package com.kute.appletmanage.clerk.service;

import com.kute.appletcore.vo.ResponseResult;

public interface ClerkService {
    /**
     * 获取量体师数据
     * @return
     */
    ResponseResult selectAppClerkList() throws Exception;
    /**
     *  修改量体师头像
     *
     * @throws Exception
     */
    int updateClerkImage(String store_code,String clerk_id,String clerk_image) throws Exception;
}
