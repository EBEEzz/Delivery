<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board Form</title>
<script type="text/javascript" src="/deli/resources/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/boardList.js"></script><!-- 수정필요!!!!!!!!!!!!!!!!!!!! -->
<style type="text/css">
.mxw980 {
	max-width: 980px;
	min-width: 980px;
}
.w33 {
	width: 14.285%;
}
.h500 {
	height: 500px;
	padding-left: 10px;
	padding-right: 10px;
	overflow: auto;
}
.member {
	text-size: 8px;
	border: 0px;
	background-color: white;
}
.w230 {
	width: 230px;
	margin-bottom: 3px;
}
.maintext {
	margin : 0px;
}
.area {
	color: green;
}
</style>
</head>
<body>
	<div class="mxw980 w3-content w3-center">
		<button class="w3-right-align mg0 w3-left mg0 pdAll0 w3-button mgt10 member" id="hbtn">HOME</button>
<c:if test="${not empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="obtn">로그아웃</button>
</c:if>
<c:if test="${empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="lbtn">로그인</button>
</c:if>
		<form method="POST" action="/deli/boardList.dlv" id="frm" name="frm">
			<input type="hidden" id="maincity" name="city" value="${param.city}">
		
		<div class="w3-col mgt0">
			<h1 class="mgb10 w3-border pdAll10"><strong>Delivery Project</strong></h1>
			<hr>
			<button class="w3-button w3-left w33" id="sbtn" value="seoul">서울</button>
			<button class="w3-button w3-left w33" value="gyeonggi">경기도</button>
			<button class="w3-button w3-left w33" disabled value="gangwon">강원도</button>
			<button class="w3-button w3-left w33" disabled value="chungcheong">충청도</button>
			<button class="w3-button w3-left w33" value="gyeongsang">경상도</button>
			<button class="w3-button w3-left w33" disabled value="jeolla">전라도</button>
			<button class="w3-button w3-left w33" disabled value="jeju">제주도</button>
		<hr class="w3-col mg0 w3-card-2">
		</div>
		</form>
		
		<div class="w3-col w3-padding w3-left-align w3-border w3-card-4 w3-margin-top">
			<div>
				<div class="w3-left maintext area"><small>&it; ${MAIN.marea} &gt;</small></div>
				<div class="w3-right">마감 : ${MAIN.endtime}</div>
			</div>
			<h1 class="w3-col maintext">${MAIN.title}</h1>
			<div class="w3-col maintext">${MAIN.id}</div>
			<div class="w3-col maintext"><small>${MAIN.sdate}&nbsp;&nbsp;&nbsp;조회수 : ${MAIN.click}</small></div>
			<hr class="w3-col mgt0">
			<div class="w3-col">${MAIN.body}</div>
		</div>
		
	</div>
</body>
</html>