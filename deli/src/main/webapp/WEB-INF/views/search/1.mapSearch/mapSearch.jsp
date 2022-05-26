<%@page language = "java" contentType = "text/html; charset=UTF-8"
pageEncoding = "UTF-8" %>


    <html>
        <head>
            <title>현재 위치</title>
            <link rel="stylesheet" type="text/css" href="mapSearch.css">
        </head>

        <body>
            <center>
                <h2>나의 현위치</h2>

                <div class="map_wrap">
                    <div id="map"
                        style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

                    <div class="hAddr">
                        <span class="title"> 현재 위치 <span class="title" id="centerAddr"></span></span>
                    </div>



                </div>

                <br>
                    <a href="../2.meetSearch/meetSearch.jsp" target='_blank'><button>만나는장소 찾기</button></a>
                    <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73&libraries=services"></script>
                    <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
                    <script type="text/javascript"
                        src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=8800e7024fb23ec08385f1384cbd3f73"></script>
                    <script src="mapSearch.js">	</script>

            </center>
        </body>
    </html>