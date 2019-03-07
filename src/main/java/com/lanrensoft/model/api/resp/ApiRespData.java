package com.lanrensoft.model.api.resp;


/**
 * 
* @ClassName: ApiRespData 
* @Description: 请求返回工具类 
* @author zhangqin
*
* @param <T>
 */
public class ApiRespData<T> {

    /**
     * 返回信息头
     */
    private ApiRespHead head;
    /**
     * 返回信息体
     */
	
    private T body;

    public ApiRespData() {
    }

    private ApiRespData(ApiResultEnum resultCode, T body) {
        ApiRespHead apiRespHead = new ApiRespHead(resultCode.getCode(), resultCode.getMessage());
        apiRespHead.setErrorCode(resultCode.getErrorCode());
        this.head = apiRespHead;
        this.body = body;
    }

    public static <T> ApiRespData<T> buildSucc(T result) {
        return new ApiRespData<T>(ApiResultEnum.SUCCESS, result);
    }
    public static <T> ApiRespData<T> buildSucc() {
        return new ApiRespData<T>(ApiResultEnum.SUCCESS, null);
    }
    public static <T> ApiRespData<T> buildFail(ApiResultEnum resultCode) {
        return new ApiRespData<T>(resultCode, null);
    }

    public ApiRespHead getHead() {
        return head;
    }

    public void setHead(ApiRespHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
    
    
}
