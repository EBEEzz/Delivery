package com.githrd.deli.controller.haneul;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.deli.dao.*;
import com.githrd.deli.db.*;
import com.githrd.deli.sql.*;
import com.githrd.deli.util.*;
import com.githrd.deli.vo.*;

@WebServlet("/data/addpickup.hn")
public class pplaceCon extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("*********************************");
		pplaceVO vo = new pplaceVO();
		double pickuplat = Double.parseDouble(req.getParameter("pickuplat"));
		double pickuplon = Double.parseDouble(req.getParameter("pickuplon"));
		double cus_lat = Double.parseDouble(req.getParameter("cus_lat"));
		double cus_lon = Double.parseDouble(req.getParameter("cus_lon"));
		discal dis = new discal();
		double distance = dis.disCal(cus_lat, cus_lon, pickuplat, pickuplon);
		vo.setCusname(req.getParameter("cusname"));
		vo.setCusid(req.getParameter("cusid"));
		vo.setPickuplat(pickuplat);
		vo.setPickuplon(pickuplon);
		vo.setCus_lat(cus_lat);
		vo.setCus_lon(cus_lon);
		vo.setDistance(distance);
		pplaceDAO dao = new pplaceDAO();
		dao.insert(vo);
		resp.sendRedirect("../data/form/pickup_listForm.jsp");
	}
}