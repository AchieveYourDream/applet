package com.kute.appletcore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Name: 响应结果
 * @Description: 前后台交互使用
 * @CreateDate: 2018-04-11
 * @LastUpdatedBy: 王斌
 * @LastUpdateDate 2018-04-11
 */
@ApiModel(value = "ResponseResult", description = "响应结果对象")
public class ResponseResult<T>  implements Serializable {

    @ApiModelProperty(value = "响应结果编码(S[SUCCESS]:成功;E[ERROR]:失败;W[WARN]:警告)")
    private String code; // S[SUCCESS]:成功;E[ERROR]:失败;W[WARN]:警告

    @ApiModelProperty(value = "响应结果信息，客户端用来给用户提示")
    private String info; // 前台提示信息

    @ApiModelProperty(value = "响应结果数据(S[SUCCESS]:数据信息;E[ERROR]:异常信息;W[WARN]:警告信息)")
    private T data; // S[SUCCESS]:数据信息;E[ERROR]:异常信息;W[WARN]:警告信息

    public ResponseResult(String code, String info, T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public ResponseResult() {
        // TODO Auto-generated constructor stub
    }

    public ResponseResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
