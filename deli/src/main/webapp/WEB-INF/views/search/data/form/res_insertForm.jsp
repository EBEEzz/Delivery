<%@page language = "java" contentType = "text/html; charset=UTF-8"
pageEncoding = "UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식점 정보입력 페이지</title>
</head>
<body>
	<center>
	<h2>음식점 등록</h2>
	<form action = "../data/res_calc.jsp" method = "post">
	<input type = "hidden" name = "no" readonly>
	상 호 명 : <input type = "text" name = "resname" placeholder ="상호명 입력" required><br>	
	위도입력 : <input type = "text" name = "reslat" placeholder = "위도 입력" required><br>
	경도입력 : <input type = "text" name = "reslon" placeholder = "경도 입력" required><br>
	현재위도 : <input type = "text" name = "mylat" value = <%=request.getParameter("mylat")%> ><br>
	현재경도 : <input type = "text" name = "mylon" value = <%=request.getParameter("mylon")%> ><br>
	카테고리 : <select id = "selectBox" name ="selectBox" onchange = "changeSelect();">
	<option value = "" selected disabled>-----------------------------------</option>
	<option value = 1>돈까스·회·일식</option>
	<option value = 2>중식</option>
	<option value = 3>치킨</option>
	<option value = 4>백반·죽·국수</option>
	<option value = 5>카페·디저트</option>
	<option value = 6>분식</option>
	<option value = 7>찜·탕·찌개</option>
	<option value = 8>피자</option>
	<option value = 9>양식</option>
	<option value = 10>고기·구이</option>
	<option value = 11>족발·보쌈</option>
	<option value = 12>아시안</option>
	<option value = 13>페스트푸드</option>
	<option value = 14>도시락</option>
	</select>
	<input type = "hidden" id = "category" name ="category" value ="">
	<input type = "hidden" id = "cate_no" name ="cate_no" value =""><br>
	<input type = "submit" value = "제출">
	</form>
	</center>
	<script src = "res_insertForm.js"></script>
</body>
</html>