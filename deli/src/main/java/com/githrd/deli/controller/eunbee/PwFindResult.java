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
 * @author 안은비
 *
 */

public class PwFindResult implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/pwFindResult";
		
		String mail = req.getParameter("fmail");
		String id = req.getParameter("fid");
		String npw = req.getParameter("randomPassword");
		
		EunbeeDao eDao = new EunbeeDao();
		String fmail = eDao.getMail(id, mail);
		
		req.setAttribute("FMAIL", fmail);
		
		return view;
		
	}

}
