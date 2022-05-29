package com.githrd.deli.controller.board;


/**
 * @author	이용현
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 이용현
 */

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
