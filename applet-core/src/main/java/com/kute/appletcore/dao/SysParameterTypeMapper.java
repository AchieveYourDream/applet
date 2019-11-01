package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysParameterType;
import java.util.List;

public interface SysParameterTypeMapper {
    int deleteByPrimaryKey(String typeCode);

    int insert(SysParameterType record);

    SysParameterType selectByPrimaryKey(String typeCode);

    List<SysParameterType> selectAll();

    int updateByPrimaryKey(SysParameterType record);
}