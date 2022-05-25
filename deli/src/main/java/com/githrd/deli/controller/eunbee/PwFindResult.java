package com.githrd.deli.controller.eunbee;

import java.io.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;

/**
 * 임시비밀번호를 메일로 전송하는 클래스
 * @author	안은비
 * @since	2022.05.25
 * @version	v.1.0
 *
 */

public class PwFindResult implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/pwFindResult";
		
		String mail = req.getParameter("fmail");
		String id = req.getParameter("fid");
		String npw = req.getParameter("randomPw");
		
		EunbeeDao eDao = new EunbeeDao();
		String fmail = eDao.getMail(id, mail);
		
		req.setAttribute("FMAIL", fmail);
		
		
		if(fmail != null) {
			int cnt = eDao.editPw(npw, id);
			
			String host = "smtp.naver.com"; 
			String user = "320aeb@naver.com";	// 네이버 계정
			String password = "xlswmdhsxkq0710";	// 네이버 패스워드
			
			// SMTP 서버 정보를 설정한다.
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");
			
			
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(fmail));
				
				// 메일 제목
				message.setSubject("Delivery Project에서 임시비밀번호를 알려드립니다!");
				
				// 메일 내용
				message.setText("회원님의 임시비밀번호는 " + npw + " 입니다.");
				
				// send the message
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		return view;
	}
}
