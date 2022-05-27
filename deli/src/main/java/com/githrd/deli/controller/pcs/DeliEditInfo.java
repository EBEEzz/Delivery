package com.githrd.deli.controller.pcs;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

public class DeliEditInfo implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/editInfo";
		// 로그인 체크
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			view = "/deli/member/login.dlv";
			req.setAttribute("isRedirect", true);
			return view;
		}
		
		// 데이터베이스에서 내정보 꺼내오고
		PcsDao pDao = new PcsDao();
		PcsVO pVO = pDao.getIdInfo(sid);
		
		// 데이터를 심고
		req.setAttribute("DATA", pVO);
		return view;
	}

}
