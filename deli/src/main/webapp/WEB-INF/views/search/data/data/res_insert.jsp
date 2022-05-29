<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.githrd.deli.dao.*,com.githrd.deli.vo.*"%>
<%-- <jsp:useBean id = "dao" class = "com.githrd.deli.dao.*"/>    
<jsp:useBean id = "vo" class = "com.githrd.deli.vo.*"/>   --%>  
<jsp:setProperty name = "vo" property = "*"/>


<%


/* 	vo.setCate_no(Integer.parseInt(request.getParameter("cate_no")));
	dao.insert(vo); */
	response.sendRedirect("../form/res_listForm.jsp");
%>