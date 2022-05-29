$(document).ready(function(){
	if($('#sendtest').val() == 1){
		alert('메세지 전송 실패')
	}
	
	$('.w33').click(function(){
		
		var city = $(this).val();
		$('#city').val(city);
		
		$('#frm').submit();
	});
	
	
	$('#obtn').click(function(){
		$(location).attr('href', '/deli/member/logout.dlv');
	});	
	$('#hbtn').click(function(){
		$(location).attr('href', '/deli/main.dlv');
	});
	
	$('#mymess').click(function(){
		$(location).attr('href', '/deli/message.dlv');
	})
	$('#send').click(function(){
		$(location).attr('href', '/deli/msform.dlv');
	});
	
	$('#sendmessage').click(function(){
		$('#mesfrm').submit();
	});
});