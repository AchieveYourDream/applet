package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysParameterDefine;
import java.util.List;

public interface SysParameterDefineMapper {
    int deleteByPrimaryKey(String parameterCode);

    int insert(SysParameterDefine record);

    SysParameterDefine selectByPrimaryKey(String parameterCode);

    List<SysParameterDefine> selectAll();

    int updateByPrimaryKey(SysParameterDefine record);
}