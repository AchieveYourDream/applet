package com.kute.appletcore.dao;

import com.kute.appletcore.entity.AppCusDemandBudget;
import java.util.List;

public interface AppCusDemandBudgetMapper {
    int deleteByPrimaryKey(String budgetId);

    int insert(AppCusDemandBudget record);

    AppCusDemandBudget selectByPrimaryKey(String budgetId);

    List<AppCusDemandBudget> selectAll();

    int updateByPrimaryKey(AppCusDemandBudget record);
}