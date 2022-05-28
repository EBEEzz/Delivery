package com.githrd.deli.controller.pay;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.PayDao;
import com.githrd.deli.dao.YonghyunDao;
import com.githrd.deli.vo.PayVO;
import com.githrd.deli.vo.YonghyunVO;
/**
 * 
 * @author 이형준
 * @since  2022.05.24
 * @version  v.1.0
 * 		
 * 					작업이력 )
 * 						2022.05.24	-	담당자 : 이형준
 * 										내용   : 클래스 제작
 */
public class BeforePay implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/payment/beforePay";
		
		
		String no = req.getParameter("bno");
		int bno = Integer.parseInt(no);
		
	
		
		String sid = (String)req.getSession().getAttribute("SID");
		
		if(sid == null) {
			return "/member/login";
		}
		
		YonghyunDao yDao = new YonghyunDao();
		PayDao pDao = new PayDao();
		
		PayVO pVO = pDao.getPay(bno);
		PayVO pVO1 = pDao.getMINFO(sid);
		
		String amname = (String)req.getParameter("1mname");
		
		String tmyprice = (String) req.getParameter("1price");
		int myprice = Integer.parseInt(tmyprice);		
		
		System.out.println(amname);
		 
		int cnt = pDao.getAbnoCnt(bno);
		
		pVO.setMyprice(myprice);
		pVO.setBno(bno);
	
		
		System.out.println(pVO);
		
		int dlp = (pVO.getDelpay() != 0) ? (pVO.getDelpay()/cnt) : 0;
		
		int mtprice = pVO.getMyprice() - dlp;
		
		pVO.setMtprice(mtprice);
		pVO.setAmname(amname);
		
		
		
		ArrayList<YonghyunVO> list = yDao.getRegiMember(bno);
		
		ArrayList<YonghyunVO> menu = yDao.getMenu(bno);
		
		req.setAttribute("MEMBER", list);
		req.setAttribute("MENU", menu);
		req.setAttribute("PO", pVO);
		req.setAttribute("MPO", pVO1);
		return view;
	}

}
