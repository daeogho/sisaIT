<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css"/>

<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script src="https://uicdn.toast.com/tui-color-picker/latest/tui-color-picker.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-color-syntax/latest/toastui-editor-plugin-color-syntax.min.js"></script>
<!-- Toast UI Editor CSS -->
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<!-- color추가 -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-color-picker/latest/tui-color-picker.min.css">
<link rel="stylesheet" href="https://uicdn.toast.com/editor-plugin-color-syntax/latest/toastui-editor-plugin-color-syntax.min.css">

<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&display=swap" rel="stylesheet">

<!-- 카카오 맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb509c46c771c3734afd3a62afb5b566&libraries=services"></script>
 <style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px; width:100%}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
#placesList .item.selected {
    background-color: #f0f8ff !important;
}
</style>
<div style="padding:40px">
	<h1 class="bagel-fat-one-regular"><img src="${ctx}/img/gul.png " style="width:50px"/>  제주를 말하다</h1>
</div>

<div class="board-main">
	<!-- 에디터 영역 -->
	<form action="${ctx}/season/editOk" method="post" onsubmit="return submitEditor();" enctype="multipart/form-data" >
		<div style="width:90%; border-bottom: 2px solid #E6B677; border-top: 2px solid #E6B677; margin:20px auto; ">
			<!-- 제목 입력 -->
			<label style="margin-right:10px;">제목</label>
			<input type="text" id="subject" name="subject"  placeholder="제목을 입력하세요.(최대 30글자)" value="${ss.subject }"
				style="width: 80%; min-height: 40px; resize: none;
				overflow: hidden; box-sizing: border-box; border:none; border-bottom: 1px solid #eee;
				padding:5px; minlength:30; margin:70px 0px 20px 0px; "/>
			<br/>
			<!-- 주소 입력 -->	
			<label style="margin-right: 10px;">장소</label>
			<input type="text" id="addrtitle" name="addrtitle" placeholder="주소" value="${ss.addrtitle }"
				style="width: 80%; min-height: 40px; resize: none;
				overflow: hidden; box-sizing: border-box; border: none; border-bottom: 1px solid #eee;
				padding:5px; minlength:30; margin-bottom:20px;"/>
			<br/>
			<!-- 카테고리 입력 -->	
			<label style="margin-right: 30px;">카테고리</label>
			<select id="season" name="season"
				   style="width: 75%; min-height: 40px; resize: none;
			    overflow: hidden; box-sizing: border-box; border-radius:10px; border: 2px solid #eee;
			    padding:5px; margin-bottom:80px;">
				    <option value="spring" ${ss.season == 'spring' ? 'selected' : ''}>봄</option>
				    <option value="summer" ${ss.season == 'summer' ? 'selected' : ''}>여름</option>
				    <option value="fall" ${ss.season == 'fall' ? 'selected' : ''}>가을</option>
				    <option value="winter" ${ss.season == 'winter' ? 'selected' : ''}>겨울</option>
				</select>
		</div>
		<!-- 지도 -->
		<div class="map_wrap" >
		    <div id="map" style="width:90%;height:100%;position:relative;overflow:hidden; margin-top:100px;"></div>
		
		    <div id="menu_wrap" class="bg_white">
		        <div class="option">
		            <div>
		                <div>
						    키워드 : 
						    <input type="text" value="${ss.addrtitle }" id="keyword" placeholder="장소를 입력하세요." size="15"> 
						    <button type="button" onclick="searchPlaces()">검색하기</button>
						</div>
		            </div>
		        </div>
		        <hr>
		        <ul id="placesList"></ul>
		        <div id="pagination"></div>
		    </div>
		</div>
		
		<div id="editor" style="width:90%; margin:20px auto;"></div>
		<!-- id 넘겨주기 -->
		<input type="hidden" name="no" value="${ss.no }">
		<!-- 전송 폼 -->	
	    <input type="hidden" name="context" id="context"/>
	    <!-- 선택한 장소 위도,경도 -->
	    <input type="hidden" name="lat" id="lat" value="${ss.lat }">
		<input type="hidden" name="lng" id="lng" value="${ss.lng }">
	    <div>
			<button type="submit" class="diphylleia-regular-button" onclick="" style="background-color:#aaa; border: 0px; border-radius:10px; padding:5px;">글 수정</button>
		</div>
	</form>
</div>

<script>
	var lat = parseFloat("${ss.lat}") || 33.450701;
	var lng = parseFloat("${ss.lng}") || 126.570667;
		
	// 마커를 담을 배열입니다
	var markers = [];
	
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	    center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};
	//지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 수정 페이지라면 초기 마커를 하나 생성해둡니다.
    if("${ss.lat}" != "") {
		var initialMarker = new kakao.maps.Marker({
	        position: new kakao.maps.LatLng(lat, lng),
	        map: map
	    });
		markers.push(initialMarker);
    }
	
	// 장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places();  

	// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	// 키워드로 장소를 검색합니다
	searchPlaces();

	// 키워드 검색을 요청하는 함수입니다
	function searchPlaces() {

	    var keyword = document.getElementById('keyword').value;

	    if (!keyword.replace(/^\s+|\s+$/g, '')) {
	        alert('키워드를 입력해주세요!');
	        return false;
	    }

	    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	    ps.keywordSearch( keyword, placesSearchCB); 
	}

	// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	function placesSearchCB(data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {

	        // 정상적으로 검색이 완료됐으면
	        // 검색 목록과 마커를 표출합니다
	        displayPlaces(data);

	        // 페이지 번호를 표출합니다
	        displayPagination(pagination);

	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

	        alert('검색 결과가 존재하지 않습니다.');
	        return;

	    } else if (status === kakao.maps.services.Status.ERROR) {

	        alert('검색 결과 중 오류가 발생했습니다.');
	        return;

	    }
	}

	// 검색 결과 목록과 마커를 표출하는 함수입니다
	function displayPlaces(places) {

	    var listEl = document.getElementById('placesList'), 
	    menuEl = document.getElementById('menu_wrap'),
	    fragment = document.createDocumentFragment(), 
	    bounds = new kakao.maps.LatLngBounds(), 
	    listStr = '';
	    
	    // 검색 결과 목록에 추가된 항목들을 제거합니다
	    removeAllChildNods(listEl);

	    // 지도에 표시되고 있는 마커를 제거합니다
	    removeMarker();
	    
	    for (var i = 0; i < places.length; i++) {

	        var place = places[i];  // ✅ 먼저 변수에 담기

	        var placePosition = new kakao.maps.LatLng(place.y, place.x),
	            marker = addMarker(placePosition, i),
	            itemEl = getListItem(i, place);

	        bounds.extend(placePosition);

	        (function(marker, place, itemEl) {

	            kakao.maps.event.addListener(marker, 'mouseover', function() {
	                displayInfowindow(marker, place.place_name);
	            });

	            kakao.maps.event.addListener(marker, 'mouseout', function() {
	                infowindow.close();
	            });

	            itemEl.onmouseover = function () {
	                displayInfowindow(marker, place.place_name);
	            };

	            itemEl.onmouseout = function () {
	                infowindow.close();
	            };

	            // ✅ 클릭 이벤트
	            itemEl.onclick = function () {

	                //var address = place.road_address_name 클릭한 장소의 지번
	                //    ? place.road_address_name
	                //    : place.address_name;
	                //document.getElementById("addrtitle").value = address;
	                
	                // 장소 이름
				    var placeName = place.place_name;
				
				    document.getElementById("addrtitle").value = placeName;

	                
	                
	                // ✅ 위도 경도 hidden input 저장
	                document.getElementById("lat").value = place.y;
	                document.getElementById("lng").value = place.x;
	                
	                map.setCenter(new kakao.maps.LatLng(place.y, place.x));
	                
	             	// ✅ 기존 선택 제거
	                var items = document.querySelectorAll("#placesList .item");
	                items.forEach(function(el){
	                    el.classList.remove("selected");
	                });

	                // ✅ 현재 선택 추가
	                this.classList.add("selected");
	            };

	        })(marker, place, itemEl);

	        fragment.appendChild(itemEl);
	    }

	    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
	    listEl.appendChild(fragment);
	    menuEl.scrollTop = 0;

	    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	    map.setBounds(bounds);
	}

	// 검색결과 항목을 Element로 반환하는 함수입니다
	function getListItem(index, places) {

	    var el = document.createElement('li'),
	    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
	                '<div class="info">' +
	                '   <h5>' + places.place_name + '</h5>';

	    if (places.road_address_name) {
	        itemStr += '    <span>' + places.road_address_name + '</span>' +
	                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
	    } else {
	        itemStr += '    <span>' +  places.address_name  + '</span>'; 
	    }
	                 
	      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
	                '</div>';           

	    el.innerHTML = itemStr;
	    el.className = 'item';
	    

	    return el;
	}

	// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
	function addMarker(position, idx, title) {
	    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
	        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
	        imgOptions =  {
	            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
	            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
	            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
	        },
	        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
	            marker = new kakao.maps.Marker({
	            position: position, // 마커의 위치
	            image: markerImage 
	        });

	    marker.setMap(map); // 지도 위에 마커를 표출합니다
	    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

	    return marker;
	}

	// 지도 위에 표시되고 있는 마커를 모두 제거합니다
	function removeMarker() {
	    for ( var i = 0; i < markers.length; i++ ) {
	        markers[i].setMap(null);
	    }   
	    markers = [];
	}

	// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
	function displayPagination(pagination) {
	    var paginationEl = document.getElementById('pagination'),
	        fragment = document.createDocumentFragment(),
	        i; 

	    // 기존에 추가된 페이지번호를 삭제합니다
	    while (paginationEl.hasChildNodes()) {
	        paginationEl.removeChild (paginationEl.lastChild);
	    }

	    for (i=1; i<=pagination.last; i++) {
	        var el = document.createElement('a');
	        el.href = "#";
	        el.innerHTML = i;

	        if (i===pagination.current) {
	            el.className = 'on';
	        } else {
	            el.onclick = (function(i) {
	                return function() {
	                    pagination.gotoPage(i);
	                }
	            })(i);
	        }

	        fragment.appendChild(el);
	    }
	    paginationEl.appendChild(fragment);
	}

	// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
	// 인포윈도우에 장소명을 표시합니다
	function displayInfowindow(marker, title) {
	    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

	    infowindow.setContent(content);
	    infowindow.open(map, marker);
	}

	 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
	function removeAllChildNods(el) {   
	    while (el.hasChildNodes()) {
	        el.removeChild (el.lastChild);
	    }
	}


  // 에디터 생성
  const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    height: '600px',
    initialEditType: 'wysiwyg', // markdown | wysiwyg
    initialValue: `${ss.context != null ? ss.context : ''}`,
    previewStyle: 'vertical',
    placeholder: '',
    hideModeSwitch: true, // 마크다운/위지윅 전환 숨김
    plugins: [toastui.Editor.plugin.colorSyntax], // ✅ 색상 플러그인
    hooks: {
           addImageBlobHook: (blob, callback) => {
               // 1. 이미지를 서버에 저장하기 위한 FormData 생성
               const formData = new FormData();
               formData.append('image', blob);

               // 2. 서버(Controller)로 비동기 업로드 요청
               fetch('${ctx}/season/imageUpload', {
                   method: 'POST',
                   body: formData
               })
               .then(response => response.json())
               .then(data => {
                   // 3. 서버가 저장한 이미지의 URL을 에디터 본문에 삽입
                   // data.url은 서버가 리턴해주는 파일 경로여야 합니다.
                   callback(data.url, '제주사진');
               })
               .catch(error => {
                   console.error('이미지 업로드 실패:', error);
               });
           }
       }
  });
	
  // 폼 전송 시 에디터 내용 hidden input에 담기
  function submitEditor() {
	  const subject = document.getElementById("subject").value;
	  const addr = document.getElementById("addrtitle").value;
	  const season = document.getElementById("season").value;
	  if(subject.trim() == ""){
		  alert("글 제목을 입력하세요");
		  return false;
	  }
	  
	  if(addr.trim()==""){
		  alert("주소를 입력해 주세요");
		  return false;
	  }
	  
	  if(season == ""){
		  alert("계절을 선택하세요.");
		  return false;
	  }
	  
	  const htmlData = editor.getHTML();
	  const textData = editor.getMarkdown().trim();

	  if(textData == ""){
		  alert("글 내용을 입력하세요.");
		  editor.focus();
		  return false;
	  }

	  const hasImage = /<img[^>]*src=["']?([^>"']+)["']?[^>]*>/i.test(htmlData);
      if (!hasImage) {
          alert("최소 1장 이상의 이미지를 포함해야 합니다.");
          return false;
      }
      document.getElementById("context").value = htmlData;
      return true;
  }
</script>

<script>
    document.getElementById('subject').addEventListener('input', function() {
        if (this.value.length > 30) {
            this.value = this.value.substring(0, this.value.length - 2) + this.value.slice(-1);
        }
    });
    // 🔍 키워드 입력창에서 엔터 눌러도 검색되게
    document.addEventListener("DOMContentLoaded", function(){

        const keywordInput = document.getElementById("keyword");

        if(keywordInput){
            keywordInput.addEventListener("keydown", function(e){
                if(e.key === "Enter"){
                    e.preventDefault(); // 글 작성 submit 막기
                    searchPlaces();
                }
            });
        }

    });
</script>

<div class="stone-bg">
    <img src="${ctx }/img/doldamimg.png" style="width:100%; height:60vh;"/>
</div>