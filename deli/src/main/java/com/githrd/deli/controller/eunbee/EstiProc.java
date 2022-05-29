package com.githrd.deli.controller.eunbee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.EunbeeDao;
import com.githrd.deli.vo.EunbeeVO;

public class EstiProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/deli/main.dlv";
		
		if(req.getSession().getAttribute("SID") == null) {
			view = "/deli/member/login.dlv";
		}
		
		String ida = (String)req.getSession().getAttribute("SID");
		String idb = (String)req.getSession().getAttribute("EID");
		int abno = (Integer)req.getSession().getAttribute("ABNO");
		
		EunbeeDao eDao = new EunbeeDao();
		EunbeeVO eVO = eDao.getNewEsti(idb);
		
		double spts = eVO.getSpts();
		int cpts = eVO.getCpts();
		
		double esti = (2.5 + spts) / (1 + cpts);
		
		int cnt = eDao.updateEsti(esti, idb);
		
		if(cnt != 1) {
			view = "/deli/review/rvWrite.dlv";
		} else if(cnt == 1) {
			int cnt2 = eDao.updateEshow(abno, idb);
			if(cnt2 != 1) {
				view = "/deli/review/rvWrite.dlv";
			}
		}
		
		return view;
	}

}
