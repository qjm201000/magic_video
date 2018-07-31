package com.magic.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.video.config.DefaultConfig;
import com.magic.video.util.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/360Url/home")
@Api(tags= {"360影视首页接口请求url-api"})
public class HomeUrlController extends CustomController{
	@Autowired
	public DefaultConfig defaultConfig;
	
	@ApiOperation(value="首页中的tab分类")
	@PostMapping(value="tables")
	public String homeTables() {
		runLog.info("首页中的tab分类。");
		String result = HttpClient.client(defaultConfig.getHomeTabs(), HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	@ApiOperation(value="首页中的tab种类列表（1：电影2：电视剧3：综艺4：动漫5：少儿）")
	@PostMapping(value="tableKind")
	public String homeTableKind(Integer tid) {
		runLog.info("首页中的tab种类列表。tid="+tid);
		String url = String.format(defaultConfig.getHomeTabKind(), new Object[] {tid});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	@ApiOperation(value="首页中的tab卫视列表")
	@PostMapping(value="tableBtv")
	public String homeTableBtv() {
		runLog.info("首页中的tab卫视列表。");
		String result = HttpClient.client(defaultConfig.getHomeTabBtv(), HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
}
