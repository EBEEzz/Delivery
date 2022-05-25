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


@ServerEndpoint("/deliChat")
public class Chat {

	private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	@OnOpen
	public void handleOpen(Session userSession) {
	// 클라이언트가 접속하면 WebSocket세션을 리스트에 저장한다.
		sessionUsers.add(userSession);
// 콘솔에 접속 로그를 출력한다.
		System.out.println("client is now connected...");
	}
// WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public void handleMessage(String message, Session userSession) throws Exception {
		System.out.println(message);
		String name = "anonymous";
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
		session.getBasicRemote().sendText(username + " => " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
			});
	}

	@OnClose
	public void handleClose(Session userSession) {
	sessionUsers.remove(userSession);
	System.out.println("client is now disconnected...");
	}
}

