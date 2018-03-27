package com.yc.wexin.bean;

public class News {
  private String Title ;
  private String Description;
  private String PicUrl;
  private String Url;
  
public News(String title, String description, String picUrl, String url) {
	super();
	Title = title;
	Description = description;
	PicUrl = picUrl;
	Url = url;
}

public News() {
	super();
}

public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getPicUrl() {
	return PicUrl;
}
public void setPicUrl(String picUrl) {
	PicUrl = picUrl;
}
public String getUrl() {
	return Url;
}
public void setUrl(String url) {
	Url = url;
}
  
}
