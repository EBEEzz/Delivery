package com.githrd.deli.controller.eunbee;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

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
		
		ArrayList<EunbeeVO> list = eDao.getAbInfo(ida);
		
		int abno = (Integer)req.getSession().getAttribute("ABNO");
		
		String idb = req.getParameter("idb");
		if(idb != null) {
			req.getSession().setAttribute("EID", idb);
		}
		
		String nesti = req.getParameter("nesti");
		int pts = Integer.parseInt(nesti);
		
		EunbeeVO eVO = new EunbeeVO();
		eVO.setBno(abno);
		eVO.setId(ida);
		eVO.setIdb(idb);
		eVO.setPoint(pts);
		
		int cnt = eDao.addEsti(eVO);
		
		if(cnt != 1) {
			view = "/deli/review/rvWrite.dlv";
		}
		
		return view;
	}

}
