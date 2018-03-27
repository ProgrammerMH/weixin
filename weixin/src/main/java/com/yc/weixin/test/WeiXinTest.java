package com.yc.weixin.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.yc.weixin.util.WeiXinUtil;
import com.yc.wexin.bean.AccessToken;

import net.sf.json.JSONObject;

public class WeiXinTest {
	private static  String PATH=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	static Properties prop=null;
	
	
	
   public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
	    
	   AccessToken token=WeiXinUtil.getAccessToken();
	System.out.println("access_token票据:"+token.getToken());
	System.out.println("有效时间:"+token.getExpiresIn());
	String path="d:/1.jpg";
	String mediaId =WeiXinUtil.upload(path,token.getToken(), "thumb");
//	if(mediaId==null) {
//		 AccessToken token=WeiXinUtil.getAccessToken();
//		
//	}
	System.out.println(mediaId);
	String menu=JSONObject.fromObject(WeiXinUtil.initMenu()).toString();
	int result=WeiXinUtil.createMenu(token.getToken(), menu);
	if(result==0) {
		System.out.println("创建菜单成功");
	}else {
		System.out.println("错误码:"+result);
	}
}
}
