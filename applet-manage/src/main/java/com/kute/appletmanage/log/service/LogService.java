package com.kute.appletmanage.log.service;

import com.kute.appletmanage.log.dao.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name: 日志管理
 * @Description: 日志管理
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-20
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-20
 */
@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

}
