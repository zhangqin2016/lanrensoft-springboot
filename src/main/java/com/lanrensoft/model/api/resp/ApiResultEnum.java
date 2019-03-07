package com.lanrensoft.model.api.resp;


/**
 * 接口错误码
 **/
public enum ApiResultEnum {

    SUCCESS(1, "成功"), 
    JSSON_ERROR(0, "json数据结构不匹配",40002),
   PARAMEERROR(0, "参数不完整",60001),
    ERR500(0, "系统异常",50001),
    TOKENERR(0, "鉴权失败",40001),
    TOKENTIME(0, "鉴权过期",70002);

    private int code;
    private String message;
    private int errorCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    ApiResultEnum(int code, String message, int errorCode) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }

    ApiResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
