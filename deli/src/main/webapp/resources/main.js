$(document).ready(function(){
	$('.w33').click(function(){
		
		var city = $(this).val();
		$('#city').val(city);
		
		
		
		$('#frm').submit();
	});
	


	var webSocket = new WebSocket('ws://localhost/deli/main.dlv');
	var chatbox = document.getElementById('chatbox');
	
	webSocket.onopen = function(chat) {
		chatbox.value += '채팅하실 수 있습니다.\n';
	};
	
	webSocket.onclose = function(chat) {
		chatbox.value += '접속이 끊어졌습니다.\n';
	};
	webSocket.onerror = function(chat) {
		chatbox.value += '에러발생\n';
	};
	

	webSocket.onmessage = function(chat) {
		chatbox.value += chat.data + '\n';
	};
	
	$('#sendbtn').click(function sendMessage() {
		if(!$('#id').val()){
			alert('로그인이 필요합니다.');
			return;
		} else {
		var id = document.getElementById('id');
		var chat = document.getElementById('textMessage');
		
		chatbox.value += id.value + '(나의 메세지) ' + chat.value + '\n';
		webSocket.send('{{' + id.value + '}}' + chat.value);
		chat.value = '';
		$('#chatbox').scrollTop($('#chatbox').prop('scrollHeight'));
	}

	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/deli/member/logout.dlv');
	});
	$('#lbtn').click(function(){
		$(location).attr('href', '/deli/member/login.dlv');
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/deli/member/join.dlv');
	});
	
	$('.hotbtn').click(function(){
		var bno = $(this).attr('id');
		$('#bno').val(bno);
		$('#frm1').submit();
	})
	
	$('#friendbtn').click(function() {
		$('#fribox').slideToggle();
	});
	$('.delbtn').click(function(){
		if(confirm('정말 삭제하시겠습니까?')){
			var fmno = $(this).attr('id');
			$.ajax({
				url: '/deli/frienddel.dlv',
				type: 'POST',
				dataType: 'JSON',
				data: {fmno : fmno},
				success: function(data){
					if(data.result == 'OK'){
						alert('삭제에 성공하였습니다.');
						$(location).attr('href', '/deli/main.dlv')
					} else if(data.result == 'AL') {
						alert('삭제할 친구가 없습니다.');
					} else {
						alert('삭제에 실패하였습니다.');
					}
				},
				error: function(){
					alert('접속 에러');
				}
			})
		}
	})
	
		$('.agrbtn').click(function(){
			if(confirm('친구 요청을 수락하시겠습니까?')){
				var fmno = $(this).attr('id');
				$.ajax({
					url: '/deli/friendagr.dlv',
					type: 'POST',
					dataType: 'JSON',
					data: {fmno : fmno},
					success: function(data){
						if(data.result == 'OK'){
							alert('친구가 등록되었습니다.');
							$(location).attr('href', '/deli/main.dlv')
						} else {
							alert('친구등록에 실패하였습니다.');
						} 
					},
					error: function(){
						alert('접속 에러');
					}
				})
		}
	})
	
		$('.canbtn').click(function(){
			if(confirm('친구 요청을 거절하시겠습니까?')){
				var fmno = $(this).attr('id');
		
				$.ajax({
					url: '/deli/friendcan.dlv',
					type: 'POST',
					dataType: 'JSON',
					data: {fmno : fmno},
					success: function(data){
						if(data.result == 'OK'){
							alert('친구요청이 거절되었습니다.');
							$(location).attr('href', '/deli/main.dlv')
						} else {
							alert('친구요청 거절에 실패하였습니다.');
						} 
					},
					error: function(){
						alert('접속 에러');
					}
				})
		}
	})
	
	$('#myinfo').click(function(){
		$('#id01').css('display', 'block');
	})
	$('#esti').click(function(){
		$(location).attr('href', '/deli/review/rvWrite.dlv');
	})
	
		
});