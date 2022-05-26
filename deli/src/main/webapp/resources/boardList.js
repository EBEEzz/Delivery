$(document).ready(function(){
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/deli/main.dlv');
	});
	
	$('.pbtn').click(function(){
		var pno = $(this).attr('id');
		var pctiy = $('')
		$('#nowPage').val(pno);
		$('#pageFrm').submit();
	});
	
	$('.w33').click(function(){
		$('#search').val('');
		var city = $(this).val();
		$('#maincity').val(city);
		$('#frm').submit();
	});
	
	$('#searchbtn').click(function(){
		$('#check option:selected').val();
		$('#frm').submit();
	});
	
	$('.brdList').click(function(){
		var pno = $(this).attr('id');
		$(document.brdfrm.bno).val(pno);
		$('#brdfrm').submit();
	})
});