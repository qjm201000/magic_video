package com.magic.video.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="影视列表param")
public class VideoListParam extends PageParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="tid:类别")
	private Integer tid;
	@ApiModelProperty(value="cid:3:电视剧4：电影5：综艺6：少儿")
	private Integer cid;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "TeleplayListParam [tid=" + tid + ", cid=" + cid + ", getPageNo()=" + getPageNo() + ", getPageSize()="
				+ getPageSize() + "]";
	}


}
