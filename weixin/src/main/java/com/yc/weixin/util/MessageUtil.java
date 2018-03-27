package com.yc.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.yc.wexin.bean.Image;
import com.yc.wexin.bean.ImageMessage;
import com.yc.wexin.bean.Music;
import com.yc.wexin.bean.MusicMessage;
import com.yc.wexin.bean.News;
import com.yc.wexin.bean.NewsMessage;
import com.yc.wexin.bean.TextMessage;

/**
 * 
 * @author Administrator
 *
 */
public class MessageUtil {
	public static final String MESSAGE_TEXT ="text";
	public static final String MESSAGE_NEWS ="news";
	public static final String MESSAGE_IMAGE ="image";
	public static final String MESSAGE_VOICE ="voice";
	public static final String MESSAGE_VIDEO ="video";
	public static final String MESSAGE_LINK ="link";
	public static final String MESSAGE_LOCATION ="location";
	public static final String MESSAGE_EVENT ="event";
	public static final String MESSAGE_SUBSCRIBE ="subscribe";
	public static final String MESSAGE_UNSUBSCRIBE ="unsubscribe";
	public static final String MESSAGE_CLICK ="click";
	public static final String MESSAGE_VIEW ="view";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_SCANCODE = "scancode_push";
	

	/**
	 * xml转化为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
   public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
	  Map<String,String> map=new HashMap<String,String>();
	  SAXReader reader=new SAXReader();
	   InputStream ins=request.getInputStream();
	   Document doc=reader.read(ins);
	   Element root=doc.getRootElement();
	   List<Element> list=root.elements();
	   for(Element e:list) {
		   map.put(e.getName(), e.getText());
	   }
	   ins.close();
	   return map;
    }
   
   /**
    * 
    * 将文本消息对象转换为XML
    * @param textMessage
    * @return
    */
   public static String textMessageToXml(TextMessage textMessage) {
	XStream xStream=new XStream();
	xStream.alias("xml", textMessage.getClass());
	return xStream.toXML(textMessage);
	
	   
	   
   }
   /**
    * 图文消息转为XML
    * @param newsMessage
    * @return
    */
   public static String newsMessageToXml(NewsMessage newsMessage) {
	XStream xStream=new XStream();
	xStream.alias("xml", newsMessage.getClass());
	xStream.alias("item", new News().getClass());
	return xStream.toXML(newsMessage);
	
	   
	   
   }
   public static String imageToXml(ImageMessage imageMessage) {
	    XStream xStream=new XStream();
		xStream.alias("xml", imageMessage.getClass());
		return xStream.toXML(imageMessage);
   }
   public static String musicToXml(MusicMessage musicMessage) {
	    XStream xStream=new XStream();
		xStream.alias("xml", musicMessage.getClass());
		return xStream.toXML(musicMessage);
  }
   /**
    * 组装文本回复消息
    * @param toUserName
    * @param fromUserName
    * @param content
    * @return
    */
   public static String initText(String toUserName,String fromUserName,String content) {
	   TextMessage text=new TextMessage();
		 text.setFromUserName(toUserName);
		 text.setToUserName(fromUserName);
		 text.setMsgType(MESSAGE_TEXT);
		 text.setCreateTime(new Date().getTime());
		 text.setContent(content);
		 
			return MessageUtil.textMessageToXml(text);

	   
   }
   /**
    * 组装图文消息
    * @param toUserName
    * @param fromUserName
    * @return
    */	
   public static String initNewsMessage(String toUserName,String fromUserName){
	     String message=null;
	     List<News> newsList=new ArrayList<News>();
	     NewsMessage newsMessage=new NewsMessage();
	     News news=new News();
	 
	     news.setTitle("中州韵介绍");
	     news.setDescription("没有办法就是牛皮");
	     news.setPicUrl("http://20091b8a.nat123.cc/weixin/image/zzyimage.jpg");
	     news.setUrl("www.baidu.com");
	     newsList.add(news);
	     newsMessage.setToUserName(fromUserName);
	     newsMessage.setFromUserName(toUserName);
	     newsMessage.setCreateTime(new Date().getTime());
	     newsMessage.setMsgType(MESSAGE_NEWS);
	     newsMessage.setArticleCount(newsList.size());
	     newsMessage.setArticles(newsList);
	     message=newsMessageToXml(newsMessage);
			return message;

	   
   }
   /**
    * 组装图片消息
    * @return
    */
   public static String initImageMessage(String toUserName,String fromUserName) {
	  String message=null;
	  Image image=new Image();
	  image.setMediaId("VoQMKmkvhqAVpuf9L_dga_PbTJhQpjQceDxX7YK1w4LRTHEekYzH-9h24tytHtwA");
	   ImageMessage imageMessage=new ImageMessage();
	   imageMessage.setFromUserName(toUserName);
	   imageMessage.setToUserName(fromUserName);
	   imageMessage.setMsgType(MESSAGE_IMAGE);
	   imageMessage.setCreateTime(new Date().getTime());
	   imageMessage.setIamge(image);
	   message=imageToXml(imageMessage);
	   return message;
	   
   }
   public static String initMusicMessage(String toUserName,String fromUserName) {
		  String message=null;
		  Music music=new Music();
		  music.setThumbMediaId("E0rKges3hjBWVRxpHe6Is9To6MTAWiuXgA_iUXvyblKI9X07IhT5NfDozRfZJdkO");
		  music.setTitle("if life always this hard ");
		  music.setDescription("right here waiting");
		  music.setMusicUrl("http://20091b8a.nat123.cc/weixin/resouce/123.mp3");
		  music.setHQMusicUrl("http://20091b8a.nat123.cc/weixin/resouce/123.mp3");
		  	
		   MusicMessage musicMessage=new MusicMessage();
		   musicMessage.setFromUserName(toUserName);
		   musicMessage.setToUserName(fromUserName);
		   musicMessage.setMsgType(MESSAGE_MUSIC);
		   musicMessage.setCreateTime(new Date().getTime());
		   musicMessage.setMusic(music);
		   message=musicToXml(musicMessage);
		   return message;
		   
	   }
   public static String booksMenuText() {
	   StringBuffer sb=new StringBuffer();
	   sb.append("Hello sir my name is 中州笔韵\n\n");
	   sb.append("1.乡村艳妇\n");
	   sb.append("2.大主宰\n");
	   sb.append("回复?调出主菜单");
	   
	return sb.toString();
	   
   }
   
   /*
    * 主菜单
    * 
    * 
    */
   public static String menuText() {
	StringBuffer sb=new StringBuffer();
	   sb.append("Hello sir my name is 中州笔韵\n\n");
	   sb.append("1.查看热门书籍\n");
	   sb.append("2.开发中\n");
	   sb.append("回复?调出主菜单");
	   return sb.toString();
	   
   }
   /**
    * 
    * @return
    */
   public static String weMenuText() {
		StringBuffer sb=new StringBuffer();
		   sb.append("Hello sir my name is 中州笔韵\n\n");
		   sb.append("\n");
		   sb.append("\n");
		   sb.append("回复?调出主菜单");
		   return sb.toString();
		   
	   }
   }