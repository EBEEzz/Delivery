package com.githrd.deli.controller.pcs;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.util.*;
import com.githrd.deli.vo.*;
import com.oreilly.servlet.*;

public class DeliJoinProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isredirect", true);
		String view = "/member/login.dlv";
		
		FileUtil futil = new FileUtil(req, "/resources/upload");
		MultipartRequest multi = futil.getMulti();
		
		FileVO fVO = futil.getList().get(0);
		PcsVO pVO = new PcsVO();
		// 파라미터 받고
		String name = multi.getParameter("name");
		String id = multi.getParameter("id");
		String kakaoid = multi.getParameter("kakaoid");
		String pw = multi.getParameter("pw");
		String mail = multi.getParameter("mail");
		String tel = multi.getParameter("tel");
		String addr = multi.getParameter("addr");
		// vo에 담고
		pVO.setName(name);
		pVO.setId(id);
		pVO.setKakaoid(kakaoid);
		pVO.setPw(pw);
		pVO.setMail(mail);
		pVO.setTel(tel);
		pVO.setAddr(addr);
		
		PcsDao pDao = new PcsDao();
		int cnt = pDao.addMember(pVO);
		// 결과값에 따라 처리하고
		if(cnt != 1) {
			view = "/deli/member/join.dlv";
		} else {
			String oriname = multi.getParameter("oriname");
			String dir = "/resources/pic";
			String savename = multi.getParameter("savename");
			
			fVO.setId(id);
			fVO.setOriname(oriname);
			fVO.setDir(dir);
			fVO.setSavename(savename);
			
			int pcnt = pDao.addProfile(fVO);
			
			if(pcnt == 0) {
				oriname = "noimage.jpg";
				dir = "/img/avatar/";
				savename = "noimage.jpg";
			}
			// 로그인 처리
			req.getSession().setAttribute("SID", id);
		}
		
		return view;
	}

	
}
