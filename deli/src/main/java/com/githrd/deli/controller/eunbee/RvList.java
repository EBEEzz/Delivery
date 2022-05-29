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
 * 공동구매 참여 내역 리스트
 * @author	안은비
 * @since	2022.05.28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class RvList implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/review/rvList";
		if(req.getSession().getAttribute("SID") == null) {
			req.setAttribute("isRedirect", true);
			view = "/deli/member/login.dlv";
		}
		
		EunbeeDao eDao = new EunbeeDao();
		
		String ida = (String)req.getSession().getAttribute("SID");
		ArrayList<EunbeeVO> list = eDao.getAbInfo(ida);
		
		req.setAttribute("RLIST", list);
		
		return view;
	}

}
