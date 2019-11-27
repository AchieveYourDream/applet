package com.kute.appletmanage.technologyConflict.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kute.appletcore.dao.SysTechnologyConflictMapper;
import com.kute.appletcore.entity.SysTechnologyConflict;
import com.kute.appletcore.vo.ResponseResult;
import com.kute.appletmanage.technologyConflict.dao.TechnologyConflictMangerMapper;
import com.kute.appletmanage.technologyConflict.service.TechnologyConflictMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Name: 工艺冲突管理
 * @Description: 工艺冲突管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TechnologyConflictMangerServiceImpl implements TechnologyConflictMangerService {

    @Autowired
    private TechnologyConflictMangerMapper technologyConflictMangerMapper;

    @Autowired
    private SysTechnologyConflictMapper sysTechnologyConflictMapper;


    /**
     * 获取工艺冲突列表
     */
    public PageInfo<SysTechnologyConflict> getTechnologyConflictList(Integer pageNum, Integer pageSize, String search) throws Exception {
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<SysTechnologyConflict> list = technologyConflictMangerMapper.getTechnologyConflictList(search);
        return new PageInfo<>(list);
    }


    /**
     * 获取工艺下拉选
     */
    public List<Map<String, String>> getTechnologyList(String search) throws Exception {
        return technologyConflictMangerMapper.getTechnologyList(search);
    }

    /**
     * 获取工艺冲突信息
     */
    public SysTechnologyConflict getTechnologyConflictInfoByTechnologyConflictId(Integer id) throws Exception {
        return sysTechnologyConflictMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增工艺冲突
     */

    public ResponseResult addTechnologyConflict(SysTechnologyConflict sf) throws Exception {
        SysTechnologyConflict stc = technologyConflictMangerMapper.getTechnologyConflictInfoByTechnologyConflictCode(sf);
        if (stc == null) {
            sysTechnologyConflictMapper.insert(sf);
            return new ResponseResult("S", "保存成功");
        } else {
            return new ResponseResult("W", "当前工艺冲突已存在");
        }


    }


    /**
     * 删除工艺冲突
     */

    public void removeTechnologyConflict(Integer id) throws Exception {
        sysTechnologyConflictMapper.deleteByPrimaryKey(id);    //删除工艺冲突

    }

}
