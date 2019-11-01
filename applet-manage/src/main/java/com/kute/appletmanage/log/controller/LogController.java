package com.kute.appletmanage.log.controller;

import com.kute.appletmanage.log.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name: 日志管理
 * @Description: 日志管理
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-20
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-20
 */
@RestController
@RequestMapping("/app/system/job/")
@Api(value = "LogController", tags = " 系统模块-日志管理")
public class LogController {

    @Autowired
    private LogService logService;


}
