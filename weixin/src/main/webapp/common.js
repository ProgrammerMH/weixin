var xmlHttp;
function createXmlHttpRequest(){
if(window.XmlHttpRequest){
	xmlHttp=new XmlHttpRequest();
}else if(window.ActiveObject){
	xmlHttp=new ActiveObject("Microsoft.XmlHttp");
}
}
function checkName(uname){
	createXmlHttpRequest();
	xmlHttp.onreadystatechange=handleStateChange(); //设定callback函式
    xmlHttp.open("GET","doCheckUname.jsp?uname="+uname); //开启连接
    xmlHttp.send(null);//传送请求
}
function handleStateChange(){
	alert("连接状态码:"+xmlHttp.readyState);
	if(xmlHttp.readyState==4){//测试状态是否请求完成
		if(xmlHttp.status==200){//如果服务端回应ok
			alert("服务器回应:"+xmlHttp.responseText);//这边只取得回应文字
		}
	}
}