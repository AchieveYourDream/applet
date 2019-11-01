package com.kute.appletcore.vo;

/**
 * @Name: 登录用户
 * @Description: 登录用户
 * @CreatedBy: zoran
 * @CreateDate: 2018-04-21
 * @LastUpdatedBy: zoran
 * @LastUpdateDate 2018-04-21
 */
public class LoginUser {

    private String username;

    private String password;

    private String imageVerificationId;

    private String imageVerificationCode;

    private String smsVerificationId;

    private String smsVerificationCode;

    private String token;

    private String memberType;

    public String getMember_type() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageVerificationId() {
        return imageVerificationId;
    }

    public void setImageVerificationId(String imageVerificationId) {
        this.imageVerificationId = imageVerificationId;
    }

    public String getImageVerificationCode() {
        return imageVerificationCode;
    }

    public void setImageVerificationCode(String imageVerificationCode) {
        this.imageVerificationCode = imageVerificationCode;
    }

    public String getSmsVerificationId() {
        return smsVerificationId;
    }

    public void setSmsVerificationId(String smsVerificationId) {
        this.smsVerificationId = smsVerificationId;
    }

    public String getSmsVerificationCode() {
        return smsVerificationCode;
    }

    public void setSmsVerificationCode(String smsVerificationCode) {
        this.smsVerificationCode = smsVerificationCode;
    }

}
