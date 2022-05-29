<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.*,vo.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "dao" class = "dao.rcoordiDAO"/>
<jsp:useBean id = "vo" class = "vo.rcoordiVO"/>
<%
	List<rcoordiVO> list = dao.select();
	request.setAttribute("list", list);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>

	<table border = 1px;>
	<tr>
	<th>장소명</th>
	<th>거리</th>
	
	</tr>
	<tr>
	<c:forEach items = "${list}" var = "list" >
	<th>${list.resname}</th>
	<th>${list.resdist}</th>
	
	</tr>
	</c:forEach>
	</table>
	<a href = "../../index.jsp"><button>뒤로가기</button></a>
	</center>
	
	
</body>
</html>