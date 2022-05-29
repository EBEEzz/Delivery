<%-- 

/**
 * @author	이용현
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 이용현
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/deli/resources/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/board/message.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/message.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<div class="mxw800 w3-content w3-center">
		<button class="w3-right-align mg0 w3-left mg0 pdAll0 w3-button mgt10 member" id="hbtn">HOME</button>
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
		
		
		<div>
			<div class="w3-col m2 w3-margin w3-border">
				<div class="w3-button w3-border-bottom" id="mymess">받은 쪽지</div>
				<div class="w3-button" id="send">쪽지 보내기</div>
			</div>
			<div class="w3-col m9 w3-margin-top w3-border w3-right w3-light-gray">
				<div class="w3-col m1 w3-border-right">보낸사람</div>
				<div class="w3-col m3 w3-border-right">제목</div>
				<div class="w3-col m4 w3-border-right">내용</div>
				<div class="w3-col m4">보낸날짜</div>
			</div>
<c:forEach var="data" items="${MESSAGE}">			
			<div class="w3-col m9 w3-border w3-right w3-button messbtn" id="${data.id}">
				<div class="w3-col m1 w3-border-right">${data.id}</div>
				<div class="w3-col m3 w3-border-right">${data.title}</div>
				<div class="w3-col m4 w3-border-right">${data.body}</div>
				<div class="w3-col m4">${data.sdate}</div>
			</div>
</c:forEach>
		</div>
		
		
		
	</div>
</body>
</html>