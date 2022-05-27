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
/*로그인 후 해당 페이지로 돌아오게 수정 필요 **********/
		if( id == null) {
			req.setAttribute("isRedirect", true);
			return "/deli/member/login.dlv";
		}

		
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
		
		
		String cancle = req.getParameter("cancle");

		if(cancle == "") {

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
		} else if(cancle.equals("cancle")) {
			int cnt = yDao.getRegiCount(id, bno);

			if(cnt == 1) {
				// 취소 가능
				int cancleregi = yDao.DelRegi(bno, id);

				if(cancleregi == 1) {
					// 취소 성공
					req.setAttribute("CANCLERESULT", 0);

				} else {
					// 취소 실패
					req.setAttribute("CANCLERESULT", 2);
			
				}
			} else {
				// 신청자가 아니라 접수 불가능
				req.setAttribute("CANCLERESULT", 1);

			}
		}
		return view;
	}

}
