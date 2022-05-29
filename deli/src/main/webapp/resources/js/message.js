$(document).ready(function(){
	$('.w33').click(function(){
		
		var city = $(this).val();
		$('#city').val(city);
		
		
		
		$('#frm').submit();
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
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/deli/main.dlv');
	});

});