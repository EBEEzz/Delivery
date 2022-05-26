package com.githrd.deli.controller.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.PayDao;
/**
 * 
 * @author 이형준
 * @since  2022.05.24
 * @version  v.1.0
 * 		
 * 					작업이력 )
 * 						2022.05.24	-	담당자 : 이형준
 * 										내용   : 클래스 제작
 */
public class BeforePay implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/payment/beforePay";
		/*
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/member/login";
		}
		*/
		
		
		
		return view;
	}

}
