$(document).ready(function(){
	$('#name, #id, #kakaoid, #tel, #addr, #mail').css('background-color', 'lightgray').prop('readonly', true);
	// reset 버튼 클릭 이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
		if($('#newpw').css('background-color', 'lightgray').prop('readonly', true)){
			$('#newpw').css('background-color', 'white').prop('readonly', false);
			$('#repwmsg').parent().stop().slideUp(500).stop().slideDown(500);
		}
		if($('#newpw, #repw, #newmail, #newtel, #newaddr').prop('disabled', true)){
			$('#newpw, #repw, #newmail, #newtel, #newaddr').prop('disabled', false);
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
		if($('#npwmsg').css('display', 'block')){
			$('#npwmsg').css('display', 'none');
		}
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
		var repw = $('#repw').val();
		var spw = $('#pw').val();
		var spwck = $('#pwck').val();

		if(repw != npw){
			$('#newpw').focus();
			$('#repwmsg').html('변경될 비밀번호가 일치하지 않습니다.');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
			$('#repwmsg').css('display', 'block');
			return;
		}
		if(!npw){
			$('#newpw').prop('disabled', true);
			$('#repw').prop('disabled', true);
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
		
		if(!npw && !nmail && !ntel && !naddr){
			// 수정을 한개도 하지 않는 경우..
			alert('수정한 내용이 없습니다.');
			return;
		}
		
		// 기존 비밀번호 확인 처리
		if(!spw){
			// 입력내용이 없는 경우
			$('#pw').focus();
			$('#pwmsg').css('display', 'block');
			$('#pwmsg').addClass('w3-text-red');
			$('#pwmsg').html('기존 비밀번호를 입력하세요!');
			return;
		} else if(spw != spwck){
			// 기존 비밀번호와 다른 경우
			$('#pw').focus();
			$('#pwmsg').css('display', 'block');
			$('#pwmsg').addClass('w3-text-red');
			$('#pwmsg').html('기존 비밀번호와 다릅니다!');
			return;
		} else if(npw == spwck){
			$('#newpw').focus();
			$('#npwmsg').css('display', 'block');
			$('#npwmsg').addClass('w3-text-red');
			$('#npwmsg').html('기존 비밀번호와 같은 비밀번호는 입력할 수 없습니다');
			return;
		}
		
		// 정규 표현식 검사
/*		var telPattern = /\d{2,3}[- ]?\d{3,4}[- ]?\d{4}/g;
		var teltest = telPattern.match(ntel);
		alert(teltest);*/

		// 보낼 주소 설정하고
		$('#frm').attr('action', '/deli/member/editProc.dlv');
		$('#frm').submit();
	});

});