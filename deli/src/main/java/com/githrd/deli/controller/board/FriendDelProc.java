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

public class FriendDelProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		String id = (String) req.getSession().getAttribute("SID");

		YonghyunDao yDao = new YonghyunDao();
		String frimno = req.getParameter("fmno");
		int fmno = Integer.parseInt(frimno);

		StringBuffer buff = new StringBuffer();
		buff.append("{ \"result\" : \"");

		int delck = yDao.getDelFriendCheck(id, fmno);
		
		
		
		if(delck == 1) { // 삭제가능
			int cnt = yDao.DelFriend(id, fmno);
			if(cnt == 1) {
				buff.append("OK");
			} else {
				buff.append("NO");
			}
		} else {
			buff.append("AL");
		}
		
		buff.append("\" }");

		return buff.toString();
	}

}
