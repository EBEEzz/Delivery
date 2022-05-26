package com.githrd.deli.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;

public class applyProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("SID");
		String view = "/board/redirect";
		/*
		if( id == null) {
			
			return view;
		}
		*/
		String no = req.getParameter("bno");
		int bno = Integer.parseInt(no);
		
		String spage = req.getParameter("nowPage");
		int nowPage = Integer.parseInt(spage);
		
		String city = req.getParameter("city");
		String search = req.getParameter("search");
		String check = req.getParameter("check");
		
		req.setAttribute("VIEW", "/deli/boardForm.dlv");
		req.setAttribute("NOWPAGE", nowPage);
		req.setAttribute("BNO", bno);
		
		if(city != null) {
			req.setAttribute("CITY", city);
		}
		if(search != null) {
			req.setAttribute("SEARCH", search);
		}
		if(check != null) {
			req.setAttribute("CHECK", check);
		}
		YonghyunDao yDao = new YonghyunDao();
		int cnt = yDao.getRegiCount(id, bno);
		if(cnt != 1) {
			int regi = yDao.UpRegi(bno, id);
			if(regi == 1) {
				req.setAttribute("RESULT", 0);

			} else {
				req.setAttribute("RESULT", 2);
				
			}
		} else {
			req.setAttribute("RESULT", 1);

		}
		
		return view;
	}

}
