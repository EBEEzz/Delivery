<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/deli/resources/js/member/join.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="w3-content w3-margin-top mxw600">
		<div class="w3-center w3-margin">
			<h1>Deli 회원가입</h1>
			<form method="POST" action="" name="frm" id="frm" encType="multipart/form-data"
				class="w3-col w3-margin-top w3-margin-bottom w3-padding w3-card-4">
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="name" class="w3-left mgl10" style="font-weight: bold;">회원이름</label>
					</h5>
					<input type="text" name="name" id="name" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center">
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="id" class="w3-left mgl10" style="font-weight: bold;">아이디</label>
					</h5>
					<input type="text" name="id" id="id" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center">
					<span class="w3-col w3-center" id="idmsg" style="display: none;"></span>
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="kakaoid" class="w3-left mgl10" style="font-weight: bold;">카카오 아이디</label>
					</h5>
					<input type="text" name="kakaoid" id="kakaoid"" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="pw" class="w3-left mgl10" style="font-weight: bold;">비밀번호</label>
					</h5>
					<input type="password" name="pw" id="pw" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="repw" class="w3-left mgl10" style="font-weight: bold;">비밀번호 확인</label>
					</h5>
					<input type="password" name="repw" id="repw" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
					<span class="w3-col w3-text-red w3-center" id="repwmsg">비밀번호가 일치하지 않습니다.</span>
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="mail" class="w3-left mgl10" style="font-weight: bold;">이메일</label>
					</h5>
					<input type="text" name="mail" id="mail" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="tel" class="w3-left mgl10" style="font-weight: bold;">전화번호</label>
					</h5>
					<input type="text" name="tel" id="tel" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="addr" class="w3-left mgl10" style="font-weight: bold;">주소</label>
					</h5>
					<input type="text" name="addr" id="addr" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
				</div>
				<div class="w3-padding mgb10">
					<h5 class="w3-left-align">
						<label for="proimg" class="w3-left mgl10" style="font-weight: bold;">프로필사진</label>
					</h5>
					<input type="file" name="proimg" id="proimg" class="s8 w3-magin-top mgl10 w3-input w3-border w3-center" >
					<img id ="img" src="/deli/resources/img/avatar/noimage.jpg" class="w3-border w3-margin-top" style="whith: 200px; height: 200px;">
				</div>
			</form>
		</div>
		<div class="w3-col w3-margin-top mgl10">
			<div class="w3-third w3-hover-orange w3-button w3-border" id="rbtn">reset</div> 
			<div class="w3-third w3-hover-lime w3-button w3-border" id="hbtn">home</div> 
			<div class="w3-third w3-hover-aqua w3-button w3-border" id="jbtn">join</div> 
		</div>
	</div>
</body>
</html>