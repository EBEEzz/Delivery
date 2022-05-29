package com.githrd.deli.controller.board;


/**
 * @author	이용현
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 이용현
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;

public class MessageProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/deli/message.dlv";
		String id = (String) req.getSession().getAttribute("SID");
		String fid = req.getParameter("fid");
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		YonghyunDao yDao = new YonghyunDao();
		int cnt = yDao.UpMessage(id, fid, title, body);
		if(cnt != 1) {
			req.setAttribute("SENDTEST", 1);
			return "/deli/msform.dlv";
		}
		return view;
	}

}
