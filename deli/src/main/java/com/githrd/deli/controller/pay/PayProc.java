package com.githrd.deli.controller.pay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.PayDao;
import com.githrd.deli.vo.PayVO;

public class PayProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/payment/afterPay";
		req.setAttribute("isRedirect", null);
		
		/*
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/member/login.dlv";
		}
		*/
		
		String arno = (String) req.getParameter("r_rno");
		int rno = Integer.parseInt(arno);
		String ono = (String) req.getParameter("ono");
		String aoprice = (String) req.getParameter("oprice");
		int oprice = Integer.parseInt(aoprice);
		String aomprice = (String) req.getParameter("ompirce");
		int omprice = Integer.parseInt(aomprice);
		String paym = (String) req.getParameter("paym");
		String amno = (String) req.getParameter("m_mno");
		int mno = Integer.parseInt(amno);
		String aqt = (String) req.getParameter("quantity");
		int quantity = Integer.parseInt(aqt);
		String request = (String) req.getParameter("request");
		String omenu = (String) req.getParameter("omenu");
		
		PayDao pDao = new PayDao();
		
		PayVO pVO = new PayVO();
		pVO.setRno(rno);
		pVO.setOno(ono);
		pVO.setOprice(oprice);
		pVO.setOmprice(omprice);
		pVO.setPaym(paym);
		pVO.setMno(mno);
		pVO.setQuantity(quantity);
		pVO.setRequest(request);
		pVO.setOmenu(omenu);
		pVO.setOlno(mno);
		
		
		int odtcnt = pDao.InsertOdt(ono, mno);
		
		int odlcnt = pDao.InsertOdl(pVO);
		
		
		int odmcnt = pDao.InsertOdm(pVO);
		
		String msg = "{\"result\" : \"y\"}";
		if(odtcnt != 1) {
			System.out.println("ordertask에 문제가 생겼습니다.");
			return "/payment/beforePay";
		} else if(odlcnt != 1) {
			System.out.println("orderlist에 문제가 생겼습니다.");
			return "/payment/afterPay.dlv";
		} else if(odmcnt != 1) {
			System.out.println("ordermenu에 문제가 생겼습니다.");
			return "/payment/beforePay";
		} else {
			req.setAttribute("isRedirect", null);
			msg = "{\"result\" : \"y\"}";
		}
		
		
		return msg;
	}

}