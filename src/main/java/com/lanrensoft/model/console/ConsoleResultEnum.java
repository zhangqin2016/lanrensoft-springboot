package com.lanrensoft.model.console;


/**
 * 接口错误码
 **/
public enum ConsoleResultEnum {

    SUCCESS(1, "成功"),
    FAIL(1, "失败"),
    LOGIN_PASSWORD_ERROR(1, "失败","3001");
    private int success;
    private String message;
    private String code;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ConsoleResultEnum(int success, String message, String code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }

    ConsoleResultEnum(int success, String message) {
        this.success = success;
        this.message = message;
    }
}
