$(document).ready(function(){
	$('#sbtn').click(function(){
		$(location).attr('href', '/deli/boardList.dlv')
	});
	
	$('#subbtn').click(function(){
		var cbody = $('#body').val();
		var cmno = 1001;
		$.ajax({
			url: '/deli/chatProc.dlv',
			type: 'POST',
			dataType: 'json',
			data: {
				mno: cmno,
				body: cbody
				
			},
			success: function(data){
				var result = data.result;
				if(result == 'OK') {
				}
			},
			error: function(){
				alert('##접속 오류');
			}
		});
		
	});
/*
$('#chat').scrollTop($('#chat').prop('scrollHeight'));
	setInterval(function(){
		$.ajax({
			url: '/deli/chatProc.dlv',
			type: 'POST',
			dataType: 'json',
			asyns: false,
			data: {

			},
			success: function(data){
				if(data.id != 'null') {
					if($('#idck').val() == data.cmno) {
						$('#chat').append('<h4 style="text-align: right;font-size: 17pt; color:blue;"><i>' + data.id + ' : ' + data.body + '</i>&nbsp;&nbsp;<small>' + data.date + '</small></h4>');
					} else {
						$('#chat').css('text-align', 'left');
						$('#chat').append('<h4>' + data.id + ' : ' + data.body + '&nbsp;&nbsp;<small>' + data.date + '</small></h4>');
						}
				}
				$('#chat').scrollTop($('#chat').prop('scrollHeight'));
			},
			error: function(){
				alert('##접속 오류');
			}
		})
		
	}, 2000);

	$('#jbtn').click(function(){
		$.ajax({
			url: '/deli/chatProc.dlv',
			type: 'POST',
			dataType: 'json',
			asyns: false,
			data: {

			},
			success: function(data){
				if(data.id != 'null') {
					if($('#idck').val() == data.cmno) {
						$('#chat').append('<h4 style="text-align: right;font-size: 17pt; color:blue;"><i>' + data.id + ' : ' + data.body + '</i>&nbsp;&nbsp;<small>' + data.date + '</small></h4>');
					} else {
						$('#chat').css('text-align', 'left');
						$('#chat').append('<h4>' + data.id + ' : ' + data.body + '&nbsp;&nbsp;<small>' + data.date + '</small></h4>');
						}
				}
				$('#chat').scrollTop($('#chat').prop('scrollHeight'));
				
			},
			error: function(){
				alert('##접속 오류');
			}
		});
	});
*/
/*
	var webSocket = new WebSocket("ws://localhost/deli/websocket");
	var chatbox = document.getElementById("chatbox");
	webSocket.onopen = function(content) {
		chatbox.value += "서버와 연결되었습니다.\n";
	};

	webSocket.onclose = function(content) {
		chatbox.value += "Server Disconnect...\n";
	};

	webSocket.onerror = function(content) {
		chatbox.value += "error...\n";
	};

	webSocket.onmessage = function(content) {
		chatbox.value += "내가 보낸 메세지 => "+content.data+"\n";
	};

	$('#sendbtn').click(function sendMessage() {
		var message = document.getElementById("content");
		webSocket.send(message.value);
		message.value = "";
	});
*/
	var webSocket = new WebSocket('ws://localhost/deli/deliChat');
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
		// 콘솔 텍스트에 메시지를 출력한다.
		chatbox.value += id.value + '(나의 메세지) ' + chat.value + '\n';
		
		// WebSocket 서버에 메시지를 전송(형식 「{{유저명}}메시지」)
		webSocket.send('{{' + id.value + '}}' + chat.value);
		// 송신 메시지를 작성한 텍스트 박스를 초기화한다.
		chat.value = '';
		$('#chatbox').scrollTop($('#chatbox').prop('scrollHeight'));
	}

	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/deli/member/login.dlv')
	});

});