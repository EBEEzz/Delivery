<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/deli/resources/js/deli/review.js"></script>
<style type="text/css">
	.avtround {
		width: 40px;
		height: auto;
		border-radius: 50px;
		margin-left: 30px;
	}
	#frm fieldset {
		display : inline-block;
		direction: rtl;
		border : 0;
	}
	#frm input[type=radio] {
		display: none;
	}
	#frm input[type=radio]:checked ~ label {
		text-shadow: 0 0 0 #ffd700;
	}
	#frm label {
		font-size: 2em;
		color: transparent;
		text-shadow: 0 0 0 #f0f0f0;
	}
	#frm label:hover {
		text-shadow: 0 0 0 #ffd700;
	}
	#frm label:hover ~ label {
		text-shadow: 0 0 0 #ffd700;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="w3-top">
	  	<div class="w3-row w3-padding w3-black">
		    <div class="w3-col s2">
		    	<div class="w3-button w3-block w3-black" id="hbtn">HOME</div>
		    </div>
		    <div class="w3-col s8">
		      	<div class="w3-block w3-black w3-center">&nbsp;</div>
		    </div>
<c:if test="${SID eq null}">
		    <div class="w3-col s2">
		      	<div class="w3-button w3-block w3-black libtn">LOGIN</div>
	    	</div>
</c:if>
<c:if test="${SID ne null}">
		    <div class="w3-col s2">
		      	<div class="w3-button w3-block w3-black" id="lobtn">LOGOUT</div>
	    	</div>
</c:if>
	  	</div>
	</div>
	
	<div class="w85p w3-display-middle border3px" style="position: relative; top: 95px;">
		<h1 class="w3-center"><b>Delivery Project</b></h1>
	</div>
	
	<div class="w3-display-middle w3-border w3-padding w3-col m8">
    	<div class="w3-container mgt10 mgb20 w3-black">
      		<h3 class="w3-margin-right"><strong>Delivery 경험을 공유해주세요!</strong></h3>
    	</div>
    	<div class="w3-container w3-padding-16 mgt20">
      		<form method="POST" action="/deli/find/idFindResult.dlv" name="frm" id="frm">
        		<div class="w3-row-padding" style="margin:0 -16px;">
          			<div class="w3-margin-bottom pb20">
          				<div class="w3-col w3-white w3-round-large pd15">
							<div class="w3-col w3-grey w3-center w3-border">
								<div class="w3-col">
									<div class="w3-col m4"><b>닉네임</b></div>
									<div class="w3-col m4 w3-border-left w3-border-right"><b>별  점</b></div>
									<div class="w3-col m4"><b>코멘트</b></div>
								</div>
							</div>

							<div class="w3-col w3-white w3-center w3-border">
								<div class="w3-col mgt10 mgb10">
									<div class="w3-col m4">
										<img src="/deli/resources/img/avatar/img_avatar1.png" class="inblock w3-left avtround w3-border w3-border-grey">
										<b style="position: relative; top: 10px;">닉네임</b>
									</div>
									<fieldset class="w3-col m4 mg0 pd0 w3-border-left w3-border-right">
										<input type="radio" name="rating" value="5" id="rate5"><label for="rate5">🥄</label><!--
									 --><input type="radio" name="rating" value="4" id="rate4"><label for="rate4">🥄</label><!--
									 --><input type="radio" name="rating" value="3" id="rate3"><label for="rate3">🥄</label><!--
									 --><input type="radio" name="rating" value="2" id="rate2"><label for="rate2">🥄</label><!--
									 --><input type="radio" name="rating" value="1" id="rate1"><label for="rate1">🥄</label>
									</fieldset>
									<input class="w3-col m4 w3-input w3-border w3-round-large w3-light-grey"
											type="text" placeholder="">
								</div>
							</div>

						</div>
          			</div>
        		</div>
      		</form>
       		<div class="h20 ft12">
        		<div class="w3-quarter w3-button w3-round-large w3-grey w3-margin-top jbtn">회원가입</div>
        		<div class="w3-quarter w3-button w3-round-large w3-grey w3-margin-top libtn">로그인</div>
        		<div class="w3-quarter w3-button w3-round-large w3-grey w3-margin-top pwbtn">비밀번호 찾기</div>
        		<div class="w3-quarter w3-button w3-round-large w3-dark-grey w3-margin-top" id="idbtn">아이디 찾기</div>
       		</div>
    	</div>
  	</div>
</body>
</html>