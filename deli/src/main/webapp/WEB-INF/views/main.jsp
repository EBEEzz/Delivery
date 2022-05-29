<%-- 

/**
 * @author	이용현
 * @since	2022/05/24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : 이용현
 */
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Project Main</title>
<script type="text/javascript" src="/deli/resources/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/js/member/myInfo.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

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
.hotclick {
	overflow : hidden;
}
.hotclickhr {
	margin-top : 0px;
}
small {
	font-size: 7px;
}
.fbtn {
	padding: 0px 8px;
	font-size: 11px;
	
}
#fribox{
	display: none;
}
.delbtn, .canbtn, .agrbtn{
	border: 0px;
	background-color: white;
	padding: 0px;
}
#spoon{
	font-size: 1em;
	color: transparent;
	text-shadow: 0 0 0 grey;
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


			<textarea id="chatbox" rows="10" cols="75"></textarea>
						
			<form class="w3-margin-bottom">
		
				<input id="id" type="text" value="${SID}" disabled>
		
				<input id="textMessage" type="text">
		
				<input value="Send" type="button" id="sendbtn">
			</form>


				

			</div>
<c:if test="${empty SID}">
			<div class="w3-col m3">
				<div class="w3-border w3-button w230 mgb10 w3-right" id="lbtn">로그인</div>
				<button class="w3-right member w3-button" id="jbtn">회원가입</button>
			</div>
</c:if>
<c:if test="${not empty SID}">
			<div class="w3-col m3">
				<div class="w3-border w230 mgb10 w3-right w3-left-align w3-padding">
					<div class="w3-col">
						<div>
							<div class="w3-col m2"> ID : </div>
							<div class="w3-col m10" id="memberid">${SID}</div>
						</div>
						<div class="w3-col m12 w3-button fbtn w3-right" id="msgbtn" >메세지보내기</div>
						<div class="w3-col m12 w3-button fbtn w3-right" id="myinfo" >내정보보기</div>
						<div class="w3-col m12 w3-button fbtn w3-right" id="esti">후기</div>
						<div class="w3-col m12 w3-button fbtn w3-right" id="friendbtn">내친구보기</div>
						<div class="w3-col m12 w3-button fbtn w3-right" id="locbtn">나의 기본수령지 보기</div>
						<div id="fribox">
							<div class="w3-col w3-center"><small><strong>친구 목록</strong></small></div>
<c:forEach var="friend" items="${FRIEND}">						
							<div class="w3-col"><small>${friend.id}&nbsp;&nbsp;<button class="w3-button delbtn" id="${friend.frino}">&lt;삭제&gt;</button></small></div>
</c:forEach>						
							<div class="w3-col w3-center"><small><strong>친구 신청 대기</strong></small></div>
<c:forEach var="apply" items="${APPLY}">						
							<div class="w3-col"><small>${apply.id}&nbsp;&nbsp;<button class="w3-button agrbtn" id="${apply.frino}">&lt;수락&gt;</button><button class="w3-button canbtn" id="${apply.frino}">&lt;거절&gt;</button></small></div>
</c:forEach>			</div>		
					</div>
				</div>
				
			</div>
</c:if>
			<div class="w3-col m3 hotclick">
				<div class="w3-col w3-margin-top">핫 게시물
				<div class="w3-border w230 mgb10 w3-right w3-padding">
					<form method="POST" action="/deli/boardForm.dlv" id="frm1" name="frm1">
						<input type=hidden id="bno" name="bno">
						
<c:forEach var="data" items="${HOT}">
							<div class="w3-left-align w3-button w3-left hotbtn" id="${data.bno}">
								<div><small>&lt; ${data.marea} &gt;</small></div>
								<div>${data.title}</div>
							</div>
							<hr class="hotclickhr w3-col">		
</c:forEach>	
						
					</form>		
				</div>
				</div>
			</div>
		</div>
	</div>
	
	
	 <form method="POST" action="" id="delfrm" name="delfrm">
	 	<input type="hidden" name="mno" id="delmno">
	 	<input type="hidden" name="id" id="delid">
	 </form>

<div class="w3-container">
		<!-- 회원정보 버튼 -->

 	<div id="id01" class="w3-modal">
		<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:500px">
			
			<div class="w3-center"><br>
        		<span class="w3-button w3-xlarge w3-transparent w3-display-topright" id="x" title="Close Modal">×</span>
        		<img src="/deli${DATA.dir}/${DATA.oriname}" alt="profile" style="width:30%" class="w3-circle w3-margin-top w3-border">
      		</div>
      
			<div class="w3-container">
	        	<div class="w3-section">
					<h3 class="w3-center" id="infoid">${DATA.id}</h3>
					<h5 class="w3-center">추천도 : <span><span id="spoon">🥄</span>${DATA.esti} / 5</span></h5>
					<h5 class="w3-center" style="display: none;"><span id="infomno">${DATA.mno}</span></h5>
					<h5 class="w3-center">이메일 : <span>${DATA.mail}</span></h5>
					<h5 class="w3-center">카카오아이디 : <span>${DATA.kakaoid}</span></h5>
					<h5 class="w3-center">전화번호 : <span>${DATA.tel}</span></h5>	
					<div class="w3-col w3-margin-bottom">				
						<button class="m2 w3-button w3-blue" id="ebtn">회원정보 수정</button>
						<button class="m2 w3-button w3-red w3-right" id="dbtn">회원 탈퇴</button>
					</div>
				</div>
			</div>
	
			<div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
				<button id="cbth" type="button" class="w3-button w3-black">Cancel</button>
			</div>
	
		</div>
	</div>
</div>
<div class="w3-center">
	<form action="/deli/mapplace.dlv" method="POST" id="mapsearch">
		<input type="hidden" name="cusid" id="cusid">
	</form>
</div>
	
	
</body>


</html>