<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.*,vo.*"%>
<jsp:useBean id = "dao" class = "dao.rcoordiDAO"/>    
<jsp:useBean id = "vo" class = "vo.rcoordiVO"/>    
<jsp:setProperty name = "vo" property = "*"/>


<%
	vo.setCate_no(Integer.parseInt(request.getParameter("cate_no")));
	dao.insert(vo);
	response.sendRedirect("../form/res_listForm.jsp");
%>