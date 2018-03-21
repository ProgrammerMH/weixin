package com.yc.weixin.util;

import java.util.Arrays;
/**
 * 
 * @author Administrator
 *
 */
public class CheckUtil {
	public static final String TOKEN ="mahui";
  public static boolean checkSignature(String signature,String timestamp,String nonce) {
	  
	String[] arr=new String[] {TOKEN,timestamp,nonce};
	
	System.out.println(Arrays.toString(arr));
	  //排序
	  Arrays.sort(arr);
	  StringBuffer content=new StringBuffer();
	  for(int i=0;i<arr.length;i++) {
		  content.append(arr[i]);
		  
	  }
	  //sha1 加密
	  
	  String temp=Sha1.encode(content.toString());
	  return temp.equals(signature);
  }
  
}
