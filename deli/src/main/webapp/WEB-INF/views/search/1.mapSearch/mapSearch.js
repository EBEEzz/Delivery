
          // 지도를 클릭한 위치에 표출할 마커입니다
          	var marker = new kakao.maps.Marker({ 
              // 지도 중심좌표에 마커를 생성합니다 
           	   position: map.getCenter() 
          	}); 
          // 지도에 마커를 표시합니다
              marker.setMap(map);
              let geocoder = new kakao.maps.services.Geocoder();
              // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
              searchAddrFromCoords(map.getCenter(), displayCenterInfo)
              function searchAddrFromCoords(coords, callback) {
                  // 좌표로 행정동 주소 정보를 요청합니다
                  geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
              }

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
                      document.getElementById('myAddress').textContent = infoDiv.innerHTML;
                  }
                  

                  var zoomControl = new kakao.maps.ZoomControl();
                  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                  
              }
              