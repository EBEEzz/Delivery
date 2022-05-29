package com.githrd.deli.controller.eunbee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.EunbeeDao;
import com.githrd.deli.vo.EunbeeVO;

/**
 * 새로운 추천도와 기존 추천도를 평균내서 추천도 업데이트
 * @author	안은비
 * @since	2022.05.28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class EstiProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/deli/review/rvWrite.dlv";
		
		if(req.getSession().getAttribute("SID") == null) {
			view = "/deli/member/login.dlv";
		}
		
		String ida = (String)req.getSession().getAttribute("SID");
		String idb = (String)req.getSession().getAttribute("EID");
		String abno = (String)req.getSession().getAttribute("ABNO");
		int bno = Integer.parseInt(abno);
		
		EunbeeDao eDao = new EunbeeDao();
		EunbeeVO eVO = eDao.getNewEsti(idb);
		
		double spts = eVO.getSpts();
		int cpts = eVO.getCpts();
		
		double esti = (2.5 + spts) / (1 + cpts);
		
		int cnt = eDao.updateEsti(esti, idb);
		int cnt2 = eDao.updateEshow(bno, idb);
		
		if(cnt != 1) {
			view = "/deli/review/rvList.dlv";
		}
		if(cnt2 != 1) {
			view = "/deli/review/rvList.dlv";
		}
		
		
		return view;
	}

}
