<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.*,dao.*,vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "dao" class = "dao.delipDAO"/>
<jsp:useBean id = "vo" class = "vo.delipVO"/>
<%
	ArrayList<delipVO> list = dao.select();
	request.setAttribute("list", list);


%>
<html>
<head>
<title>현재 위치</title>
<link rel="stylesheet" type="text/css" href="../1.mapSearch/mapSearch.css">
</head>

<body>
		<div class="map_wrap">
			<div id="map"
				style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
		
			<div class="hAddr">
				<span class="title">현위치 : <span class="title" id="centerAddr"></span></span>
	</div>
				
	</div>
	<c:forEach items = "${list}" var = "list" >
	<script>
	let imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	let lon = [];
	let lan = [];
	for(let i = 0; i<list.length;i++){
			lon[i] = list.lon;
			lan[i] = list.lan;
	};
    
	let positions = [];
		for(let i = 0;i<list.length;i++){
			positions[i] = new kakao.maps.LatLng(lon[i],lan[i]);
            let imageSize = new kakao.maps.Size(24, 35); 
    
            // 마커 이미지를 생성합니다    
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
        };

        let marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 

	</script>
	</c:forEach>
	<br>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73&libraries=services"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
	<script type="text/javascript"
		src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
	<script src="../1.mapSearch/mapSearch.js">	</script>
</body>
</html>