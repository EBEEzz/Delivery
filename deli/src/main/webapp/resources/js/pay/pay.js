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
		
		
		
		/*		
		let m_email = 'aaa@aaa.com';
		let s_name = 'aaa';
		let s_id = $('#id').val();
		let menu = '짜장면';
		let price = 6000;
		let s_addr = 'aaaaaa222aaa';
		let s_phone = '123-4567-8910';
		let s_msg = 'x';
		let s_zipNo = '12345';
		let rno = $('#rno').val();
		let mno = $('#mno').val();
		let omprice = $('#ompirce').val();
		let omenu = $('#menu').val();
		let odate = dateString + ' ' + timeString;
		let quantity = $('#quantity').val();
		let request = $('#rq').val();
		*/
		
		let m_email = $('#mail').val();
		let s_name = $('#name').val();;
		let s_id = $('#myid').val();
		let menu = $('#mymenu').val();
		let price = $('#amount').val();
		let s_addr = $('#addr').val();
		let s_phone = $('#tel').val();
		let rno = $('#restno').val();
		let mno = $('#mymno').val();
		let omprice = $('#amount').val();
		let omenu = $('#mymenu').val();
		let quantity = 1;
		let request = $('#rq').val();
		
		//alert(m_email +s_name +s_addr +s_phone +s_msg +s_zipNo);
			
		var IMP = window.IMP; // 생략가능
		IMP.init('imp64825572');	//아임포트 관리자계정
		//결제 시스템을 실행시키는 함수
	  	IMP.request_pay({
	  		pg: 'kakaopay',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),	//	주문번호
			name: menu,
			amount: price,	//테스트 완료 후 가격정보 넣기
			buyer_email: m_email,
			buyer_name: s_name,
			buyer_tel: s_phone,
			buyer_addr: s_addr,
			m_redirect_url: '/payment/afterPay'
			}, function (rsp) {
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
					let payVo = {
						m_email: m_email,
						r_rno : rno,
						s_id: s_id,
						ono: rsp.merchant_uid,
						oprice: rsp.paid_amount,
						ompirce : omprice,
						paym: rsp.pay_method,
						m_mno : mno,
						omenu : omenu,
						quantity : quantity,
						request : request
						}
					// 컨트롤러에 데이터를 전달하여 DB에 입력하는 로직
	                		// 결제내역을 사용자에게 보여주기 위해 필요함.
	               			$.ajax({
						url : "/deli/payment/payProc.dlv",
						type : "post",
						data : payVo,
						dataType : "json",
						success : function(result){
							if(result.result == "y") {
								alert('proc 성공!!!');
								$('#pageFrm').attr('action','/deli/payment/afterPay.dlv');
								$('#pageFrm').submit();
							}else{
								alert("디비입력실패" + result.result);
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
	
	$('#cbtn').click(function(){
		
	});
});