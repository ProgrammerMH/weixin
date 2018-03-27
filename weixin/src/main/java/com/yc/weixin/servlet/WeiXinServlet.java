package com.yc.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import com.yc.weixin.util.*;
import com.yc.weixin.util.CheckUtil;
import com.yc.weixin.util.MessageUtil;
import com.yc.wexin.bean.TextMessage;

@WebServlet("/wx.do")
/**
 * 
 * @author Administrator
 *
 */
public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		System.out.println(timestamp);
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("来啊");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {

			Map<String, String> map = MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			String message = null;
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				if ("1".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.booksMenuText());
				} else if ("2".equals(content)) {
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
				} else if ("3".equals(content)) {
					message = MessageUtil.initImageMessage(toUserName, fromUserName);
				} else if ("4".equals(content)) {
					message = MessageUtil.initMusicMessage(toUserName, fromUserName);
				} else if ("?".equals(content) || "？".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}

			} else if (MessageUtil.MESSAGE_EVENT.equals(msgType)) {
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_CLICK.equalsIgnoreCase(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
					System.out.println("进来弄");
				} else if (MessageUtil.MESSAGE_VIEW.equalsIgnoreCase(eventType)) {
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
				} else if (MessageUtil.MESSAGE_SCANCODE.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}
			} else if (MessageUtil.MESSAGE_LOCATION.equals(msgType)) {
				String label = map.get("Label");
			}
			out.print(message);
		} catch (DocumentException e) {

			e.printStackTrace();
		} finally {
			out.close();
		}

	}

}
