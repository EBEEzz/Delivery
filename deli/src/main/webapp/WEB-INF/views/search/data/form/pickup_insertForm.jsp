<%@page language = "java" contentType = "text/html; charset=UTF-8"
pageEncoding = "UTF-8" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 입력</title>
</head>
<body>
<center>
<h2>회원 정보 입력</h2>
	<form action = "../addpickup.hn" method="POST" name="frm" id="frm" >
	픽업장소 : <input type = "text" name = "cusname" placeholder ="장소명 입력" required><br>	
	아이디 : <input type = "text" name = "cusid"  value = "${param.cusid}"placeholder ="아이디명 입력" required><br>	
	위도입력 : <input type = "text" name = "pickuplat" placeholder = "위도 입력" required><br>
	경도입력 : <input type = "text" name = "pickuplon" placeholder = "경도 입력" required><br>
	현재 위도입력 : <input type = "text" name = "cus_lat"  placeholder = "현재위도 입력"  required><br>
	현재 경도입력 : <input type = "text" name = "cus_lon"  placeholder = "현재경도 입력" required><br>
	<input type = "submit" id = "sub" value = "제출">
	</form>
	</center>
</body>
</html>