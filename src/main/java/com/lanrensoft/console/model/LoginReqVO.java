package com.lanrensoft.console.model;

public class LoginReqVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 验证码
     */
    private String validateCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
