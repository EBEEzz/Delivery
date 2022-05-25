package com.githrd.deli.controller.board;

/**
 * @author	이용현
 * @since	2022/05/24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : 이용현
 */

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.YonghyunDao;
import com.githrd.deli.util.PageUtil;
import com.githrd.deli.vo.YonghyunVO;

public class BoardList implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		
		String view = "/board/boardList";


		String scity = req.getParameter("city");
		String check = req.getParameter("check");
		String search = req.getParameter("search");
		System.out.println(search);
		String city = "";
		switch(scity) {
		case "seoul" :
			city = "서울특별시";
			break;
		case "gyeonggi" :
			city = "경기도";
			break;
		case "gangwon" :
			city = "강원도";
			break;
		case "chungcheong" :
			city = "충청도";
			break;
		case "gyeongsang" :
			city = "경상도";
			break;
		case "jeolla" :
			city = "전라도";
			break;
		case "jeju" :
			city = "제주도";
			break;
		}
		int nowPage = 1;
		String spage = req.getParameter("nowPage");
		
		if(spage != null) {
			nowPage = Integer.parseInt(spage);
		}
		YonghyunDao yDao = new YonghyunDao();
		
		if(check == null) {
	

			int total = yDao.getTotalCount(city);
			
			PageUtil page = new PageUtil(nowPage, total);
			
			ArrayList<YonghyunVO> list = yDao.getBoardList(city, page);
	
			
			req.setAttribute("LIST", list);
			req.setAttribute("PAGE", page);
			req.setAttribute("CITY", scity);
			
		} else if(check.equals("title") || search != null) {
			int total = yDao.getTitleCount(city, search);
			
			PageUtil page = new PageUtil(nowPage, total);
			
			ArrayList<YonghyunVO> list = yDao.getBoardTitle(city, search, page);
			
			req.setAttribute("LIST", list);
			req.setAttribute("PAGE", page);
			req.setAttribute("CITY", scity);
			
		}
		
		
		return view;
	}

}
