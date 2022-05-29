<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.githrd.deli.dao.*,com.githrd.deli.dao.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	delipDAO dao = new delipDAO();
	delipVO vo  = new delipVO();
	List<delipVO> list = dao.select();
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
	<th>선택(클릭)</th>
	</tr>
	<tr>
	<c:forEach items = "${list}" var = "list" >
	<th>${list.name}</th><br>
	<th>${list.dist}</th><br>
	<th><a href = "#">선택</a></th><br>
	</tr>
	</c:forEach>
	</table>
	<a href = "../../index.jsp"><button>뒤로가기</button></a>
	</center>
	
	
</body>
</html>