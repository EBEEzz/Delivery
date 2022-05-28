package com.githrd.deli.controller.pcs;

import java.io.*;
import java.util.* ;

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
		
		String smno = multi.getParameter("mno");
		int mno = Integer.parseInt(smno);
		String id = multi.getParameter("id");
		String pw = multi.getParameter("newpw");
		String mail = multi.getParameter("newmail");
		String tel = multi.getParameter("newtel");
		String addr = multi.getParameter("newaddr");
		StringBuffer buff = new StringBuffer();
		
		if(pw != null && !pw.isEmpty()) {
			buff.append(" , pw = '" + pw + "' ");
		}
		
		if(mail != null ) {
			buff.append(" , mail = '" + mail + "' ");
		}
		
		if(tel != null) {
			buff.append(" , tel = '" + tel + "' ");
		}
		
		if(addr != null) {
			buff.append(" , addr = '" + addr + "' ");
		}

		PcsDao pDao = new PcsDao();
		int cnt = 0;
		if((buff.toString() != null) && (!buff.toString().isEmpty())) {
		String esql  = buff.toString().substring(3);
		
		cnt = pDao.editMyInfo(mno, esql);
		}
		
		int pcnt = 0;
		if (futil.getList().size() != 0) {
			FileVO fVO = futil.getList().get(0);
			
			String oriname = fVO.getOriname();
			String savename = fVO.getSavename();
			
			StringBuffer fbuff = new StringBuffer();
			
			if(oriname != null) {
				fbuff.append(" , oriname = '" + oriname + "' ");
			}
			if(savename != null) {
				fbuff.append(" , savename = '" + savename + "' ");
			}
			String fsql = fbuff.toString().substring(3);
			fVO.setId(id);
			pcnt = pDao.editProFile(id, fsql);
		}
		
		
		// 결과에 따라 처리하고
		if(cnt != 1 && pcnt != 1) {
			// 실패한 경우
			view = "/deli/member/editInfo.dlv";
		}
		return view;
	}

}
