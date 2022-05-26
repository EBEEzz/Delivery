<!-- 
작성자 태그 작성
실시간채팅 input 회원 아이디 받아오는 id value 수정
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Project Main</title>
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/main.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
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
textarea {
	resize: none;
	height: 500px;
}
</style>

</head>
<body>
	<div class="mxw800 w3-content w3-center">
<c:if test="${not empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="obtn">로그아웃</button>
</c:if>
		<form method="POST" action="/deli/boardList.dlv" id="frm" name="frm">
			<input type="hidden" id="city" name="city" value="">
		
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
		<div class="w3-col w3-center mgt20">
			<div class="w3-col m9">

				
	<!-- 콘솔 메시지의 역할을 하는 로그 텍스트 에리어.(수신 메시지도 표시한다.) -->
	<textarea id="chatbox" rows="10" cols="70"></textarea>
				
	<form class="w3-margin-bottom">
		<!-- 유저 명을 입력하는 텍스트 박스(기본 값은 anonymous(익명)) -->
		<input id="id" type="text" value="YHLEE" disabled>
		<!-- 송신 메시지를 작성하는 텍스트 박스 -->
		<input id="textMessage" type="text">
		<!-- 메세지를 송신하는 버튼 -->
		<input value="Send" type="button" id="sendbtn">
	</form>


				

			</div>
<c:if test="${empty SID}">
			<div class="w3-col m3">
				<div class="w3-border w3-button w230 mgb10 w3-right" id="lbtn">로그인</div>
				<button class="w3-right member" id="jbtn">회원가입</button>
			</div>
</c:if>
<c:if test="${not empty SID}">
			<div class="w3-col m3">
				<div class="w3-border w230 mgb10 w3-right w3-left-align w3-padding">
					<div class="w3-col m4">사진</div>
					<div class="w3-col m8">아이디</div>
					
				</div>
				
			</div>
</c:if>
		</div>
	</div>
</body>
<script type="text/javascript">

	
</script>
</html>