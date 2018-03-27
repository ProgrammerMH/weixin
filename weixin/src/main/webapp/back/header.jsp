<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
path+"/";

%>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
<script type="text/javascript" src="./easyui/jquery.min.js"></script>
<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
<title>中州笔韵微信后台</title>
</head>
<body class="easyui-layout">  
