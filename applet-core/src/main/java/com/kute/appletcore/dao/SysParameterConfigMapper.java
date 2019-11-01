package com.kute.appletcore.dao;

import com.kute.appletcore.entity.SysParameterConfig;
import java.util.List;

public interface SysParameterConfigMapper {
    int deleteByPrimaryKey(String parameterCode);

    int insert(SysParameterConfig record);

    SysParameterConfig selectByPrimaryKey(String parameterCode);

    List<SysParameterConfig> selectAll();

    int updateByPrimaryKey(SysParameterConfig record);
}