<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="dao.*,vo.*,java.util.*" %>
    <jsp:useBean id="dao" class="dao.delipDAO" />
    <jsp:useBean id="vo" class="vo.delipVO" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<delipVO> list = dao.select(); request.setAttribute("list", list);  %>


            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>만나는 장소</title>
                <link rel="stylesheet" type="text/css" href="meetSearch.css">
            </head>

            <body>
			<center>
			<h2>장소 선택</h2> 	
                <div id="staticMap" style="width:600px;height:500px;"></div>
                <script type="text/javascript"
                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
                <table id="tableInfo">
                    <tr>
                        <th>장소명</th>
                        <th>거리(가까운 순)</th>
                        <th>선택(클릭)</th>
                    </tr>
                    <tr>
                        <c:forEach items="${list}" var="list">
                            <th>${list.name}</th><br>
                            <th>${list.dist}</th><br>
                            <th><input type="button" id="place" value='${list.name}'+"선택" onclick="choose('${list.name}')"></th><br>
                    </tr>
                    </c:forEach>
                </table>


                <script>


                    let lon_ar = new Array();
                    let lat_ar = new Array();
                    let name_ar = new Array();

                    <c:forEach items="${list}" var="list">
                        lon_ar.push(${list.lon});
                        lat_ar.push(${list.lat});
                        name_ar.push('${list.name}');
                    </c:forEach>

                    lat_ar.push('126.930634125');
                    lon_ar.push('37.358989937500006');
                    name_ar.push('현 위치');
                    let markers = new Array();
                    for (let i = 0; i < lon_ar.length; i++) {
                        markers[i] =
                        {
                            position: new kakao.maps.LatLng(lon_ar[i], lat_ar[i]),
                            text: name_ar[i] // 
                        }
                    };

                    function choose(name) {

                        let idx = name_ar.indexOf(name);
                        window.location.href = 'https://map.kakao.com/link/to/' + name + ',' + lon_ar[idx] + ',' + lat_ar[idx];
                    }


                    let staticMapContainer = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
                        staticMapOption = {
                            center: new kakao.maps.LatLng(37.358989937500006, 126.930634125), // 이미지 지도의 중심좌표
                            level: 4, // 이미지 지도의 확대 레벨
                            marker: markers // 이미지 지도에 표시할 마커 
                        };

                    // 이미지 지도를 생성합니다
                    let staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);





                </script>

</center>
            </body>

            </html>