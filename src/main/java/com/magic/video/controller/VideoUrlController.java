package com.magic.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magic.video.config.DefaultConfig;
import com.magic.video.param.VideoFilterListParam;
import com.magic.video.param.VideoListParam;
import com.magic.vider.util.HttpClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/360Url/teleplay")
@Api(tags= {"影视请求url-api"})
public class VideoUrlController extends CustomController{
	@Autowired
	public DefaultConfig defaultConfig;
	
	@ApiOperation(value="筛选条件:cid:3:电视剧4：电影5：综艺6：少儿")
	@PostMapping(value="filter")
	public String filter(Integer cid) {
		runLog.info("筛选条件,cid="+cid);
		String url = String.format(defaultConfig.getVideoFilter(), new Object[] {cid});
		runLog.info("url="+url);runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	
	@ApiOperation(value="列表.")
	@PostMapping(value="list")
	public String list(@RequestBody VideoListParam param) {
		runLog.info("列表,param="+param.toString());
		String url = String.format(defaultConfig.getVideoList(), new Object[] {param.getTid(),param.getPageNo()*param.getPageSize(),param.getPageSize(),param.getCid()});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	
	@ApiOperation(value="筛选的列表")
	@PostMapping(value="filterlist")
	public String filterlist(@RequestBody VideoFilterListParam param) {
		runLog.info("筛选的列表,param="+param.toString());
		String url = String.format(defaultConfig.getVideoFilterlist(), 
				new Object[] {param.getPageNo()+1,param.getCid(),param.getArea(),
						param.getCat(),param.getYear(),param.getC()});
		runLog.info("url="+url);
		String result = HttpClient.client(url, HttpMethod.GET, null);
		result = result.substring(result.indexOf("{"));
		runLog.info("根据url获取json数据,result="+result);
		return result;
	}
	
}
