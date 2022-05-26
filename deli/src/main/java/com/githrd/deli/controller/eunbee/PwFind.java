package com.githrd.deli.controller.eunbee;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;

/**
 * 비밀번호 찾기 페이지 열기
 * @author	안은비
 * @since	2022.05.25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class PwFind implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/pwFind";
		
		return view;
	}

}
