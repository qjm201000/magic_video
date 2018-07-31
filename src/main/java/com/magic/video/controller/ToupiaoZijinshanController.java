package com.magic.video.controller;

import java.util.Random;
import java.util.Vector;

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
@RequestMapping("/toupiao")
@Api(tags= {"投票-api"})
public class ToupiaoZijinshanController extends CustomController{
	public volatile int  flag = 0;
	public int [] zjss = {60,61,62,63,64,65,68,70,71,72,73,74,75,76,77};
	
	@Autowired
	public DefaultConfig defaultConfig;
	
	@ApiOperation(value="紫金山投票")
	@PostMapping(value="zjs")
	public int zjs() {
		runLog.info("紫金山投票.");

		Vector<Thread> threads = new Vector<Thread>();
		//开10个线程
		for(int i = 0;i<5000;i++) {
			Thread iThread = new ZjsThread();
			threads.add(iThread);
			iThread.start();
		}
		for (Thread iThread : threads) {
	      try {
	         iThread.join();
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
		}

		runLog.info("请求成功的次数：flag="+flag);
		return flag;
	}
	
	private class ZjsThread extends Thread{
        @Override
        public void run() {
        	System.out.println("当前线程："+Thread.currentThread().getName()+",start");
        	//循环请求100次
        	for(int i = 0;i<100;i++) {
        		String selectIds = sui();
        		System.out.println("selectIds="+selectIds);
        		String url = "http://www.zijinshan.org/voteApi/vote.php?hid=1&active_id=1&slist="+selectIds;
        		String ip = getRandomIp();
        		System.out.println("ip="+ip);
        		//每人可以投10票
        		for(int j=0;j<10;j++) {
        			//6分钟 360
//        			int random = (int)(Math.random()*360+1);
//        			try {
//						Thread.sleep(random);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
        			String result = HttpClient.clientIP(url, HttpMethod.GET, null,ip);
        			System.out.println("result="+result);
            		if(result.contains("success")) {
            			flag ++;
            		}
        		}
        	}
        	System.out.println("当前线程："+Thread.currentThread().getName()+",end");
        }
        public String sui() {
        	//随机抽取9个不重复的
        	 int[] num = new int[9];
        	 boolean b;
        	 int i=0;
        	 while(i<9){
        		 int length = zjss.length -1;
        		 int random = zjss[(int)(Math.random()*length+0)];
        		 b = true;
        		 for(int n=0;n<i;n++){
        			 if(num[n]==random){
    			       b = false;
    			       break;
    			     }
        		 }
        		 if(b)
        		 {
				    num[i]=random;
				    i++;
			     }
        	 }
        	String selectIds = "66,";
        	for(int j=0;j<num.length;j++) {
    			selectIds +=num[j]+",";
    		}
        	selectIds = selectIds.substring(0, selectIds.length()-1);
        	return selectIds;
    	}
        public String num2ip(int ip) {
    		int[] b = new int[4];
    		String x = "";
    		b[0] = (int) ((ip >> 24) & 0xff);
    		b[1] = (int) ((ip >> 16) & 0xff);
    		b[2] = (int) ((ip >> 8) & 0xff);
    		b[3] = (int) (ip & 0xff);
    		x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);
     
    		return x;
    	}
        public String getRandomIp() {
    		// ip范围
    		int[][] range = { { 607649792, 608174079 }, // 36.56.0.0-36.63.255.255
    				{ 1038614528, 1039007743 }, // 61.232.0.0-61.237.255.255
    				{ 1783627776, 1784676351 }, // 106.80.0.0-106.95.255.255
    				{ 2035023872, 2035154943 }, // 121.76.0.0-121.77.255.255
    				{ 2078801920, 2079064063 }, // 123.232.0.0-123.235.255.255
    				{ -1950089216, -1948778497 }, // 139.196.0.0-139.215.255.255
    				{ -1425539072, -1425014785 }, // 171.8.0.0-171.15.255.255
    				{ -1236271104, -1235419137 }, // 182.80.0.0-182.92.255.255
    				{ -770113536, -768606209 }, // 210.25.0.0-210.47.255.255
    				{ -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
    		};
     
    		Random rdint = new Random();
    		int index = rdint.nextInt(10);
    		String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
    		return ip;
    	}
	}
	public static void main(String[] args) {
		new ToupiaoZijinshanController().zjs();
		
	}
	
}
