$(document).ready(function(){
	$('#name, #id, #kakaoid, #tel, #addr, #mail').css('background-color', 'lightgray').prop('readonly', true);
	// reset 버튼 클릭 이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
		if($('#newpw').css('background-color', 'lightgray').prop('readonly', true)){
			$('#newpw').css('background-color', 'white').prop('readonly', false);
			$('#repwmsg').parent().stop().slideUp(500).stop().slideDown(500);
		}
	});
	// 홈버튼 클릭이벤트
	$('#hbtn').click(function(){
		$(location).attr('href','/deli/main.dlv');
	});
	
	// 비밀번호 입력 이벤트
	$('#repw').keyup(function(){
		// 할일
		// 입력된 데이터를 읽어온다.
		var newpw = $('#newpw').val();
		var repw = $(this).val();
		if(newpw != repw){
			$('#repwmsg').html('변경될 비밀번호가 일치하지 않습니다.');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
			$('#repwmsg').css('display', 'block');
		} else if(newpw == repw && newpw != "") {
			$('#repwmsg').html('* 변경될 비밀번호가 일치합니다. *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
			$('#repwmsg').parent().stop().slideDown(500).stop().slideUp(500);
			$('#newpw').css('background-color', 'lightgray').prop('readonly', true);
		}
	});
	
	$('#newpw').click(function(){
		$('#newpw').css('background-color', 'white').prop('readonly', false);
		$('#repwmsg').parent().stop().slideUp(500).stop().slideDown(500);
		return;
	});

	$('#proimg').change(function(e){
		var sfile = $(this).val();
		var path = '/deli${DATA.dir}/${DATA.oriname}';
		if(sfile){
			var path = URL.createObjectURL(e.target.files[0]);
		}
		$('#img').attr('src', path);
	});
	// 수정버튼 클릭이벤트
	$('#ebtn').click(function(){
		// 할 일
		// 수정된 데이터를 알아낸다.
		// 받은 데이터를 꺼내온다.
		var npw = $('#newpw').val();
		var nmail = $('#newmail').val();
		var ntel = $('#newtel').val();
		var naddr = $('#newaddr').val();
		
		if(!npw){
			$('#pw').prop('disabled', true);
			$('#repw').css('display', 'none');
		};
		
		if(!nmail){
			// 메일이 수정 안된경우
			$('#newmail').prop('disabled', true);
		/*	$('#newmail').val($('#mail').val());*/
		}
		
		if(!ntel){
			$('#newtel').prop('disabled', true);
		}
		
		if(!naddr){
			$('#newaddr').prop('disabled', true);
		}
		
		if(!npw && (nmail == mail) && (ntel == tel) && (naddr == addr)){
			// 수정을 한개도 하지 않는 경우..
			alert('아무것도 수정안함...');
			return;
		}
		// 기존 비밀번호 확인 처리
		var spw = $('#pw').val();
		
		if(!spw){
			// 입력내용이 없는 경우
			$('#pw').focus();
			$('#pwmsg').css('display', 'block');
			$('#pwmsg').addClass('w3-text-red');
			$('#pwmsg').html('기존 비밀번호를 입력하세요!');
			return;
		}
		// 전달해서 사용가능 유무 판단하고
		$.ajax({
			url:'/deli/member/pwCheck.dlv',
			type: 'post',
			dataType: 'json',
			data: {
				pw: spw
			},
			success: function(data){
				var result = data.result;
				alert(result);
				$('#pwmsg').removeClass('w3-text-green w3-text-red');
				
				if(spw != result){
					$('#pw').focus();
					$('#pwmsg').css('display', 'block');
					$('#pwmsg').addClass('w3-text-red');
					$('#pwmsg').html('기존 비밀번호와 다릅니다!');
					return;
				}
				// 뷰에 보여주고
				if(result == 'OK'){
					// 입력한 아이디가 사용가능한 경우
					$('#pwmsg').html('* 사용 가능한 아이디 입니다! *');
					$('#pwmsg').addClass('w3-text-green');
				} else {
					// 입력한 아이디가 사용불가능한 경우
					$('#pwmsg').html('* 사용 불가능한 아이디 입니다! *');
					$('#pwmsg').addClass('w3-text-red');
				}
				$('#pwmsg').css('display', 'block');
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
		// 보낼 주소 설정하고
		$('#frm').attr('action', '/deli/member/editProc.dlv');
		$('#frm').submit();
	});

});