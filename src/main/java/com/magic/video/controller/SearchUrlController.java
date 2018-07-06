package com.magic.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magic.video.config.DefaultConfig;
import com.magic.video.param.SearchListParam;
import com.magic.vider.util.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/360Url/search")
@Api(tags= {"360影视搜索接口请求url-api"})
public class SearchUrlController extends CustomController{
	@Autowired
	public DefaultConfig defaultConfig;
	
	@ApiOperation(value="全网热门搜索")
	@PostMapping(value="hotword")
	public String hotword() {
		runLog.info("全网热门搜索.");
		String result = HttpClient.client(defaultConfig.getSearchHotword(), HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	@ApiOperation(value="预搜索列表")
	@PostMapping(value="preList")
	public String preList(String content) {
		runLog.info("预搜索列表.content="+content);
		String url = String.format(defaultConfig.getSearchPrelist(), new Object[] {content});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	@ApiOperation(value="搜索列表")
	@PostMapping(value="list")
	public String list(@RequestBody SearchListParam param) {
		runLog.info("搜索列表.param="+param.toString());
		String url = String.format(defaultConfig.getSearchList(), new Object[] {param.getPageNo()*param.getPageSize(),param.getPageSize(),param.getContent()});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
}
