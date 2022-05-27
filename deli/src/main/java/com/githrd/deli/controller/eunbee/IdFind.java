package com.githrd.deli.controller.eunbee;

import java.io.*;

/**
 * 아이디 찾기 페이지 보기 요청을 처리
 * @author 	AnEunbee
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력)
 * 				2022.05.24	-	담당자 : 안은비
 * 								내용 : 클래스 제작
 */

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

/**
 * 아이디 찾기 페이지 열기
 * @author	안은비
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class IdFind implements DeliInter {
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/idFind";
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("isRedirect", true);
			view = "/deli/main.dlv";
		}
		
		return view;
	}

}
