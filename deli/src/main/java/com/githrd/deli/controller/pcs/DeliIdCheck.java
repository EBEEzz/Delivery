package com.githrd.deli.controller.pcs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.PcsDao;

public class DeliIdCheck implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		String id = req.getParameter("id");
		PcsDao pDao = new PcsDao();
		
		int cnt = pDao.getIdCount(id);
		buff.append("{");
		buff.append("\"result\" : \"");
		if(cnt == 0) {
			// 사용가능한 아이디인 경우
			buff.append("OK");
		} else {
			// 사용불가능한 아이디인 경우
			buff.append("NO");
		}
		buff.append("\"");
		buff.append("}");
		
		return buff.toString();
	}

	
}
