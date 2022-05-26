<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.*,vo.*"%>
<jsp:useBean id = "dao" class = "dao.delipDAO"/>    
<jsp:useBean id = "vo" class = "vo.delipVO"/>    
<jsp:setProperty name = "vo" property = "*"/>


<%
	dao.insert(vo);
	response.sendRedirect("../form/listForm.jsp");
%>