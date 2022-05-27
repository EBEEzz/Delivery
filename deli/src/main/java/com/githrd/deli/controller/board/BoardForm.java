package com.githrd.deli.controller.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;
import com.githrd.deli.vo.YonghyunVO;

public class BoardForm implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/boardForm";
		String id = (String) req.getSession().getAttribute("SID");

		
		String no = req.getParameter("bno");
		int bno = Integer.parseInt(no);
		String result = req.getParameter("result");


		YonghyunDao yDao = new YonghyunDao();
		
		if(result == null) {
			int cnt = yDao.UpClick(bno);
			if(cnt != 1) {
				System.out.println("조회수 업데이트 실패");
			}
		}

		ArrayList<YonghyunVO> list = yDao.getRegiMember(bno);
		
		for(YonghyunVO i : list) {
			if(id.equals(i.getId())) {
				req.setAttribute("PAY", i.getId());
			}
		}
		
		ArrayList<YonghyunVO> menu = yDao.getMenu(bno);
		
		req.setAttribute("MEMBER", list);
		req.setAttribute("MENU", menu);
		req.setAttribute("RESULT", result);
		YonghyunVO yVO = yDao.getBoardForm(bno);
		req.setAttribute("MAIN", yVO);

		return view;
	} 

}
