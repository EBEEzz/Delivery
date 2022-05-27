package com.githrd.deli.controller.board;

import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.regex.*;
import javax.websocket.*;
import java.util.*;

@ServerEndpoint("/main.dlv")
public class Chat {

	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	@OnOpen
	public void ChatStart(Session userSession) {
		sessionUsers.add(userSession);
		System.out.println("## 접속중");
	}

	@OnMessage
	public void handleMessage(String message, Session userSession) throws Exception {
		System.out.println(message);
		String name = "";
		Matcher matcher = pattern.matcher(message);
		if (matcher.find()) {
			name = matcher.group();
		}
		final String msg = message.replaceAll(pattern.pattern(), "");
		final String username = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");
		sessionUsers.forEach(session -> {
		if (session == userSession) {
			return;
		}
		try {
		session.getBasicRemote().sendText(username + " : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
			});
	}

	@OnClose
	public void ChatEnd(Session userSession) {
	sessionUsers.remove(userSession);
	System.out.println("## 접속해제");
	}
}

