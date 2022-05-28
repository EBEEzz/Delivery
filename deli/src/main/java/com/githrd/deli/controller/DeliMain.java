package com.githrd.deli.controller;


/**
 * @author	이용현
 * @since	2022/05/24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : 이용현
 */

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
