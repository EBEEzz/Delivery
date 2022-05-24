 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BeforePay</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<!-- jQuery -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//	버튼 클릭하면 실행
	$("#pbtn").click(function(){
		/*
		for(var i=0; i<document.purchaseinput.elements.length; i++)
		{
			if(document.purchaseinput.elements[i].value == "")
			{
				alert("모든 값을 입력 하셔야 합니다. ");
					document.purchaseinput.elements[i].focus();
					return false;
			}	
		}
		*/
		
		let m_email = $("#m_email").val();
		let s_name = $("#s_name").val();
		let s_addr = $("#roadFullAddr").val();
		let s_phone = $("#s_phone").val();
		let s_msg = $("#s_msg").val();
		let s_zipNo = $("#s_zipNo").val();
		//alert(m_email +s_name +s_addr +s_phone +s_msg +s_zipNo);
			
		var IMP = window.IMP; // 생략가능
		IMP.init('imp64825572');	//아임포트 관리자계정
		//결제 시스템을 실행시키는 함수
	  	IMP.request_pay({
	  		pg: 'kakaopay',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),
			name: '주문명 : 짜장면 테스트',
			amount: 6000,	//테스트 완료 후 가격정보 넣기
			buyer_email: m_email,
			buyer_name: s_name,
			buyer_tel: s_phone,
			buyer_addr: s_addr,
			buyer_postcode: s_zipNo
			}, function (rsp) {
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
					let purchaseVo = {
						m_email: m_email,
						s_name: s_name,
						s_addr: s_addr,
						s_phone: s_phone,
						s_msg: s_msg,
						s_zipNo: s_zipNo,
						o_shipno: rsp.merchant_uid,
						o_paidAmount: rsp.paid_amount,
						o_paytype: rsp.pay_method
						}
					// 컨트롤러에 데이터를 전달하여 DB에 입력하는 로직
	                		// 결제내역을 사용자에게 보여주기 위해 필요함.
	               			$.ajax({
						url : "/payment/beforePay",
						type : "get",
						data : purchaseVo,
						dataType : "text",
						success : function(result){
							if(result == "y") {
								alert(msg);
								location.href = "/payment/afterPay"; 
							}else{
								alert("디비입력실패");
								return false;
							}
						},
						error : function(a,b,c){}
					});
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
			alert(msg);
		});
	});
});
</script>
</head>
<body>
	<div class="mxw700 w3-content w3-center">
		<h1 class="w3-teal w3-padding" style="margin-bottom: 5px;">홈페이지 이름</h1>
		<div class="w3-col w3-light-grey">
			<div class="w3-col w3-border-bottom mgl10" align="left">
				<h4  class="w3-left">배달 장소 : <span>A</span></h4>
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
				<h4 >A님이 지불하실 금액  : <span id="">1만 3000원</span></h4>
			</div>
		</div>
		<div class="w3-col w3-margin-top w3-card-4 w3-center" >
			<div class="w3-half w3-button w3-green" id="pbtn">결제</div>
			<div class="w3-half w3-button w3-deep-orange" id="cbtn">취소</div>
		</div>
	</div>
</body>
</html>