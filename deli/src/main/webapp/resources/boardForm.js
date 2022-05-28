$(document).ready(function(){
	var res = $('#result').val();
	if(res == 'success'){
		alert('접수에 성공하였습니다.');
	} else if(res == 'false'){
		alert('이미 접수하셨습니다.');
	} else if(res == 'fail') {
		alert('접수에 실패하였습니다.');
	}
	var canres = $('#cancleresult').val();

	if(canres == 'success') {
		alert('접수 취소되었습니다.');
	} else if (canres == 'fail') {
		alert('접수 취소에 실패하였습니다.');
	} else if (canres == 'false') {
		alert('지원자가 아닙니다.');
	} 
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/deli/main.dlv');
	});
	
	$('.pbtn').click(function(){
		var pno = $(this).attr('id');
		var pctiy = $('')
		$('#nowPage').val(pno);
		$('#pageFrm').submit();
	});
	
	$('.w33').click(function(){
		$('#search').val('');
		var city = $(this).val();
		$('#maincity').val(city);
		$('#frm').submit();
	});
	
	$('#searchbtn').click(function(){
		$('#check option:selected').val();
		$('#frm').submit();
	});
	
	$('.brdList').click(function(){
		var pno = $(this).attr('id');
		$(document.brdfrm.bno).val(pno);
		$('#brdfrm').submit();
	});
	

	
		
		function CountDownTimer(dt, id) {
	    var end = new Date(dt);
	    var _second = 1000;
	    var _minute = _second * 60;
	    var _hour = _minute * 60;
	    var _day = _hour * 24;
	    var timer;
	    function showRemaining() {
	        var now = new Date();
	        var distance = end - now;
	        if (distance < 0) {
	            clearInterval(timer);
	             $('#subbtn').css('display', 'none');
	             document.getElementById(id).innerHTML = '마감';
	            return;
	        }
	        var days = Math.floor(distance / _day);
	        var hours = Math.floor((distance % _day) / _hour);
	        var minutes = Math.floor((distance % _hour) / _minute);
	        var seconds = Math.floor((distance % _minute) / _second);
	        document.getElementById(id).innerHTML = '마감까지 : ' + days + '일 ';
	        document.getElementById(id).innerHTML += hours + '시간 ';
	        document.getElementById(id).innerHTML += minutes + '분 ';
	        document.getElementById(id).innerHTML += seconds + '초';
	    }
	    timer = setInterval(showRemaining, 1000);
	}
	var time = $('.ctdw').attr('id');
	var end = new Date(time);
	var now = new Date();
	var distance = end - now;
	if (distance > 0){
		CountDownTimer(time, 'id');
	}

	$('#subbtn').click(function(){
		$('#cancle').val('');
		$('#pageFrm').submit();
	});
	
	$('#conbtn').click(function(){
	
		if($('#alertmember').html() == undefined) {
			alert('지원자가 없습니다.');
		}
		
		$('#regimem').slideToggle();

	});
	
	$('#canclebtn').click(function(){
		$('#cancle').val('cancle');
		$('#pageFrm').submit();
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/deli/member/logout.dlv');
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/deli/member/login.dlv');
	});
	
	var price = 0;
	var subprice = 0;
	var mname= '';
	$('.pricebtn1').click(function(){
<<<<<<< HEAD
		
		if(confirm('을 빼시겠습니까?')) {
			var mprice = 0;
			mprice = $(this).parent().attr('id')
			mname = $(this).attr('id');
=======
		var menu = $('.mname').attr('id');
		var mprice = 0;
		mprice = $(this).attr('id');
		if(confirm('메뉴를 제외하시겠습니까?')) {
			if(price - mprice < 0) {
				alert('해당 주문건을 취소할 수 없습니다. 주문하신 옵션을 확인해주세요.');
				return;	
			}
>>>>>>> branch 'branch' of https://github.com/EBEEzz/Delivery.git
			price = price - mprice;
<<<<<<< HEAD
			subprice = price/mprice;
			alert('subprice = ' + subprice);
			alert('price = ' +price);
			subprice = parseInt(subprice);
			
			if(subprice = 0) {
				$('#abc *').remove();
			} else {
				$('#abc *').remove();
				
				$('#abc').append('<p>'+ mname + '<span>'+ subprice +'<span>'  +'<p>');

			}
			
=======
		
>>>>>>> branch 'branch' of https://github.com/EBEEzz/Delivery.git
		}
	});
	
<<<<<<< HEAD
	$('.pricebtn2').on("click", function(){
		if(confirm('을 추가하시겠습니까?')) {
=======
	$('.pricebtn2').click(function(){
		
		var menu = $('.mname').attr('id');
		if(confirm('메뉴를 추가하시겠습니까?')) {
>>>>>>> branch 'branch' of https://github.com/EBEEzz/Delivery.git
			var mprice = 0;
			mprice = $(this).parent().attr('id')
			mprice = parseInt(mprice);
			price = price -(- mprice);
<<<<<<< HEAD
			subprice = price/mprice;
			
			mname = $(this).attr('id');
			
			alert('subprice = ' + subprice);
			subprice = parseInt(subprice);
			
			if(subprice = 1) {
			
				$('#abc').append('<p>'+ mname + '<span>'+ subprice +'<span>'  +'<p>');
				
			} else if(subpirce > 1) {
				$('#abc').eq(subprice).html(subprice);
				
			}
			mname = mname + ' 외 ' + subprice + ' 건';
=======
		
>>>>>>> branch 'branch' of https://github.com/EBEEzz/Delivery.git
		}
	});
	
	$('.fbtn').click(function(){
		var fmno = $(this).attr('id');
		$.ajax({
			url: '/deli/friend.dlv',
			type: 'POST',
			dataType: 'JSON',
			data: {fmno : fmno},
			success: function(data){
				if(data.result == 'OK'){
					alert('친구 신청 처리 되었습니다.');
				} else if(data.result == 'AL') {
					alert('이미 친구 신청 요청되었습니다.');
				} else {
					alert('친구 신청 요청이 처리되지 않았습니다.');
				}
			},
			error: function(){
				alert('접속 에러');
			}
			
		})
	})
	
	
	$('#paybtn').click(function(){
		$('#1mname').val(mname);
		$('#1price').val(price);
		alert(price);
		$('#pageFrm').attr('action','/deli/payment/beforePay.dlv');
		$('#pageFrm').submit();
	});
});