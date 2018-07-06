package com.magic.video.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="搜索param")
public class SearchListParam extends PageParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="输入的内容")
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("SearchListParam [content=%s, getPageNo()=%s, getPageSize()=%s]", content, getPageNo(),
				getPageSize());
	}

}
