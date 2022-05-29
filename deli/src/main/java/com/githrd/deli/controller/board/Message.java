package com.githrd.deli.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;
import com.githrd.deli.vo.YonghyunVO;

public class Message implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/message";
		String id = (String) req.getSession().getAttribute("SID");
		YonghyunDao yDao = new YonghyunDao();
		ArrayList<YonghyunVO> list = yDao.getMessage(id);
		req.setAttribute("MESSAGE", list);
		return view;
	}

}
