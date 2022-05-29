<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.*,vo.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	
	pplaceDAO dao = new pplaceDAO();
	
	double cus_lat = Double.parseDouble(request.getParameter("cus_lat"));
	double cus_lon = Double.parseDouble(request.getParameter("cus_lon"));
	
	List<pplaceVO> list = dao.seleID(request.getParameter("cusid"));
	request.setAttribute("list", list);

	
%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>만나는 장소</title>
                <link rel="stylesheet" type="text/css" href="meetSearch.css">
            </head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>

            <body>
         <center>
              
         <h2>장소 선택</h2>    
                <div id="staticMap" style="width:900px;height:400px;"></div>
                
                
                <script type="text/javascript"
                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
            <br>
             <span id = "cus_lat" value = <%=cus_lat %>></span>
               <span id = "cus_lon" value = <%=cus_lon %>></span>

               <table id="tableInfo">
                    <tr>
                        <th>장소명</th>
                        <th>위도</th>
                        <th>경도</th>
                        <th>거리(가까운 순)</th>
                        <th>선택(클릭)</th>
                    </tr>
                    <tr>
                        <c:forEach items="${list}" var="list">
                            <th>${list.cusname}</th>
                   		  <th>${list.pickuplat}</th>
                            <th>${list.pickuplon}</th>
                            <th>${list.distance}</th>
                            <th><button type = "button" onclick = "choosePlace('${list.cusname}');">버튼</button></th>
                    </tr>
                    </c:forEach>
                   
                </table>
       
                    
               <script>
               
        	   let cus_lat =document.getElementById("cus_lat").value;
        	   let cus_lon =document.getElementById("cus_lon").value;
        		
                          let lon_ar = new Array();
                          let lat_ar = new Array();
                           let name_ar = new Array();
                           
                           
                           <c:forEach items="${list}" var="list">
                           lon_ar.push(Number(${list.pickuplon}));
                           lat_ar.push(Number(${list.pickuplat}));
                           name_ar.push(${list.cusname});
                      		 </c:forEach>
                        
                           lon_ar.push(cus_lon);
                           lat_ar.push(cus_lat);
                           name_ar.push("내 위치");
                   			
                   			let idx = lon_ar.length;
                           let markers = new Array();
                           
                           for (let i = 0; i<=idx; i++) {
                               markers[i] =
                               {
                                   position: new kakao.maps.LatLng(lat_ar[i],lon_ar[i]),
                                   text: name_ar[i]
                               }
                           };
                         function choosePlace(place){
        	let idx = name_ar.indexOf(place);
        	location.href = "../3.resSearch/resSearch.jsp?lat="+lat_ar[idx]+"&lon="+lon_ar[idx];
        	
        }
               
               let staticMapContainer = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
                   staticMapOption = {
                       center: new kakao.maps.LatLng(<%=cus_lon%>,<%=cus_lat%>), // 이미지 지도의 중심좌표
                       level: 5, // 이미지 지도의 확대 레벨
                       marker: markers // 이미지 지도에 표시할 마커 
                   };

               // 이미지 지도를 생성합니다
               let staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
			
         
               </script>
            </center>
            </body>

            </html>