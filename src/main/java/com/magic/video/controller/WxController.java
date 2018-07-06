package com.magic.video.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.vider.util.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("url")
@Api(tags= {"微信-api"})
public class WxController extends CustomController{
	
	@ApiOperation(value="根据url获取json数据")
	@PostMapping(value="aaa")
	public String requestUrl(String url) {
		runLog.info("根据url获取json数据,url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
}
