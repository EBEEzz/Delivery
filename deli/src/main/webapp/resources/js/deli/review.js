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
		let idb = $(this).siblings().first().attr('id');
		let abno = $(this).parent().attr('id');
		
		$(this).siblings().first().text(point);
		
		$('#nesti').val(point);
		$('#idb').val(idb);
		$('#abno').val(abno);
		
		$('.sbtn').click(function() {
			alert('후기가 제출되었습니다!');
			$('#frm').submit();
		});
	});
	
	$('.sbtn').click(function() {
	});
	
	$('.rlist').click(function() {
		let bid = $(this).attr('id');
		
		$('#ridb').val(bid);
		$('#rfrm').submit();
	});

});