package com.kute.appletmanage.size.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppSizeMapper;
import com.kute.appletcore.entity.AppSize;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.size.dao.SizeMangerMapper;
import com.kute.appletmanage.size.service.SizeMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Name: 尺码管理
 * @Description: 尺码管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SizeMangerServiceImpl implements SizeMangerService {

    @Autowired
    private SizeMangerMapper sizeMangerMapper;

    @Autowired
    private AppSizeMapper appSizeMapper;


    /**
     * 获取尺码列表
     */
    public PageInfo<AppSize> getSizeList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppSize> list = sizeMangerMapper.getSizeList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取尺码信息
     *
     */
    public AppSize getSizeInfoBySizeId(Integer SizeId) throws Exception {
        return appSizeMapper.selectByPrimaryKey(SizeId);
    }

    /**
     * 新增尺码
     */
    
    public ResponseResult addSize(AppSize size) throws Exception {
        AppSize rulSize= sizeMangerMapper.getSizeInfoBySizeBodyAndEur(size.getBodyType(),size.getEurCode());
        if(rulSize==null){
            appSizeMapper.insert(size);
            return  new ResponseResult("S","保存成功");
        }else{
            return  new ResponseResult("W","当前编码已存在");
        }

    }

    /**
     * 编辑尺码
     */
    
    public ResponseResult editSize(AppSize size) throws Exception {
            appSizeMapper.updateByPrimaryKey(size);
            return  new ResponseResult("S","编辑成功");
}



    /**
     * 删除尺码
     */
    
    public void removeSize(Integer sizeId) throws Exception {
        appSizeMapper.deleteByPrimaryKey(sizeId);    //删除尺码

    }

}
