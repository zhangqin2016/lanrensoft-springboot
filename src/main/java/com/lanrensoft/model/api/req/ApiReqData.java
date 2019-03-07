package com.lanrensoft.model.api.req;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 客户端请求参数模型
 */
public class ApiReqData<T extends ApiReqBody>{

    /**
     * 请求头部信息（通用参数）
     */
	@Valid
    @NotNull
    private ApiReqHead head;
    /**
     * 请求参数
     */
	@Valid
    private T body;

    public ApiReqHead getHead() {
        return head;
    }

    public void setHead(ApiReqHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
