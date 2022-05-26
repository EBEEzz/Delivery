<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경도,위도 입력</title>
</head>
<body>
	<form action = "../data/calc.jsp" method = "post">
	현재경도 : <input type = "text" name = "here_lat" value = 37.3590589 readonly><br>
	현재위도 : <input type = "text" name = "here_lon" value = 126.9307383 readonly><br>
	경도입력 : <input type = "text" name = "lat" placeholder = "경도" required><br>
	위도입력 : <input type = "text" name = "lon" placeholder = "위도" required><br>
		
	<input type = "submit" value = "제출">
	</form>
</body>
</html>