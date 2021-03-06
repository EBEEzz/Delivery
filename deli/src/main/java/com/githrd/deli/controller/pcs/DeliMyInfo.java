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
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;

public class DeliMyInfo implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		String view = "/member/myInfo";
		
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view="/deli/member/login.dlv";
			return view;
		}
		
			
		PcsDao mDao = new PcsDao();
		PcsVO pVO = mDao.getIdInfo(sid);
		
		req.setAttribute("DATA", pVO);

		return view;
	}

	
}
