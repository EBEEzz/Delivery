package com.githrd.deli.controller.pcs;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;

public class DeliLoginProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("isRedirect", true);
	String view = "/deli/main.dlv";
	if(req.getSession().getAttribute("SID") != null) {
		return view;
	}
	
	String id = req.getParameter("id");
	String pw = req.getParameter("pw");
	PcsDao mDao = new PcsDao();
	int cnt = mDao.getLogin(id, pw);
	if(cnt == 1) {
		req.getSession().setAttribute("SID", id);
	} else {
		view = "/deli/member/login.dlv";
	}
	
	return view;
}

}