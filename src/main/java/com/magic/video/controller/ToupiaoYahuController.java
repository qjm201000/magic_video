package com.magic.video.controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.magic.video.util.HttpClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/toupiao")
@Api(tags= {"投票-api"})
public class ToupiaoYahuController extends CustomController{
	
	@ApiOperation(value="雅虎投票")
	@PostMapping(value="zjs")
	public void zjs() throws InterruptedException, UnsupportedEncodingException {
		runLog.info("雅虎投票.");
		
		for(int i = 0;i<20;i++) {
			Thread iThread = new ZjsThread();
			iThread.start();
		}
		
	}
	
	private class ZjsThread extends Thread{
        @Override
        public void run() {
        	System.out.println("当前线程："+Thread.currentThread().getName()+",start");
        	//循环请求100次
        	for(int i = 0;i<10000;i++) {
        		System.out.println("循环次数："+i);
    			//http://f1ol1l.jia.yahuq.top/app/index.php?i=32&c=entry&rid=3353&id=254609&do=vote&m=tyzm_diamondvote
    			//http://f1ol1l.jia.yahuq.top/app/index.php?i=32&c=entry&rid=3353&id=254626&do=vote&m=tyzm_diamondvote
        		String url = "http://f1ol1l.jia.yahuq.top/app/index.php?i=32&c=entry&rid=3353&id=254609&do=vote&m=tyzm_diamondvote";
        		HttpHeaders headers = new HttpHeaders();
                headers.set("X-Requested-With", "XMLHttpRequest");
                headers.set("User-Agent", "Mozilla/5.0 (Linux; Android 7.1.1; OD103 Build/NMF26F; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36 MicroMessenger/6.6.6.1300(0x26060632) NetType/WIFI Language/zh_CN");
        		String result = HttpClient.clientHeader(url, HttpMethod.GET, null, headers);
        		System.out.println("result="+result);
        		JSONObject obj=JSON.parseObject(result);
        		String msg = obj.get("msg").toString();
        		System.out.println("msg="+msg);
    			int random=(int) (Math.random()*1000+2000);
    			System.out.println("随机时间："+random);
    			try {
					Thread.sleep(random);//
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
        	System.out.println("当前线程："+Thread.currentThread().getName()+",end");
        }
        
       
	}
	
	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		new ToupiaoYahuController().zjs();
	}
	
}
