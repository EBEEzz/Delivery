package com.githrd.deli.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;

public class FriendAgrProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		String id = (String) req.getSession().getAttribute("SID");
		
		String frimno = req.getParameter("fmno");
		int fmno = Integer.parseInt(frimno);
	
		YonghyunDao yDao = new YonghyunDao();

		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\" : \"");

		int agree = yDao.UpFriendAgree(fmno, id);
		int update = yDao.UpFriendToo(id, fmno);
	
		if(agree == 1 && update == 1) {
			buff.append("OK");
		} else {
			buff.append("NO");
		}
		
		buff.append("\" }");

		System.out.println(buff.toString());		
		return buff.toString();
	}

}
