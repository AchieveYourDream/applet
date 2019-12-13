package com.kute.appletcore.dao;

import com.kute.appletcore.entity.InvOrderNumber;
import java.util.List;

public interface InvOrderNumberMapper {
    int insert(InvOrderNumber record);
    int update(InvOrderNumber record);

    List<InvOrderNumber> selectAll();

    InvOrderNumber selectByPrefixAndDateTime(InvOrderNumber record);



}