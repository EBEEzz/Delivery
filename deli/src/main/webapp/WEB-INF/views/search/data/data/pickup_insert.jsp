<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="dao.*, vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%	
	pplaceDAO dao = new pplaceDAO();
	pplaceVO vo = new pplaceVO();
	dao.insert(vo);
	response.sendRedirect("../form/pickup_listForm.jsp");
%>
