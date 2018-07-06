package com.magic.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magic.video.config.DefaultConfig;
import com.magic.video.param.DetailParam;
import com.magic.vider.util.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/360Url/detail")
@Api(tags= {"详情请求url-api"})
public class DetailUrlController extends CustomController{
	@Autowired
	public DefaultConfig defaultConfig;
	
	@ApiOperation(value="资源详情")
	@PostMapping(value="detail")
	public String detail(@RequestBody DetailParam param) {
		runLog.info("资源详情.param = "+param);
		String url = String.format(defaultConfig.getDetail(), new Object[] {param.getId(),param.getCat()});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	
}
