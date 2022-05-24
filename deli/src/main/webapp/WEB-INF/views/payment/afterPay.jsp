<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="mxw700 w3-content w3-center">
		<h1 class="w3-teal w3-padding" style="margin-bottom: 5px;">홈페이지 이름</h1>
		<div class="w3-col w3-light-grey">
			<div class="w3-col w3-border-bottom mgl10" align="left">
				<h3>결제가 완료되었습니다.</h4><br>
				<h4>배달 장소 : <span>A</span></h4>
			</div>
			<div class="w3-col w3-border-bottom mgl10" align="left" >
				<h4 >A님이 선택하신 메뉴</h4><br>
				<p><span>A </span><span> : 1만원</span></p><br>
				<h4>요청 사항 : <span>단무지 많이 주세요</span></h4><br>
				<h4>가격 : <span>1만원</span></h4>
			</div>
			<div class="w3-col w3-border-bottom mgl10" align="left" >
				<h4>B님이 선택하신 메뉴</h4><br>
				<h4><span>B </span><span> : 2만원</span></h4><br>
				<h4>요청 사항 : <span></span></h4><br>
				<h4>가격 : <span>2만원</span></h4>
			</div>
			<div class="w3-col w3-border-bottom mgl10" align="left" >
				<h4><span>A 님 금 액 : </span><span> : 1만원</span></h4><br>
				<h4><span>B 님 금 액 : </span><span> : 2만원</span></h4><br>
				<h4>배달비  : <span> 3000 원</span></h4><br>
				<h4>총합    : <span>2만원</span></h4><br>
				<h4>A님이 지불하실 금액  : <span>1만 3000원</span></h4>
			</div>
		</div>
		<div class="w3-col w3-margin-top w3-card-4 w3-center" >
			<div class="w3-half w3-button w3-deep-orange" id="bbtn">돌아가기</div>
		</div>
	</div>
</body>
</html>