<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="calc.*,dao.*,vo.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   //현재위치 - 장소 거리계산

   double here_lat = Double.parseDouble(request.getParameter("here_lat"));
   double here_lon = Double.parseDouble(request.getParameter("here_lon"));
   double lat = Double.parseDouble(request.getParameter("lat"));
   double lon = Double.parseDouble(request.getParameter("lon"));
   
   discal cal = new discal();
   double dist = cal.disCal(here_lat, here_lon, lat, lon);
 
   response.sendRedirect("../form/insertForm2.jsp?here_lat="+here_lat+"&here_lon="+here_lon+"&lat="+lat+"&lon="+lon+"&dist="+dist);


%>