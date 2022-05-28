package com.githrd.deli.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.dao.YonghyunDao;
import com.githrd.deli.vo.YonghyunVO;

public class DeliMain implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view ="/main";
		String id = (String) req.getSession().getAttribute("SID");
		
		
		YonghyunDao yDao = new YonghyunDao();
		ArrayList<YonghyunVO> list = yDao.getHotClick();
		req.setAttribute("HOT", list);
		
		ArrayList<YonghyunVO> friend = yDao.getFriend(id);
		req.setAttribute("FRIEND", friend);

		ArrayList<YonghyunVO> apply = yDao.getFriendApply(id);
		req.setAttribute("APPLY", apply);
		
		
		return view;
	}

}
