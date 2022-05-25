package com.githrd.deli.controller.board;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/main.dlv")
public class Chat {

	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	@OnOpen
	public void handleOpen(Session userSession) {
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
	public void handleClose(Session userSession) {
	sessionUsers.remove(userSession);
	System.out.println("## 접속해제");
	}
}

