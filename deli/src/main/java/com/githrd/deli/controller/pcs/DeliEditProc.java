package com.githrd.deli.controller.pcs;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.util.*;
import com.githrd.deli.dao.*;
import com.githrd.deli.vo.*;
import com.oreilly.servlet.*;

public class DeliEditProc implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/deli/member/myInfo.dlv";
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			// 로그인이 안된경우
			return "/deli/member/login.dlv";
		}
		FileUtil futil = new FileUtil(req, "/resources/upload");
		MultipartRequest multi = futil.getMulti();
		FileVO fVO = futil.getList().get(0);
		
		String smno = multi.getParameter("mno");
		int mno = Integer.parseInt(smno);
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String mail = multi.getParameter("mail");
		String tel = multi.getParameter("tel");
		String addr = multi.getParameter("addr");
		
		StringBuffer buff = new StringBuffer();
		
		if(pw != null) {
			buff.append(" , pw = '" + pw + "' ");
		}
		
		if(mail != null) {
			buff.append(" , mail = '" + mail + "' ");
		}
		
		if(tel != null) {
			buff.append(" , tel = '" + tel + "' ");
		}
		
		if(addr != null) {
			buff.append(" , addr = '" + addr + "' ");
		}
		
		String psql  = buff.toString().substring(3);
		
		PcsDao pDao = new PcsDao();
		int cnt = pDao.editMyInfo(mno, psql);
		
		String oriname = multi.getParameter("oriname");
		String savename = multi.getParameter("savename");
		
		StringBuffer fbuff = new StringBuffer();
		
		if(oriname != null) {
			fbuff.append(" , oriname = '" + oriname + "' ");
		}
		if(savename != null) {
			fbuff.append(" , savename = '" + savename + "' ");
		}
		
		String fsql = fbuff.toString().substring(3);
		fVO.setId(id);
		int pcnt = pDao.editProFile(id, fsql);
		
		// 결과에 따라 처리하고
		if(cnt != 1 && pcnt != 1) {
			// 실패한 경우
			view = "/deli/member/editInfo.dlv";
		}
		return view;
	}

}
