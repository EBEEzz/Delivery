document.addEventListener("DOMContentLoaded",
    function () {
        //현재 위치의 위도, 경도 추출해주는 api
        navigator.geolocation.getCurrentPosition(function (position) {
            getLocation(position);//현재 위치 추출


        })
    });




function getLocation(position) {

    let latitud = position.coords.latitude;
    let longitude = position.coords.longitude;


    let mapContainer = document.getElementById('map'),    // 지도를 표시할 DIV
        mapOption = {
            center: new kakao.maps.LatLng(latitud, longitude)    // 지도의 중심좌표
            , level: 3    // 지도의 확대레벨
        };



    let map = new kakao.maps.Map(mapContainer, mapOption);
    var markerPosition = new kakao.maps.LatLng(latitud, longitude);




    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    let geocoder = new kakao.maps.services.Geocoder();
    // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
    searchAddrFromCoords(map.getCenter(), displayCenterInfo)
    function searchAddrFromCoords(coords, callback) {
        // 좌표로 행정동 주소 정보를 요청합니다
        geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
    }

    // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
    function displayCenterInfo(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            var infoDiv = document.getElementById('centerAddr');

            for (var i = 0; i < result.length; i++) {
                // 행정동의 region_type 값은 'H' 이므로
                if (result[i].region_type === 'H') {
                    infoDiv.innerHTML = result[i].address_name;
                    break;
                }
            }
        }
    }

    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


}
;
