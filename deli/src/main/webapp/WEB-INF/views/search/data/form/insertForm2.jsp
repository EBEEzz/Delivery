<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.*,dao.*,vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "dao" class = "dao.delipDAO"/>
<jsp:useBean id = "vo" class = "vo.delipVO"/>

<html>
<head>
<title>현재 위치</title>

</head>
<body>
<form action = "../data/insert.jsp" method = "post">
	<input type = "hidden" name = "no">
	<input type = "hidden" name = "here_lat" value = <%=request.getParameter("here_lat")%> readonly>
	<input type = "hidden" name = "here_lon" value = <%=request.getParameter("here_lon")%> readonly>
	위도입력 : <input type = "text" name = "lat" value = <%=request.getParameter("lat")%> readonly><br>
	경도입력 : <input type = "text" name = "lon" value = <%=request.getParameter("lon")%> readonly><br>
	거리 : <input type = "text" name = "dist" value = <%=request.getParameter("dist")%> readonly><br>
	이름 : <input type = "text" name = "name" placeholder ="장소명 입력" required>
	<input type = "submit" value = "제출">	
</body>
</html>