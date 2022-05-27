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
