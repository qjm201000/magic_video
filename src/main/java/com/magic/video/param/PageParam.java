package com.magic.video.param;

import io.swagger.annotations.ApiModelProperty;

public class PageParam {
	@ApiModelProperty(value="当前页数：从0开始，0,1,2,3,4")
	private int pageNo;
	@ApiModelProperty(value="每页条数")
	private int pageSize;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
