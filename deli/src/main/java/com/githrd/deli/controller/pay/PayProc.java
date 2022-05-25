package com.githrd.deli.controller.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;

public class InsertInfo implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/payment/afterPay";
		req.setAttribute("isRedirect", true);
		/*
		// String sid = req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/member/login.dlv";
		}
		*/
		
		
		return view;
	}

}
