/**
 * @author	박찬슬
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 박찬슬
 */
package com.githrd.deli.controller.pcs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;

public class DeliLogin implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/login";
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("isRedirect", true);
			view = "/deli/main.dlv";
		}

		return view;
	}

	
}
