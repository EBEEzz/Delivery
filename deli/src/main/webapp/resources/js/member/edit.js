$(document).ready(function(){
	$('#name, #id, #kakaoid, #tel, #addr, #mail').css('background-color', 'lightgray').prop('readonly', true);
	// reset 버튼 클릭 이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
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
		} else {
			$('#repwmsg').html('* 변경될 비밀번호가 일치합니다. *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
			$('#repwmsg').parent().stop().slideDown(300).stop().slideUp(300);
			$('#newpw').css('background-color', 'lightgray').prop('readonly', true);
		}
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
		
		// 보낼 주소 설정하고
		$('#frm').attr('action', '/deli/member/editProc.dlv');
		$('#frm').submit();
	});

});