<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>中州笔韵</title>
<link rel="stylesheet" type="text/css" href="css/style2.0.css">
<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:40%;top:5%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}

	.tyg-div-form form button {
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body>
<script type="text/javascript">
function reloadImage(){
    document.getElementById('btn').disabled=true;
    document.getElementById('identity').src='./code.do?ts='+new Date().getTime();
}
</script>
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">阅</div></li>
    	<li><div style="margin-left:40px;">读</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">中州笔韵微信后台</div>
		<div class="title1">历史、玄幻、武侠、二次元、经典</div>
		<div class="imgGroug">
		</div>
		<img alt="" class="img3 png" src="./img/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
	<div class="tyg-div-form">
		<form action="ProgrammerMH.do" method="post">
			<h2>登录</h2><p class="tyg-p">欢迎访问中州笔韵</p>
			<div style="margin:5px 0px;">
				<input name="name" type="text" placeholder="请输入账号..."/>
			</div>
			<div style="margin:5px 0px;">
				<input name="password" type="password" placeholder="请输入密码 ..."/>
			</div>
			<div style="margin:5px 0px;">
				<input name="code" type="text" style="width:150px;" placeholder="请输入验证码..." />
				<img src="./code.do" id="identity" onload="btn.disabled=false;" />
				<input type=button value="换张图片" onclick="reloadImage()" id="btn">
			</div>
			<button type="submit" >登<span style="width:20px;"></span>陆</button>
		</form>
	</div>
</div>


<script type="text/javascript" src="./js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="./js/com.js"></script>
<!--[if IE 6]>
<script language="javascript" type="text/javascript" src="./script/ie6_png.js"></script>
<script language="javascript" type="text/javascript">
DD_belatedPNG.fix(".png");
</script>
<![endif]-->
<div style="text-align:center;">
</div>


</body>
</html>