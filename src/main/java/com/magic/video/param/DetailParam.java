package com.magic.video.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="详情param")
public class DetailParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="id")
	private String id;
	@ApiModelProperty(value="cat:0:少儿1:电影2：电视剧4：动漫")
	private Integer cat;

	public String getId() {
		return id;
	}
	public Integer getCat() {
		return cat;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCat(Integer cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "DetailParam [id=" + id + ", cat=" + cat + "]";
	}

}
