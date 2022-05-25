<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board List</title>
<script type="text/javascript" src="/deli/resources/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/boardList.js"></script>
</head>
<body>
	<div class="mxw800 w3-content w3-center">
	<button class="w3-right-align mg0 w3-left mg0 pdAll0 w3-button mgt10 member" id="hbtn">HOME</button>
<c:if test="${not empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="obtn">로그아웃</button>
</c:if>
<c:if test="${empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="lbtn">로그인</button>
</c:if>
		<div class="w3-col mgt0">
			<h1 class="mgb10 w3-border pdAll10"><strong>Delivery Project</strong></h1>
			<hr>
			<button class="w3-button w3-left w33" id="sbtn">서울</button>
			<button class="w3-button w3-left w33" disabled>경기도</button>
			<button class="w3-button w3-left w33" disabled>강원도</button>
			<button class="w3-button w3-left w33" disabled>충청도</button>
			<button class="w3-button w3-left w33" disabled>경상도</button>
			<button class="w3-button w3-left w33" disabled>전라도</button>
			<button class="w3-button w3-left w33" disabled>제주도</button>
		<hr class="w3-col mg0 w3-card-2">
		</div>

		<div class="w3-col w3-white w3-padding w3-card-4 mgt20">
			
			<div class="w3-col w3-light-grey w3-center w3-border">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">카테고리</div>
					<div class="w3-col m3 w3-border-right">글번호</div>
					<div class="w3-col m5 w3-border-right">작성자</div>
				</div>
				<div class="w3-col m4 w3-border-right">글제목</div>
				<div class="w3-col m3 w3-border-right">작성일</div>
				<div class="w3-col m1 w3-border-right">조회수</div>
				<div class="w3-col m1">지역</div>
			</div>
			
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">치킨족발</div>
					<div class="w3-col m3 w3-border-right">글번호</div>
					<div class="w3-col m5 w3-border-right">작성자</div>
				</div>
				<div class="w3-col m4 w3-border-right">글제목</div>
				<div class="w3-col m3 w3-border-right">작성일</div>
				<div class="w3-col m1 w3-border-right">클릭수</div>
				<div class="w3-col m1">종로구</div>
			</div>
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">치킨족발</div>
					<div class="w3-col m3 w3-border-right">글번호</div>
					<div class="w3-col m5 w3-border-right">작성자</div>
				</div>
				<div class="w3-col m4 w3-border-right">글제목</div>
				<div class="w3-col m3 w3-border-right">작성일</div>
				<div class="w3-col m1 w3-border-right">클릭수</div>
				<div class="w3-col m1">종로구</div>
			</div>
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">치킨족발</div>
					<div class="w3-col m3 w3-border-right">글번호</div>
					<div class="w3-col m5 w3-border-right">작성자</div>
				</div>
				<div class="w3-col m4 w3-border-right">글제목</div>
				<div class="w3-col m3 w3-border-right">작성일</div>
				<div class="w3-col m1 w3-border-right">클릭수</div>
				<div class="w3-col m1">종로구</div>
			</div>
			
		</div>





				<!-- 페이지 처리 시작 -->
		<div class="w3-center">
			<div class="w3-bar w3-border w3-round-medium w3-card w3-margin-top w3-margin-bottom">
	<c:if test="${PAGE.startPage eq 1}">
				<div class="w3-bar-item w3-light-grey">&laquo;</div>
	</c:if>
	<c:if test="${PAGE.startPage ne 1}">
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.startPage - 1}">&laquo;</div>
	</c:if>
	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
			<c:if test="${page eq PAGE.nowPage}">
				<div class="w3-bar-item w3-orange">${page}</div>
			</c:if>
			<c:if test="${page ne PAGE.nowPage}">
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${page}">${page}</div>
			</c:if>
	</c:forEach>
			<c:if test="${PAGE.endPage eq PAGE.totalPage}">
				<div class="w3-bar-item w3-light-grey">&raquo;</div>
			</c:if>
			<c:if test="${PAGE.endPage ne PAGE.totalPage}">
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.endPage + 1}">&raquo;</div>
			</c:if>
			</div>
		</div>
		<!-- 페이지 처리 태그 끝 -->
		
	</div>
</body>
</html>