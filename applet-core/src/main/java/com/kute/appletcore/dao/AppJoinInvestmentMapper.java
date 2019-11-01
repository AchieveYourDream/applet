package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppJoinInvestment;
import java.util.List;

public interface AppJoinInvestmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppJoinInvestment record);

    AppJoinInvestment selectByPrimaryKey(Integer id);

    List<AppJoinInvestment> selectAll();

    int updateByPrimaryKey(AppJoinInvestment record);
}