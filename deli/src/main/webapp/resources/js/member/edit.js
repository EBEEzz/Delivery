$(document).ready(function(){
	$('#name, #id, #kakaoid, #tel, #addr').css('background-color', 'lightgray').prop('readonly', true);
	// reset 버튼 클릭 이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	// 홈버튼 클릭이벤트
	$('#hbtn').click(function(){
		$(location).attr('href','/deli/main.dlv');
	});
	
	// 비밀번호 입력 이벤트
	$('#repw, #pw, #newpw').keyup(function(){
		// 할일
		// 입력된 데이터를 읽어온다.
		var pw = $('#pw').val();
		var newpw = $('#newpw').val();
		var repw = $('#repw').val();
		if(pw == newpw){
			$('#pwmsg').html('기존과 동일한 비밀번호로 수정할 수 없습니다.');
			$('#pwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
			$('#pwmsg').css('display', 'block');
		} else if(newpw != repw) {
			$('#repwmsg').html('변경될 비밀번호가 일치하지 않습니다.');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
			$('#repwmsg').css('display', 'block');
		} else if (newpw != null == repw){
			$('#repwmsg').html('* # 비밀번호가 일치합니다. *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
			$('#repwmsg').parent().stop().slideDown(300).stop().slideUp(300);
			$('#newpw').css('background-color', 'lightgray').prop('readonly', true);
		}
	});
/*	
	// 수정버튼 클릭이벤트
	$('#ebtn').click(function(){
		// 할 일
		// 수정된 데이터를 알아낸다.
		// 받은 데이터를 꺼내온다.
		var tmail = $('#newmail').val();
		var ttel = $('#newtel').val();
		var pw = $('pw').val();
		var mail = $('#mail').val();
		var tel = $('#tel').val();
		
		if(!pw){
			$('#pw').prop('disabled', true);
		};
		
		if(tmail == mail){
			// 메일이 수정 안된경우
			$('#mail').prop('disabled', true);
		}
		
		if(ttel == tel){
			$('#tel').prop('disabled', true);
		}
		
		if(tano == ano){
			$('[name="ano"]').prop('disabled', true);
		}
		
		if(!pw && (tmail == mail) && (ttel == tel) && (tano == ano)){
			// 수정을 한개도 하지 않는 경우..
			alert('아무것도 수정안함...');
			return;
		}
		
		// 보낼 주소 설정하고
		$('#frm').attr('action', '/whistle/member/editProc.blp');
		$('#frm').submit();
	});
*/	
});