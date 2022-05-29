<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.githrd.deli.dao.*,com.githrd.deli.vo.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	

	pplaceDAO dao = new pplaceDAO();
	List<pplaceVO> list = dao.seleID(request.getParameter("cusid"));
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
	<h2>테이블</h2>
	<table border = 1px;>
	<tr>
	<th>장소명</th>
	<th>위도</th>
	<th>경도</th>
	<th>거리</th>
	</tr>
	<tr>

	
	<c:forEach items = "${list}" var = "list" >
	<th>${list.cusname}</th>
	<th>${list.pickuplat}</th>
	<th>${list.pickuplon}</th>
	<th>${list.distance}</th>
	</tr>
	</c:forEach>
	</table>
	<a href = "../../index.jsp"><button>뒤로가기</button></a>
	</center>
	<a href = "pickup_insertForm.jsp"><button>추가입력</button></a>
	
</body>
</html>