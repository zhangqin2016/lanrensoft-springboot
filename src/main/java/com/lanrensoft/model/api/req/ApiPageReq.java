/*
 * Copyright (c) 2016 太阳花互动科技. All Rights Reserved.
 */
package com.lanrensoft.model.api.req;

import javax.validation.constraints.Min;

public class ApiPageReq extends ApiReqBody {
	@Min(1)
	private int pageNumber;
	@Min(1)
	private int pageSize=10;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
