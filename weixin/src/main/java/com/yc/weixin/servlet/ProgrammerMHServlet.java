package com.yc.weixin.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProgrammerMH.do")
public class ProgrammerMHServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 ServletOutputStream out= resp.getOutputStream();
		 out.write("<Script>alert('Sorry Get!');</Script>".getBytes());
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
		 ServletOutputStream out= resp.getOutputStream();
		 
		  String clientCode= req.getParameter("code");
		  if(clientCode.equalsIgnoreCase((String) req.getSession().getAttribute("code"))) {
			  resp.sendRedirect("./back/zzyProgrammerMH.jsp");
		  }else {
			  out.write("<Script>alert('Sorry Code Error!');</Script>".getBytes());
			  req.getRequestDispatcher("./ProgrammerMH.jsp").forward(req, resp);
		  }
		 
	}
    public boolean checkUserName(String uName,String uPassword) {
		return false;
		
    	
    }

}
