<%@page language = "java" contentType = "text/html; charset=UTF-8"
pageEncoding = "UTF-8"  import = "java.util.*,dao.*,vo.*"%>



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
 <link rel="stylesheet" type="text/css" href="mapSearch.css">
    
</head>
 <body>
         <center>
         <h2>나의 현재 위치</h2>
          <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73&libraries=services"></script>
                       
                    <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
                   
    			
                <h2>나의 현위치</h2>
 					
                  <div class="map_wrap">
                    <div id="map"
                        style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
				
                    <div class="hAddr">
                        <span class="title"> 현재 위치 <span class="title" id="centerAddr"></span></span>
                 
                    </div>
                
                </div>
                <span id = "id" name ="id" value = <%=request.getParameter("id") %>></span>
                
				 <%=request.getParameter("cusid") %> 님의 현재 위치는 : [<span id = "myAddress"></span>] 입니다.
              			<form action = "../2.meetSearch/meetSearch.jsp">
              			<input type = "hidden" id = "cusid" name = "cusid" value =<%=cusid%> readonly>
              			<input type = "hidden" id = "cus_lat" name = "cus_lat" value =<%=cus_lat%> readonly>
              			<input type = "hidden" id = "cus_lon"name = "cus_lon" value =<%=cus_lon%> readonly>
              			<input type = "submit" value = "픽업 장소찾기">
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
              <script src = "mapSearch.js"></script>
</center>
</body>
</html>