package com.kute.appletmanage.lining.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.AppLiningMapper;
import com.kute.appletcore.entity.AppLining;
import com.kute.appletmanage.lining.dao.LiningMangerMapper;
import com.kute.appletmanage.lining.service.LiningMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Name: 衬类型管理
 * @Description: 衬类型管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LiningMangerServiceImpl implements LiningMangerService {

    @Autowired
    private LiningMangerMapper liningMangerMapper;

    @Autowired
    private AppLiningMapper appLiningMapper;


    /**
     * 获取衬类型列表
     */
    public PageInfo<AppLining> getLiningList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<AppLining> list = liningMangerMapper.getLiningList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取衬类型信息
     *
     */
    public AppLining getLiningInfoById(Integer id) throws Exception {
        return appLiningMapper.selectByPrimaryKey(id);
    }
    /**
     * 获取衬类型信息
     *
     */
    public AppLining getLiningInfoByLiningCode(String liningCode,String  category) throws Exception {
        return liningMangerMapper.getLiningInfoByLiningCode(liningCode,category);
    }

    /**
     * 新增衬类型
     */
    
    public void addLining(AppLining al) throws Exception {
        appLiningMapper.insert(al);
    }

    /**
     * 编辑衬类型
     */
    
    public void editLining(AppLining al) throws Exception {
        appLiningMapper.updateByPrimaryKey(al);
    }


    /**
     * 删除衬类型
     */
    
    public void removeLining(Integer id) throws Exception {
        appLiningMapper.deleteByPrimaryKey(id);    //删除衬类型

    }

    /**
     * 根据品类获取衬类型
     */
    public List<Map> getLiningListByCategory(String category) throws Exception{
      return liningMangerMapper.getLiningListByCategory(category);


    }

}
