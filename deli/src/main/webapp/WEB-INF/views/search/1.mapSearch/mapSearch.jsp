<%@page language = "java" contentType = "text/html; charset=UTF-8"
pageEncoding = "UTF-8"  import = "com.githrd.deli.dao.*"%>

<%
	pplaceDAO dao = new pplaceDAO();
	
	String cusid = request.getParameter("cusid");
	double cus_lat = dao.chooseId(request.getParameter("cusid"),1);
	double cus_lon = dao.chooseId(request.getParameter("cusid"),2);
%>

<html>
<head>
    <meta charset="utf-8">
    <title>내 현위치</title>
<script type="text/javascript" src="/deli/resources/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/deli/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/user.css">
<link rel="stylesheet" type="text/css" href="/deli/resources/css/w3.css">
<script type="text/javascript" src="/deli/resources/js/member/myInfo.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73&libraries=services"></script>          
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
<script type="text/javascript" src ="/deli/resources/mapSearch.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

 <link rel="stylesheet" type="text/css" href="mapSearch.css">
    
</head>
 <body>
  

         
                   
    			
                <h2>나의 기본 수령지</h2>
 					
                  <div class="map_wrap">
                    <div id="map" style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
				
                    <div class="hAddr">
                        <span class="title"> 현재 위치 <span class="title" id="centerAddr"></span></span>
                    </div>
                </div>
               <%--  <input id ="id" name="id" value= <%=request.getParameter("id") %>></input> --%>
                
				<%=request.getParameter("cusid") %> 님의 기본 수령지는 : [<span id = "myAddress"></span>] 입니다.
              			<form action = "../2.meetSearch/meetSearch.jsp">
              			<%-- <input type = "hidden" id = "cusid" name = "cusid" value =<%=cusid%> readonly> --%>
              			<input type = "hidden" id = "cus_lat" name = "cus_lat" value =<%=cus_lat%> readonly>
              			<input type = "hidden" id = "cus_lon"name = "cus_lon" value =<%=cus_lon%> readonly>
              			<!-- <input type = "submit" value = "픽업 장소찾기"> -->
              			</form>
<script>
          	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
              mapOption = { 
          		
          	    center: new kakao.maps.LatLng(<%=cus_lon%>,<%=cus_lat%>), // 지도의 중심좌표
                  level: 3 // 지도의 확대 레벨
              };
  
          	let cus_lat =  Number(document.getElementById("cus_lat").value);
          	let cus_lon = Number(document.getElementById("cus_lon").value);
              
          	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
          	var markerPosition = new kakao.maps.LatLng(cus_lat, cus_lon);

</script>


</body>
</html>