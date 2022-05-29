package com.githrd.deli.controller.haneul;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.controller.DeliInter;
import com.githrd.deli.dao.pplaceDAO;
import com.githrd.deli.vo.pplaceVO;

public class placeCon implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/search/1.mapSearch/mapSearch";
		pplaceVO vo = new pplaceVO();
		/*
		double pickuplat = Double.parseDouble(req.getParameter("pickuplat"));
		double pickuplon = Double.parseDouble(req.getParameter("pickuplon"));
		double cus_lat = Double.parseDouble(req.getParameter("cus_lat"));
		double cus_lon = Double.parseDouble(req.getParameter("cus_lon"));
		*/
		String id = req.getParameter("cusid");
		pplaceDAO pDao = new pplaceDAO();
		vo = pDao.selectLocation(id);
		
		discal dis = new discal();
		double distance = dis.disCal(vo.getCus_lat(), vo.getCus_lon(), vo.getPickuplat(), vo.getPickuplon());
		req.setAttribute("CLAT", vo.getCus_lat());
		req.setAttribute("CLON", vo.getCus_lon());
		req.setAttribute("PLAT", vo.getPickuplat());
		req.setAttribute("PLON", vo.getPickuplon());
		/*
		vo.setCusname(req.getParameter("cusname"));
		vo.setCusid(req.getParameter("cusid"));
		vo.setPickuplat(pickuplat);
		vo.setPickuplon(pickuplon);
		vo.setCus_lat(cus_lat);
		vo.setCus_lon(cus_lon);
		vo.setDistance(distance);
		pplaceDAO dao = new pplaceDAO();
		dao.insert(vo);
		*/
		//resp.sendRedirect("../data/form/pickup_listForm.jsp");
		return view;
	}

}
