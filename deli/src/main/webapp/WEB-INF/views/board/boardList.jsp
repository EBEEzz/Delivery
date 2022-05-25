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
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="obtn">�α׾ƿ�</button>
</c:if>
<c:if test="${empty SID}">
		<button class="w3-right-align mg0 w3-right mg0 pdAll0 w3-button mgt10 member" id="lbtn">�α���</button>
</c:if>
		<div class="w3-col mgt0">
			<h1 class="mgb10 w3-border pdAll10"><strong>Delivery Project</strong></h1>
			<hr>
			<button class="w3-button w3-left w33" id="sbtn">����</button>
			<button class="w3-button w3-left w33" disabled>��⵵</button>
			<button class="w3-button w3-left w33" disabled>������</button>
			<button class="w3-button w3-left w33" disabled>��û��</button>
			<button class="w3-button w3-left w33" disabled>���</button>
			<button class="w3-button w3-left w33" disabled>����</button>
			<button class="w3-button w3-left w33" disabled>���ֵ�</button>
		<hr class="w3-col mg0 w3-card-2">
		</div>

		<div class="w3-col w3-white w3-padding w3-card-4 mgt20">
			
			<div class="w3-col w3-light-grey w3-center w3-border">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">ī�װ�</div>
					<div class="w3-col m3 w3-border-right">�۹�ȣ</div>
					<div class="w3-col m5 w3-border-right">�ۼ���</div>
				</div>
				<div class="w3-col m4 w3-border-right">������</div>
				<div class="w3-col m3 w3-border-right">�ۼ���</div>
				<div class="w3-col m1 w3-border-right">��ȸ��</div>
				<div class="w3-col m1">����</div>
			</div>
			
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">ġŲ����</div>
					<div class="w3-col m3 w3-border-right">�۹�ȣ</div>
					<div class="w3-col m5 w3-border-right">�ۼ���</div>
				</div>
				<div class="w3-col m4 w3-border-right">������</div>
				<div class="w3-col m3 w3-border-right">�ۼ���</div>
				<div class="w3-col m1 w3-border-right">Ŭ����</div>
				<div class="w3-col m1">���α�</div>
			</div>
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">ġŲ����</div>
					<div class="w3-col m3 w3-border-right">�۹�ȣ</div>
					<div class="w3-col m5 w3-border-right">�ۼ���</div>
				</div>
				<div class="w3-col m4 w3-border-right">������</div>
				<div class="w3-col m3 w3-border-right">�ۼ���</div>
				<div class="w3-col m1 w3-border-right">Ŭ����</div>
				<div class="w3-col m1">���α�</div>
			</div>
			<div class="w3-col w3-white w3-center w3-border-bottom w3-border-left w3-border-right">
				<div class="w3-col m3">
					<div class="w3-col m4 w3-border-right">ġŲ����</div>
					<div class="w3-col m3 w3-border-right">�۹�ȣ</div>
					<div class="w3-col m5 w3-border-right">�ۼ���</div>
				</div>
				<div class="w3-col m4 w3-border-right">������</div>
				<div class="w3-col m3 w3-border-right">�ۼ���</div>
				<div class="w3-col m1 w3-border-right">Ŭ����</div>
				<div class="w3-col m1">���α�</div>
			</div>
			
		</div>





				<!-- ������ ó�� ���� -->
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
		<!-- ������ ó�� �±� �� -->
		
	</div>
</body>
</html>