<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://fonts.googleapis.com/css2?family=Diphylleia&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Nanum+Pen+Script&family=Sunflower:wght@300&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
<style>
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style_kdh.css" />
<!--  지도 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b444286a3ac23860e7033dd42a6749c7&libraries=services"></script>
<script>
var map; // 지도 전역 변수

document.addEventListener("DOMContentLoaded", function(){

    const tabs = document.querySelectorAll('.tab');
    const sections = document.querySelectorAll('.content_section');

    // 시작 탭
    var startSection = new URLSearchParams(window.location.search).get('tab');
    if(!startSection){
        startSection = "post";
    }

    // 지도 생성
    var lat = 33.3766;
    var lng = 126.5437;

    var mapContainer = document.getElementById('kakaoMap');

    var mapOption = { 
        center: new kakao.maps.LatLng(lat, lng),
        level: 9
    };

    map = new kakao.maps.Map(mapContainer, mapOption);

 		var positions = [];

 			<c:forEach var="place" items="${likeMapList}">
 			positions.push({
 			    no : "${place.no}",
 			    title : "${place.subject}",
 			    lat : "${place.lat}",
 			    lng : "${place.lng}",
 			    addr : "${place.addrtitle}",
 			    season : "${place.season}"
 			});
 			</c:forEach>
 	
 		console.log("마커 데이터", positions);
		   
		   var imageSrc = "${ctx}/resources/image/like.png"; // 마커 이미지 경로
	       var imageSize = new kakao.maps.Size(30, 30); 
		   var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
		   
		// 지도 범위 자동 계산
		   var bounds = new kakao.maps.LatLngBounds();
		   
 	positions.forEach(function(pos){

 		   var markerPosition = new kakao.maps.LatLng(pos.lat, pos.lng);
 		   
 		   bounds.extend(markerPosition);

 		   var marker = new kakao.maps.Marker({
 		       map: map,
 		        position: markerPosition,
 		        title: pos.title,
 		        image : markerImage
 		    });
 		  var content =
 			    '<div style="padding:8px;width:220px; font-size:12px; line-height:1.4;">' +
 			    '<b>' + pos.title + '</b><br>' +
 			    '주소 : ' + pos.addr + '<br>' +
 			    '계절 : ' + pos.season + '<br><br>' +
 			    '<button onclick="location.href=\'${ctx}/season/' + pos.season + 'View?no=' + pos.no + '\'">' +
 			    '게시글 보기' +
 			    '</button>' +
 			    '</div>';
 		   
 		   // 정보창 내용
 		  var infowindow = new kakao.maps.InfoWindow({
 			 content : content
 		    });
		// 마커 클릭 이벤트
 		 kakao.maps.event.addListener(marker, 'click', function() {

 	        map.setCenter(markerPosition);
 	        map.setLevel(3);

 	        infowindow.open(map, marker);
 	    });

 	});

 	 // 시작 탭 활성화
    activateTab(startSection);

    // 탭 클릭 이벤트
    tabs.forEach(menu => {
        menu.addEventListener('click', function(e){
            e.preventDefault();
            
            var target = this.dataset.target;
            
            activateTab(target);
            
            //URL변경
            history.pushstate(null, null, '?tab=' + target);
        });
    });

    // 탭 활성화 함수
    function activateTab(target){

        sections.forEach(sec => sec.classList.remove('active'));
        document.getElementById('section-' + target).classList.add('active');

        // 좋아요 탭 열릴 때 지도 리사이즈
        if(target === "like"){
            setTimeout(function(){
                if(map){
                    map.relayout();
                    map.setCenter(new kakao.maps.LatLng(lat, lng));
                }
            },200);
        }
    }

});
</script>

<!--  페이지 알람  -->
<c:if test="${not empty msg}">
	<script>
	alert("${msg}");
</script>
</c:if>

<div class="mypage-wrapper">
	<div class="my_back">

		<!--------------------  프로필 --------------------->
		<div class="my_profile">
		
			<!-- 마이페이지 리본 -->
			<div class="mypage_title"><img src="${ctx }/resources/image/RebonLogo.png"/></div>
		
			<div style="width: 140px; height: 140px; border-radius: 50%; object-fit: cover; overflow: hidden;">
				<img src="${ctx}/resources/image/profile.jpg"
					style="width: 100%; height: 100%; object-fit: cover; display: block;" />
			</div>

			<div class="profile_info">
				<p style="font-size: 20px;">${dto.userID }</p>
				<p style="color:#6e8357;">E-mail : ${dto.email }</p>
			</div>
			<div class="profile_menu">
			
				<div style="border-bottom:2px solid black; color:black; width:100%; text-align: center; font-weight: bold; padding-bottom:10px; margin: 50px 0px 30px;"> 
					내정보 관리
				</div>
				
				<a class="menu_item"
					href="<%=request.getContextPath()%>/mypage/userEdit">내정보수정</a>
					<a class="menu_item ${activeTab=='post'?'active':''}" href="?tab=post">작성한 글</a> 
					<a class="menu_item ${activeTab=='like'?'active':''}" href="?tab=like">좋아요</a> 
					<a class="menu_item ${activeTab=='comment'?'active':''}" href="?tab=comment">내가 쓴 댓글</a> 
					<a class="menu_item" href="<%=request.getContextPath()%>/mypage/mypageQna">문의하기</a>
			</div>
		</div>
		<!---------------------  게시판 --------------------->
		<div class="my_box">
			<div class="board_area">
	    
			<!-- 우측 콘텐츠 -->
	        <div class="mypage_welcome">
	           <img src="${ctx}/resources/image/mypageImg.png" style="width:100%; ">
	            <div style="position:absolute;top:30px;left:40px; font-size:28px; font-weight:bold;">
	                반갑습니다.<br>${dto.username }님!
	            </div>
	        </div>
	        
				<!--  작성한글 -->
				<div class="content_section" id="section-post">
					<div class="board_title">
						<img src='${ctx }/resources/image/pencil.png' />
						<p>작성한 글</p>
					</div>

					<div class="box_board">
						<c:choose>
							<c:when test="${empty mySeasonList} ">
								<div class="empty">작성한 글이 없습니다.</div>
							</c:when>

							<c:otherwise>
								<c:forEach var="season" items="${mySeasonList }">
									<div class="board_item"
										onclick="location.href='${ctx}/season/${season.season}View?no=${season.no }'">
										<img src="${ctx }/resources/upload/${season.thumbnail}" />
										<div class="board_info">
											<a href="javascript:void(0)" >제목 : ${season.subject}</a>
											<p>주소 : ${season.addrtitle}</p>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>

					<!--  작성한글 버튼 -->
					<div class="comment-pagination">
						<c:forEach begin="1" end="${seasonPageVO.totalPage}" var="i">
							<a href="?page=${i}&tab=post"
								class="${i == seasonPageVO.nowPage ? 'active' : ''}"> ${i}
							</a>
						</c:forEach>
					</div>
				</div>

				<!-------------------  좋아요 ---------------------->
				<div class="content_section" id="section-like">
					<div class="board_title">
						<img src="${ctx}/resources/image/like.png" />
						<p>좋아요</p>
					</div>
					<div class="like_board">
						<div id="kakaoMap" style="width: 100%; height: 100%;"></div>
					</div>
				</div>

				<!-----------------  내가 쓴 댓글 --------------------->

				<div class="content_section" id="section-comment">
					<div class="board_title">
						<img src="${ctx}/resources/image/pencil.png" />
						<p>내가 쓴 댓글</p>
					</div>
					<div class="comment_board">
						<c:choose>
							<c:when test="${empty myCommentList }">
								<div class="empty">작성한 댓글이 없습니다.</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="comment" items="${myCommentList }"
									varStatus="st">
									<div class="comment_item"
										onclick="location.href='${ctx}/season/${comment.season }View?no=${comment.no }'">
										<div class="comment_title">${st.count }${comment.subject }</div>
										<div class="comment_content">댓글 | ${comment.comment }</div>
										<div class="comment_date">${comment.commentDate }</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- 내가 쓴 댓글 버튼 -->
					<div class="comment-pagination">
						<c:forEach begin="1" end="${commentPageVO.totalPage}" var="i">
							<a href="?page=${i}&tab=comment"
								class="${i == commentPageVO.nowPage ? 'active' : ''}"> ${i}
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>