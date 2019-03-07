package com.lanrensoft.model.api.resp;

/**
 * 
* @ClassName: ApiRespHead 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhangqin
* @date 2016年4月11日 下午1:47:37 
*
 */
public class ApiRespHead {

    /**
     * 接口返回码
     */
    private int success;
    /**
     * 错误信息
     */
    private String message;

    private int code;

    
    public ApiRespHead() {

    }
    public ApiRespHead(int success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiRespHead(int success, String message, int code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
