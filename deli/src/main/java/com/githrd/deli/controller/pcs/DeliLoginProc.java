/**
 * @author	박찬슬
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 박찬슬
 */
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
	
	String spage = req.getParameter("nowPage");
	
	int cnt = mDao.getLogin(id, pw);
	if(cnt == 1) {
		req.getSession().setAttribute("SID", id);
	} else {
		req.setAttribute("isRedirect", false);
		req.setAttribute("FAIL", 1);
		
		view = "/member/login";
	}
	
	
	return view;
}

	
}