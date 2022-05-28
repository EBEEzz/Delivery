package com.githrd.deli.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;

public class FriendCanProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		String id = (String) req.getSession().getAttribute("SID");

		YonghyunDao yDao = new YonghyunDao();
		String frimno = req.getParameter("fmno");
		int fmno = Integer.parseInt(frimno);

		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\" : \"");


		int cancle = yDao.getFriendCancle(id, fmno);
		
		if(cancle == 1) {
			buff.append("OK");
		} else {
			buff.append("NO");
		}
		
		buff.append("\" }");

		return buff.toString();
	}

}
