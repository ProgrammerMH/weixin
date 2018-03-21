package com.yc.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.weixin.util.CheckUtil;

@WebServlet("/wx.do")
/**
 * 
 * @author Administrator
 *
 */
public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String signature=request.getParameter("signature");
	String timestamp=request.getParameter("timestamp");
	String nonce=request.getParameter("nonce");
	String echostr=request.getParameter("echostr");
	PrintWriter out=response.getWriter();
	System.out.println(timestamp);
	if(CheckUtil.checkSignature(signature, timestamp, nonce)) {
		out.print(echostr);
	}
	}

}
