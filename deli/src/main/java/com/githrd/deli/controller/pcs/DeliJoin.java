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

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;

public class DeliJoin implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/join";
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid != null) {
			req.setAttribute("isRedirect", true);
			return "/deli/main.dlv";
		}
		return view;
	}

	
}
