$(document).ready(function() {
	
	$('#hbtn').click(function() {
		$(location).attr('href',  '/deli/main.dlv');
	});
	
	$('.libtn').click(function() {
		$(location).attr('href',  '/deli/member/login.dlv');
	});
	
	$('.jbtn').click(function() {
		$(location).attr('href',  '/deli/member/join.dlv');
	});
	
	$('.pwbtn').click(function() {
		$(location).attr('href',  '/deli/find/pwFind.dlv');
	});
	
	$('#idbtn').click(function() {
		var smail = $('#fmail').val();
		if(!smail) {
			$('#fmail').focus();
			alert('이메일을 입력해주세요.');
			return;
		}
		$('#frm').submit();
		//alert(smail);
	});
	
	$('.bbtn').click(function() {
		$(location).attr('href',  '/deli/find/idFind.dlv');
	});
});