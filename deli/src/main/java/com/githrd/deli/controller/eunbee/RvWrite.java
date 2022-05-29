package com.githrd.deli.controller.eunbee;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

/**
 * 후기 작성 페이지
 * @author	안은비
 * @since	2022.05.26
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 				2022.05.27	-	함께공구한사람불러오기
 * 									담당자 ] 안은비
 *
 */

public class RvWrite implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/review/rvWrite";
		if(req.getSession().getAttribute("SID") == null) {
			req.setAttribute("isRedirect", true);
			view = "/deli/member/login.dlv";
		}
		
		String id = (String)req.getSession().getAttribute("SID");
		
		EunbeeDao eDao = new EunbeeDao();
		ArrayList<EunbeeVO> rlist = eDao.getAbInfo(id);
		
		String ridb = req.getParameter("ridb");
		
		if(ridb != null) {
			int bno = Integer.parseInt(ridb);
			ArrayList<EunbeeVO> list = eDao.getAid(bno, id);
			req.setAttribute("LLIST", list);
		} else {
			String abno = (String)req.getSession().getAttribute("ABNO");
			int bno = Integer.parseInt(abno);
			ArrayList<EunbeeVO> list = eDao.getAid(bno, id);
			req.setAttribute("LLIST", list);
		}
		
		return view;
	}

}
