package com.accp.springmvc.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 *                 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/WSHello")
public class WebSocketTest {

	Session session;
	String user;

	public static Map<String, WebSocketTest> map = new HashMap<String, WebSocketTest>();

	/*
	 * public WebSocketTest() { System.out.println("111111111111111"); }
	 */

	/**
	 * 接受和返回值
	 * 
	 * @param message
	 * @param session
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {
		JSONObject json = JSON.parseObject(message);
		/**
		 * 发送信息
		 */
		if (map.get(json.get("user")) != null && map.get(json.get("user")).session != null) {
			map.get(json.get("user")).session.getBasicRemote().sendText(JSON.toJSONString(json));
		}
	}

	@OnOpen
	public void onOpen(@PathParam("user") String user, Session session) {
		this.session = session;
		this.user = user;
		map.put(user, this);
	}

	@OnClose
	public void onClose() {
		map.remove(this.user);
	}

	@OnError
	public void error(Session session, Throwable t) {
		System.out.println("发生错误，请注意");
		t.printStackTrace();
	}
}
