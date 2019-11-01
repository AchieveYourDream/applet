package com.kute.appletcore.vo;

public class SysUserVO {

    private String user_id;
    private String username;
    private String password;
    private String lastname;
    private String email;
    private String mobilephone;
    private String description;
    private String skin;
    private String user_type;
    private String user_status;
    private String start_date;
    private String end_date;
    private String password_change_date;
    private String default_role_id;
    private String create_date;
    private String last_update_date;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;

    private String user_type_dis;
    private String user_status_dis;
    private String skin_dis;
    private String default_role_dis;
    private String bootstrapSkin;
    private String lessee_id;

    public String getLessee_id() {
        return lessee_id;
    }

    public void setLessee_id(String lessee_id) {
        this.lessee_id = lessee_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getBootstrapSkin() {
        return bootstrapSkin;
    }

    public void setBootstrapSkin(String bootstrapSkin) {
        this.bootstrapSkin = bootstrapSkin;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPassword_change_date() {
        return password_change_date;
    }

    public void setPassword_change_date(String password_change_date) {
        this.password_change_date = password_change_date;
    }

    public String getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(String default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getUser_type_dis() {
        return user_type_dis;
    }

    public void setUser_type_dis(String user_type_dis) {
        this.user_type_dis = user_type_dis;
    }

    public String getUser_status_dis() {
        return user_status_dis;
    }

    public void setUser_status_dis(String user_status_dis) {
        this.user_status_dis = user_status_dis;
    }

    public String getSkin_dis() {
        return skin_dis;
    }

    public void setSkin_dis(String skin_dis) {
        this.skin_dis = skin_dis;
    }

    public String getDefault_role_dis() {
        return default_role_dis;
    }

    public void setDefault_role_dis(String default_role_dis) {
        this.default_role_dis = default_role_dis;
    }

    public String generateBootstrapSkin(String skin) {
        if (skin.contains("blue")) {
            return "primary";
        } else if (skin.contains("red")) {
            return "danger";
        } else if (skin.contains("yellow")) {
            return "warning";
        } else if (skin.contains("green")) {
            return "success";
        } else {
            return "default";
        }
    }

}
