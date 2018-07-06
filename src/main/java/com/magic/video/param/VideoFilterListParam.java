package com.magic.video.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="影视过滤列表param")
public class VideoFilterListParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="当前页面，从0开始")
	private Integer pageNo;
	@ApiModelProperty(value="cid:3:电视剧4：电影5：综艺6：少儿")
	private Integer cid;
	@ApiModelProperty(value="地区")
	private String area;
	@ApiModelProperty(value="类型")
	private String cat;
	@ApiModelProperty(value="年份")
	private String year;
	@ApiModelProperty(value="0:少儿1:电影2：电视剧4：动漫")
	private Integer c;
	public Integer getPageNo() {
		return pageNo;
	}
	public Integer getCid() {
		return cid;
	}
	public String getArea() {
		return area;
	}
	public String getCat() {
		return cat;
	}
	public String getYear() {
		return year;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "VideoFilterListParam [pageNo=" + pageNo + ", cid=" + cid + ", area=" + area + ", cat=" + cat + ", year="
				+ year + ", c=" + c+ "]";
	}


}
