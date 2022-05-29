 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 * 
 * @author 이형준
 * @since  2022.05.24
 * @version  v.1.0
 * 		
 * 					작업이력 )
 * 						2022.05.24	-	담당자 : 이형준
 * 										내용   : view 제작
 *
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BeforePay</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/deli/resources/js/pay/pay.js"></script>
<!-- jQuery -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	
<script type="text/javascript">

</script>
</head>
<body>
	<div class="mxw700 w3-content w3-center">
		<form method="POST" action="/deli/payment/InsertInfo.dlv" id="frm" name="frm">
			<input type="hidden" id="ono" name="ono" value="${DATA.ono}">
			<input type="hidden" id="tel" name="tel" value="${DATA.tel}">
		<h1 class="w3-teal w3-padding" style="margin-bottom: 5px;">Delivery Project</h1>
		<div class="w3-col w3-light-grey">
			<div class="w3-col w3-border-bottom mgl10" align="left">
				<h3>결제가 완료되었습니다.</h3>
				<h4 class="w3-left">배달 장소 : <span id="addr">${DATA.addr}</span></h4>
			</div>
<c:forEach var="data" items="${MENU}" varStatus="status"  >
<c:set var="memb" value="${MEMBER[status.index]}" />
<c:if test="${SID eq memb.id}">
			<div class="w3-col w3-border-bottom mgl10" align="left" >
				<h4>${SID} 님이 선택하신 메뉴</h4><br>
				<div>${PO.amname} : ${PO.myprice}</div>
				<h4>요청 사항 : </h4><br>
				<div id="rq" class="w3-col  m11"> ${RQ} </div>
				<h4 class="w3-col">가격 : <span >${PO.myprice}</span></h4>
			</div>	
</c:if>
<c:if test="${SID ne memb.id && memb.id != null}">
			<div class="w3-col w3-border-bottom mgl10" align="left" >
				<h4>${memb.id} 님이 선택하신 메뉴</h4><br>
				<div><span id="abcdef">${data.mname} : </span><span>${data.mprice}</span><span></span></div>
				<h4>가격 : <span>${data.mprice}</span></h4>
			</div>
</c:if> 
</c:forEach>
			<div class="w3-col w3-border-bottom mgl10" align="left" >
<c:forEach var="data" items="${MENU}" varStatus="status"  >
<c:set var="memb" value="${MEMBER[status.index]}" />
<c:if test="${SID eq memb.id}">
				<h4>${SID} 님 금 액 : <span>${PO.myprice}</span></h4><br>
</c:if>
<c:if test="${SID ne memb.id && memb.id != null}">		
				<h4>${memb.id} 님 금 액 :<span>${data.mprice}</span></h4><br>
</c:if>
</c:forEach>
				<h4>배달비  : <span>${PO.delpay}</span></h4><br>
<c:forEach var="data" items="${MENU}" varStatus="status"  >
<c:set var="memb" value="${MEMBER[status.index]}" />
<c:if test="${SID eq memb.id }"> 
				<h4>${SID}님이 지불하신 금액  : <span>${PO.mtprice}</span></h4>
</c:if>				
</c:forEach>
			</div>
		</div>
		</form>
		<div class="w3-col w3-margin-top w3-card-4 w3-center" >
			<div class="w3-half w3-button w3-green" id="pbtn">결제</div>
			<div class="w3-half w3-button w3-deep-orange" id="cbtn">취소</div>
		</div>
		</div>
	
</body>
</html>