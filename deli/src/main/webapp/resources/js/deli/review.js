$(document).ready(function() {
	
	$('#hbtn').click(function() {
		$(location).attr('href',  '/deli/main.dlv');
	});
	
	$('.libtn').click(function() {
		$(location).attr('href',  '/deli/member/login.dlv');
	});
	
	$('#lobtn').click(function() {
		$(location).attr('href',  '/deli/member/logout.dlv');
	});
	
	$('.bbtn').click(function() {
		$(location).attr('href',  '/deli/find/idFind.dlv');
	});
	
	$('label').mouseup(function() {
		let point = $(this).prev().val();
		
		$(this).siblings().first().text(point);
		
		$('#sbtn').click(function() {
			$(document.frm.nesti).val(point);
			
			$('#frm').submit();
		});
	})

});