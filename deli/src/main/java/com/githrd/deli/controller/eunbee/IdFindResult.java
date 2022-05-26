package com.githrd.deli.controller.eunbee;

import java.io.IOException;

/**
 * 아이디 찾기 결과 요청
 * @author	안은비
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;

public class IdFindResult implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/idFindResult";
		String mail = req.getParameter("fmail");
		
		EunbeeDao eDao = new EunbeeDao();
		String fid = eDao.getId(mail);
		
		req.setAttribute("FID", fid);
		return view;
	}
}
