package com.githrd.deli.controller.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

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
		String no = req.getParameter("bno");
		int bno = Integer.parseInt(no);

		YonghyunDao yDao = new YonghyunDao();
		int cnt = yDao.UpClick(bno);
		YonghyunVO yVO = yDao.getBoardForm(bno);
		if(cnt != 1) {
			System.out.println("조회수 업데이트 실패");
		}
		req.setAttribute("MAIN", yVO);
		return view;
	} 

}
