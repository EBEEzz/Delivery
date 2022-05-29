package com.githrd.deli.controller.eunbee;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

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
		int abno = Integer.parseInt(ridb);
		
		req.getSession().setAttribute("ABNO", abno);
		
		
		EunbeeVO eVO = new EunbeeVO();
		ArrayList<EunbeeVO> list = eDao.getAid(id, abno);
		req.setAttribute("LLIST", list);
		
		/*
		ArrayList<EunbeeVO> reglist = eDao.getRegmem(abno);
		for(int i = 0; i < reglist.size(); i++) {
			String eidb = reglist.get(i).getId();
			
			eVO.setBno(abno);
			eVO.setId(id);
			eVO.setIdb(eidb);
			int cnt = eDao.addEstiInfo(eVO);
			if(cnt != 1) {
				view = "/review/rvList";
			}
			
		}*/
		
		
		return view;
	}

}
