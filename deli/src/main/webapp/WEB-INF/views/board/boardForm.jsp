<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="/deli/resources/boardForm.js"></script>
<script type="text/javascript">

</script>
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
.subbtn {
	padding : 0px;
	margin : 0px 5px 0px 0px;
}
#regimem {
	position: relative;
	top: -12px;
	right: 80px;
	display: none;
}
.regimember{
	margin: 0px;
}
</style>
</head>
<body>
<c:if test="${RESULT eq 0}">
	<input type="hidden" id="result" value="success">
</c:if>
<c:if test="${RESULT eq 2}">
	<input type="hidden" id="result" value="fail">
</c:if>
<c:if test="${RESULT eq 1}">
	<input type="hidden" id="result" value="false">
</c:if>
<c:if test="${CRESULT eq 0}">
	<input type="hidden" id="cancleresult" value="success">
</c:if>
<c:if test="${CRESULT eq 1}">
	<input type="hidden" id="cancleresult" value="fali">
</c:if>
<c:if test="${CRESULT eq 2}">
	<input type="hidden" id="cancleresult" value="false">
</c:if>
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
		<!-- 접수가능 게시글 -->
<c:if test="${MAIN.endalert > 0}">		
		<div class="w3-col w3-padding w3-left-align w3-border w3-card-4 w3-margin-top ctdw" id="${MAIN.endtime}">
			<div class="count" id="count">
				<div class="w3-col">
					<div class="w3-left maintext area"><small>&it; ${MAIN.marea} &gt;</small></div>
					<div class="w3-col w3-button w3-border subbtn m1 w3-right" id="canclebtn">지원취소</div>
					<div class="w3-col w3-button w3-border subbtn m1 w3-right" id="conbtn">신청현황</div>
					<div class="w3-col w3-button w3-border subbtn m1 w3-right" id="subbtn">신청</div>
					<div class="w3-right w3-margin-right" id="id"></div>
				</div>
			</div>
			<div class="w3-col m8">
				<h1 class="w3-col maintext">${MAIN.title}</h1>
				<div class="w3-col maintext">${MAIN.id}</div>
				<div class="w3-col maintext"><small>${MAIN.sdate}&nbsp;&nbsp;&nbsp;조회수 : ${MAIN.click}</small></div>
			</div>
			
			<div class="w3-col w3-right m1 w3-margin-top" id="regimem">
			
			
<c:forEach var="data" items="${MEMBER}">
				<h6 class="w3-col regimember" id="${data.id}"><small id="alertmember">${data.id}</small></h6>
</c:forEach>	
			</div>
			
			
			
			<hr class="w3-col mgt0">
			<div>
				<div class="w3-col m8">${MAIN.body}</div>
				<div class="w3-col m4"> 
				<div class="w3-center">식당정보</div>
<c:forEach var="menu" items="${MENU}">	
				<div class="w3-right">${menu.rname}</div>
					<div>${menu.mname} : ${menu.mprice}</div>		
</c:forEach>
				</div>				
			</div>
		</div>

	<c:if test="${not empty PAY}">
		<div class="w3-col w3-button w3-border w3-margin-top">결제하기</div>
	</c:if>

</c:if>		
<c:if test="${MAIN.endalert < 0}">		
		<div class="w3-col w3-padding w3-left-align w3-border w3-card-4 w3-margin-top">
			<div>
				<div class="w3-col">
					<div class="w3-left maintext area"><small>&it; ${MAIN.marea} &gt;</small></div>
					<div class="w3-col w3-button w3-border subbtn m1 w3-right" id="conbtn">신청현황</div>
					<div class="w3-right w3-margin-right">마감시간 : ${MAIN.endtime}</div>
				</div>
			</div>
			<div class="w3-col m8">
				<h1 class="w3-col maintext">${MAIN.title}</h1>
				<div class="w3-col maintext">${MAIN.id}</div>
				<div class="w3-col maintext"><small>${MAIN.sdate}&nbsp;&nbsp;&nbsp;조회수 : ${MAIN.click}</small></div>
			</div>
			
			<div class="w3-col w3-right m1 w3-margin-top" id="regimem">
			
			
<c:forEach var="data" items="${MEMBER}">
				<h6 class="w3-col regimember" id="${data.id}"><small id="alertmember">${data.id}</small></h6>
</c:forEach>			
			</div>
			
			
			<hr class="w3-col mgt0">
			<div class="w3-col">${MAIN.body}</div>
		</div>
</c:if>		
	</div>
	
	<form method="POST" action="/deli/applyProc.dlv" id="pageFrm" name="pageFrm">
		<input type="hidden" name="nowPage" id="nowPage" value="${param.nowPage}">
		<input type="hidden" name="city" id="city" value="${param.city}">
		<input type="hidden" name="search" id="search" value="${param.search}">
		<input type="hidden" name="check" id="check" value="${param.check}">
		<input type="hidden" name="bno" id="bno" value="${MAIN.bno}">
		<input type="hidden" name="cancle" id="cancle">
	</form>
</body>
</html>