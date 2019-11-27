package com.kute.appletgoods.exception;


import com.kute.appletcore.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Name: 应用异常处理器
 * @Description: 记录系统异常，并将JSON异常对象返回给客户端；HttpLogAspect拦截异常信息并记录到日志表。
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-11
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-11
 */


@ControllerAdvice
public class ApplicationExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e) {

        ResponseResult result = new ResponseResult();
        result.setCode("E");
        result.setData(e.getMessage());
        result.setInfo("接口调用异常");
        
        return result;
    }

}
