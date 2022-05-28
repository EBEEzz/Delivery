<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성</title>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/star.css">
<script type="text/javascript" src="/deli/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/deli/resources/js/deli/review.js"></script>
<style type="text/css">
	.avtround {
		width: 40px;
		height: auto;
		border-radius: 50px;
		margin-left: 30px;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="w3-top">
	  	<div class="w3-row w3-padding w3-black">
		    <div class="w3-col s2">
		    	<div class="w3-button w3-block w3-black" id="hbtn">HOME</div>
		    </div>
		    <div class="w3-col s8">
		      	<div class="w3-block w3-black w3-center">&nbsp;</div>
		    </div>
<c:if test="${SID eq null}">
		    <div class="w3-col s2">
		      	<div class="w3-button w3-block w3-black libtn">LOGIN</div>
	    	</div>
</c:if>
<c:if test="${SID ne null}">
		    <div class="w3-col s2">
		      	<div class="w3-button w3-block w3-black" id="lobtn">LOGOUT</div>
	    	</div>
</c:if>
	  	</div>
	</div>
	
	<div class="w85p w3-display-middle border3px" style="position: relative; top: 95px;">
		<h1 class="w3-center"><b>Delivery Project</b></h1>
	</div>
	<form method="POST" action="/deli/review/rvWriteProc.dlv" name="frm" id="frm">
		<input type="hidden" name="nesti" id="nesti">
		<input type="hidden" name="idb" id="idb">
	</form>
	<div class="w3-display-middle w3-border w3-padding w3-col m8">
    	<div class="w3-container mgt10 mgb20 w3-black">
      		<h3 class="w3-margin-right"><strong>Delivery 경험을 공유해주세요!</strong></h3>
    	</div>
    	<div class="w3-container w3-padding-16 mgt20">
        	<div class="w3-row-padding" style="margin:0 -16px;">
          		<div class="w3-margin-bottom pb20">
          			<div class="w3-col w3-white w3-round-large pd15">
<c:if test="${ldata.id ne null}">
						<div class="w3-col w3-grey w3-center w3-border">
							<div class="w3-col">
								<div class="w3-col m4"><b>아이디</b></div>
								<div class="w3-col m4 w3-border-left w3-border-right"><b>별  점</b></div>
								<div class="w3-col m4"><b>코멘트</b></div>
							</div>
						</div>
</c:if>
<c:if test="${ldata.id eq null}">
								<div class="w3-center w3-padding">
									<b class="txt16">더이상 작성할 후기가<br>남아있지 않아요 <span style="font-size: 1.2em;">🍳</span></b>
								</div>
</c:if>
<c:forEach var="ldata" items="${LLIST}">
						<div class="w3-col w3-white w3-center w3-border">
							<div class="w3-col mgt10 mgb10">
								<div class="w3-col m4">
									<img src="/deli/resources/upload/${ldata.savename}" class="inblock w3-left avtround w3-border w3-border-grey">
									<b style="position: relative; top: 10px;">${ldata.id}</b>
								</div>
								<fieldset class="w3-col m4 mg0 pd0 w3-border-left w3-border-right">
									<legend id="${ldata.id}li">
									 	<span class="spanft" id="${ldata.id}">&nbsp;&nbsp;</span>
										<input type="radio" name="${ldata.id}rating" value="5" id="${ldata.id}rate5"><label for="${ldata.id}rate5">🥄</label><!--
									 --><input type="radio" name="${ldata.id}rating" value="4" id="${ldata.id}rate4"><label for="${ldata.id}rate4">🥄</label><!--
									 --><input type="radio" name="${ldata.id}rating" value="3" id="${ldata.id}rate3"><label for="${ldata.id}rate3">🥄</label><!--
									 --><input type="radio" name="${ldata.id}rating" value="2" id="${ldata.id}rate2"><label for="${ldata.id}rate2">🥄</label><!--
									 --><input type="radio" name="${ldata.id}rating" value="1" id="${ldata.id}rate1"><label for="${ldata.id}rate1">🥄</label>
									 </legend>
								</fieldset>
								<input class="w3-col m4 w3-input w3-border w3-round-large w3-light-grey"
										type="text" placeholder="">
							</div>
						</div>
</c:forEach>
					</div>
          		</div>
        	</div>
<c:if test="${ldata.id ne null}">
       		<div class="h20 ft12">
        		<div class="w3-quarter w3-right w3-button w3-round-large w3-dark-grey w3-margin-top" id="sbtn">제출</div>
       		</div>
</c:if>
    	</div>
  	</div>
</body>
</html>