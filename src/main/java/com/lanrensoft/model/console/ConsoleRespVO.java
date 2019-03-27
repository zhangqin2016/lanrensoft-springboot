package com.lanrensoft.model.console;


public class ConsoleRespVO<T> {

    /**
     * 接口返回码
     */
    private int success;
    /**
     * 错误信息
     */
    private String message;

    private String code;
    private T data;
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

    public T getData() {
        return data;
    }

    public ConsoleRespVO() {
    }

    public ConsoleRespVO(int success, String message, String code, T data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }
    public ConsoleRespVO(ConsoleResultEnum consoleResultEnum, T data) {
        this.success = consoleResultEnum.getSuccess();
        this.message = consoleResultEnum.getMessage();
        this.code = consoleResultEnum.getCode();
        this.data = data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public static <T> ConsoleRespVO<T> buildSucc(T result) {
        return new ConsoleRespVO<T>(ConsoleResultEnum.SUCCESS, result);
    }
    public static <T> ConsoleRespVO<T> buildSucc() {
        return new ConsoleRespVO<T>(ConsoleResultEnum.SUCCESS, null);
    }
    public static <T> ConsoleRespVO<T> buildFail(ConsoleResultEnum resultCode) {
        return new ConsoleRespVO<T>(resultCode, null);
    }
}
