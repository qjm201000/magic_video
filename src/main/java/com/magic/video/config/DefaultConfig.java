package com.magic.video.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:default.properties")
public class DefaultConfig {
	@Value(value="${package.name}")
	private String packageName;
	@Value(value="${home.tabs}")
	private String homeTabs;
	@Value(value="${home.tab.kind}")
	private String homeTabKind;
	@Value(value="${home.tab.btv}")
	private String homeTabBtv;
	@Value(value="${search.hotword}")
	private String searchHotword;
	@Value(value="${search.prelist}")
	private String searchPrelist;
	@Value(value="${search.list}")
	private String searchList;
	@Value(value="${detail}")
	private String detail;
	@Value(value="${video.list}")
	private String videoList;
	@Value(value="${video.filter}")
	private String videoFilter;
	@Value(value="${video.filterlist}")
	private String videoFilterlist;
	
	@Value("${wx.authorizeUrl}")
	private String wxAuthorizeUrl;
	@Value(value="${wx.codeConnectUrl}")
	private String wxCodeConnectUrl;
	@Value(value="${wx.pay.invalid.time}")
	private String wxPayInvalidTime;
	

	public String getWxAuthorizeUrl() {
		return wxAuthorizeUrl;
	}

	public void setWxAuthorizeUrl(String wxAuthorizeUrl) {
		this.wxAuthorizeUrl = wxAuthorizeUrl;
	}

	@Value("${wx.codeConnectUrl}")

	public String getVideoList() {
		return videoList;
	}

	public String getVideoFilter() {
		return videoFilter;
	}

	public void setVideoList(String videoList) {
		this.videoList = videoList;
	}

	public void setVideoFilter(String videoFilter) {
		this.videoFilter = videoFilter;
	}

	public String getSearchHotword() {
		return searchHotword;
	}

	public void setSearchHotword(String searchHotword) {
		this.searchHotword = searchHotword;
	}

	public String getHomeTabBtv() {
		return homeTabBtv;
	}

	public void setHomeTabBtv(String homeTabBtv) {
		this.homeTabBtv = homeTabBtv;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getHomeTabs() {
		return homeTabs;
	}

	public void setHomeTabs(String homeTabs) {
		this.homeTabs = homeTabs;
	}

	public String getHomeTabKind() {
		return homeTabKind;
	}

	public void setHomeTabKind(String homeTabKind) {
		this.homeTabKind = homeTabKind;
	}

	public String getSearchPrelist() {
		return searchPrelist;
	}

	public void setSearchPrelist(String searchPrelist) {
		this.searchPrelist = searchPrelist;
	}

	public String getSearchList() {
		return searchList;
	}

	public void setSearchList(String searchList) {
		this.searchList = searchList;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getVideoFilterlist() {
		return videoFilterlist;
	}

	public void setVideoFilterlist(String videoFilterlist) {
		this.videoFilterlist = videoFilterlist;
	}

	public String getWxCodeConnectUrl() {
		return wxCodeConnectUrl;
	}

	public void setWxCodeConnectUrl(String wxCodeConnectUrl) {
		this.wxCodeConnectUrl = wxCodeConnectUrl;
	}

	public String getWxPayInvalidTime() {
		return wxPayInvalidTime;
	}

	public void setWxPayInvalidTime(String wxPayInvalidTime) {
		this.wxPayInvalidTime = wxPayInvalidTime;
	}
}
