package com.githrd.deli.controller.eunbee;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

/**
 * 후기에 작성한 추천도 데이터 넘기기
 * @author	안은비
 * @since	2022.05.28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class RvWriteProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/deli/review/estiProc.dlv";
		
		if(req.getSession().getAttribute("SID") == null) {
			view = "/deli/member/login.dlv";
		}
		
		String ida = (String)req.getSession().getAttribute("SID");
		
		EunbeeDao eDao = new EunbeeDao();
		
		String abno = req.getParameter("abno");
		if(abno != null) {
			req.getSession().setAttribute("ABNO", abno);
		}
		int bno = Integer.parseInt(abno);
		
		String idb = req.getParameter("idb");
		if(idb != null) {
			req.getSession().setAttribute("EID", idb);
		}
		
		String nesti = req.getParameter("nesti");
		int pts = Integer.parseInt(nesti);
		
		EunbeeVO eVO = new EunbeeVO();
		eVO.setBno(bno);
		eVO.setId(ida);
		eVO.setIdb(idb);
		eVO.setPoint(pts);
		
		int cnt = eDao.addEsti(eVO);
		
		if(cnt != 1) {
			view = "/deli/review/rvList.dlv";
		}
		
		return view;
	}

}
