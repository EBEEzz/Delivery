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

});