/**
 * @author	이용현
 * @since	2022/05/28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 								담당자 : 이용현
 */

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
		$(document.pageFrm.bno).val(pno);
		$('#pageFrm').attr('action', '/deli/boardForm.dlv');
		$('#pageFrm').submit();
	})
	
	$('#obtn').click(function(){
		$(location).attr('href', '/deli/member/logout.dlv');
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/deli/member/login.dlv');
	});
});