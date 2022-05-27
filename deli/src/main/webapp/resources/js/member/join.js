$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href','/deli/main.dlv')
	});
	
	$('#id').change(function(){
		var sid = $('#id').val();
		
		if(!sid){
			// 입력내용이 없는 경우
			$('#id').focus();
			$('#idmsg').css('display', 'block');
			$('#idmsg').addClass('w3-text-red');
			$('#idmsg').html('아이디를 입력하세요!');
			return;
		}
		// 전달해서 사용가능 유무 판단하고
		$.ajax({
			url:'/deli/member/idCheck.dlv',
			type: 'post',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data){
				var result = data.result;
				$('#idmsg').removeClass('w3-text-green w3-text-red');
				
				// 뷰에 보여주고
				if(result == 'OK'){
					// 입력한 아이디가 사용가능한 경우
					$('#idmsg').html('* 사용 가능한 아이디 입니다! *');
					$('#idmsg').addClass('w3-text-green');
				} else {
					// 입력한 아이디가 사용불가능한 경우
					$('#idmsg').html('* 사용 불가능한 아이디 입니다! *');
					$('#idmsg').addClass('w3-text-red');
				}
				$('#idmsg').css('display', 'block');
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
	
	// 비밀번호 입력 이벤트
	$('#repw').keyup(function(){
		// 할일
		// 입력된 데이터를 읽어온다.
		var pw = $('#pw').val();
		var repw = $(this).val();
		if(pw != repw){
			$('#repwmsg').html('# 비밀번호가 일치하지 않습니다.');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
			$('#repwmsg').css('display', 'block');
		} else {
			$('#repwmsg').html('* # 비밀번호가 일치합니다. *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
			$('#repwmsg').parent().stop().slideDown(300).stop().slideUp(300);
			$('#pw').css('background-color', 'lightgray').prop('readonly', true);
		}
	});
	
	$('#proimg').change(function(e){
		var sfile = $(this).val();
		var path = '/deli/resources/img/avatar/noimage.jpg';
		if(sfile){
			var path = URL.createObjectURL(e.target.files[0]);
		}
		$('#img').attr('src', path);
	});
	
	$('#jbtn').click(function(){
		// 데이터 유효성 검사
		var name = $('#name').val();
		var id = $('#id').val();
		var kakaoid = $('kakaoid').val();
		var pw = $('#pw').val();
		var mail = $('#mail').val();
		var tel = $('#tel').val();
		var addr = $('#addr').val();
		
		var el = $('#name, #id, #kakaoid, #pw, #mail, #tel, #addr');
		
		for(var i = 0; i < el.length; i++){
			var txt = $(el).eq(i).val();
			if(!txt){
				alert('# 누락된 정보가 있습니다!');
				$(el).eq(i).focus();
				return;
			}
		}
		
		$('#frm').attr('action', '/deli/member/joinProc.dlv').submit();
	});
	
});