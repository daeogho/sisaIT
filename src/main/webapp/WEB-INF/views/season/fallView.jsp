<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css"/>
<style>
	#kakaoMap{
		position: relative;
		height:400px;
		width:600px;
		margin: 0 auto;
	}
	#address{
		position:absolute;
		left:10px;
		top:200px;
		z-index:1000;
		background:white;
		padding:10px;
		opacity:0.6;
	}
</style>

<script>
	$(document).ready(function(){
	    replyList();
	});
	var seasonDel = () =>{
		if(confirm("현재 글을 삭제하시겠습니까?")){
			location.href="${ctx}/season/del?no=${ss.no}"
		}
	}
	//댓글 목록
		function replyList(){
	    const no = ${ss.no};
	    const logId = "${logId}";
	    
	    $.ajax({
	        url: "${ctx}/season/reply/list/" + no,
	        type: "GET",
	        dataType: "json",
	        success: function(data) {
	            let replyHtml = "";
	            if (!data || data.length === 0) {
	                replyHtml = "<p style='text-align:center; padding:20px;'>등록된 댓글이 없습니다.</p>";
	            } else {
	                data.forEach(function(sr) {
	                    replyHtml += `
	                        <form>
	                            <div style="display:flex; flex-direction: row; justify-content:space-between;">
	                                <div style="display:flex;">
	                            		<p style="font-weight:900; margin: 0 20px 0 0;">\${sr.username}</p>
	                                	<p style="font-weight:900; margin: 0;">\${sr.userID}</p>
	                                </div>
	                                	<p style="color:#babbbc;">\${sr.writedate}</p>
                                	\${logId !== "" && logId === sr.userID ? `
                                            <div style="display:flex; flex-direction: row; justify-content:center;">
                                                <button type="button" class="diphylleia-regular-button" onclick="replyEdit('\${sr.comment_no}', '\${sr.context}')" style="background-color:#E5AF4F; border: 0px; border-radius:10px; padding:5px;">수정</button>
                                                <button type="button" class="diphylleia-regular-button" onclick="replyDel('\${sr.comment_no}')" style="background-color:#CCC; border: 0px; border-radius:10px; padding:5px;">삭제</button>
                                            </div>
                                     ` : ''}
	                            </div>
	                            <div id="reply-content-\${sr.comment_no}" style="margin-bottom:10px;">\${sr.context}</div>
	                        </form>
	                        <hr style="width: 100%; border:none; border-top: 5px solid #E5AF4F; margin: 0;">
	                    `;
	                });
	            }
	            $("#replyListContainer").html(replyHtml);
	        },
	        error: function(xhr, status, error) {
	            console.error("에러 내용:", xhr.responseText);
	        }
	    });
	}
	function replyWrite(no, originalContext){
		// 로그인 아이디 체크
	    var logId = "${logId}"; 
	    if(logId == "" || logId == null){
	        alert("로그인 후 이용 가능합니다.");
	        return false;
	    }
		// 댓글 유효성 검사
		if(document.getElementById("context").value==""){
			alert("댓글 작성 후 등록하세요.");
			return false;
		}
		//쿼리 데이터
		var formData = new FormData(document.getElementById("replyForm"));
		var queryData = new URLSearchParams(formData).toString();
		console.log("전송 데이터: ", queryData);
		
		fetch('${ctx}/season/reply/write',{
			method:'post',
			headers:{"Content-Type":"application/x-www-form-urlencoded"},
			body:queryData
		})
		.then(response=>{
			console.log(response);
			return response.json();
		})
		.then(data=>{
			console.log(data);
			if(data!=1){
				alert("댓글 등록이 실패했습니다.")
			}else{
				//이미 쓴 글 삭제
				document.getElementById("context").value="";
				//새로운 댓글 목록 가져오기
				replyList();
			}
		})
		.catch(error=>{
			console.log("댓글 쓰기 에러...")
		})
	}
	//댓글 수정 폼
	function replyEdit(no, originalContext) {
		// 1. 위에서 추가한 ID를 찾습니다.
	    const contentArea = document.getElementById('reply-content-' + no);
	    
	    if (!contentArea) {
	        console.error("수정할 영역을 찾을 수 없습니다. ID: reply-content-" + no);
	        return;
	    }

	    if (document.getElementById('editForm-' + no)) return;

	    // 2. 수정된 부분: 텍스트 에리어에 기존 내용을 넣고, 버튼은 replyEditOk를 호출하게 합니다.
	    let editHtml = `
	        <form id="editForm-\${no}" style="margin-top:10px;">
	            <div style="display:flex; flex-direction: column;">
	                <textarea id="t\${no}" name="context" 
	                    style="width: 100%; min-height: 60px; resize: none;
	                    overflow: hidden; box-sizing: border-box; border: 2px solid #E5AF4F;
	                    border-radius:10px; padding:5px;">\${originalContext}</textarea>
	                <div style="margin-top:5px; text-align:right;">
	                    <button type="button" class="diphylleia-regular-button" onclick="replyEditOk(\${no})" 
	                        style="background-color:#E5AF4F; border: 0px; border-radius:10px; padding:5px;">수정완료</button>
	                    <button type="button" onclick="replyList()" 
	                        style="background-color:#ccc; border: 0px; border-radius:10px; padding:5px; margin-left:5px;">취소</button>
	                </div>
	            </div>
	        </form>
	    `;

	    contentArea.innerHTML = editHtml;
	}
	function updateReply(no) {
	    alert(no + "번 댓글을 수정합니다.");
	}
	//댓글수정 (DB)
	function replyEditOk(no) {
	    const context = document.getElementById("t" + no).value;
	    if (context.trim() == "") {
	        alert("댓글 내용을 입력 후 수정하세요.");
	        return false;
	    }
	
	    const params = new URLSearchParams();
	    params.append("comment_no", no);
	    params.append("context", context);
	
	    fetch('${ctx}/season/reply/editOk', {
	        method: 'POST',
	        headers: { "Content-Type": "application/x-www-form-urlencoded" },
	        body: params.toString()
	    })
	    .then(res => res.text())
	    .then(data => {
	        if (data >= 1) { // 1 이상이면 성공
	            alert("수정되었습니다.");
	            replyList(); // 목록 갱신
	        } else {
	            alert("수정 실패!");
	        }
	    })
	    .catch(err => console.error("수정 에러:", err));
	}
	//댓글 삭제
	function replyDel(comment_no){
		if(confirm("댓글을 삭제하시겠습니까?")){
			fetch('${ctx}/season/reply/del/'+comment_no, {
				method:'get'
				})
			.then(response=>{
				return response.json()
			})
			.then(data=>{
				console.log('결과==>', data);
				replyList();
			})
			.catch(error=>{
				console.log("댓글 삭제 에러 발생", error)
			})
		}
	}
	//좋아요 추가
	function clickLike(no, imgElement){
		$.ajax({url: "${pageContext.request.contextPath}/season/updateLike",
	        type: "POST",
	        data: { no: no },
	        success: function(result) {
	            if (result == 1) {
	                // 1. 좋아요 등록 성공 -> 빨간 하트로 변경
	                $(imgElement).attr("src", "${ctx}/resources/image/like.png");
	            	// 2. 터지는 클래스 추가 (중복 방지를 위해 기존 클래스 제거 후 추가)
	                $(imgElement).removeClass("like-active");
	                void imgElement.offsetWidth; // 브라우저가 애니메이션을 다시 인식하게 하는 트릭
	                $(imgElement).addClass("like-active");
	                
	                // 3. 애니메이션 종료 후 클래스 제거
	                setTimeout(function() {
	                    $(imgElement).removeClass("like-active");
	                }, 400);
	            } else if (result == 0) {
	                // 좋아요 취소 성공 -> 빈 하트로 변경
	                $(imgElement).attr("src", "${ctx}/resources/image/unlike.png");
	            } else if (result == -1) {
	                alert("로그인이 필요한 서비스입니다.");
	                location.href = "${ctx}/users/login";
	            }
	        },
	        error: function() {
	            alert("좋아요 처리 중 오류가 발생했습니다.");
	        }
	    });
	}
</script>


<img class="view-main" src="${ctx}/resources/upload/${ss.thumbnail}"/>

<!-- 글 내용 -->
<div style="margin: 0 auto; width:100%; max-width:1000px; text-align:center;">
	<div style="padding:60px;">
		<h5 style="font-weight:900;">제목: ${ss.subject }</h5>
		<p style="color:#b9852b; font-weight:bold; font-size: 20px;">주소: ${ss.addrtitle}</p>
		<p style="color:#babbbc;">${ss.writedate}</p>
	</div>
	<div class="context">
		<c:if test="${ss.thumbnail != null && ss.thumbnail != ''}">
			<img class="main-img" src="${ctx}/resources/upload/${ss.thumbnail}"/>
		</c:if>
		<c:if test="${ss.thumbnail == null || ss.thumbnail == ''}">
        	<img class="main-img" src="${ctx}/resources/image/no-image.jpg"/>
    	</c:if>
		<p>주소: ${ss.addrtitle}</p>
		<div class="cont-img">${ss.context }</div>
	</div>
	<div id="kakaoMap"></div>
	<div id="address"></div>
</div>

<!-- 게시글 올린 이 프로필 -->
<div style="background-color:#FFF0DB;">
	<hr style="border:none; border-top: 5px solid #E5AF4F">
	<div style="display:flex; flex-direction: row; justify-content:center;">
		<div style="width:600px; display:flex;">
				<img class="profile" src="${ctx}/resources/image/profile1.png"/>
				<div style="margin-left: 10px; margin-top:10px;">
					<h6 style="font-weight:900;">${ss.username }</h6>
					<p>${ss.userID }</p>
				</div>
		</div>
		<c:choose>
	        <c:when test="${ss.isLike == 1}">
				<img class="like2" src="${ctx}/resources/image/like.png" onclick="clickLike(${ss.no}, this)" style="cursor:pointer;"/>
			</c:when>
			<c:otherwise>
				<img class="like2" src="${ctx}/resources/image/unlike.png" onclick="clickLike(${ss.no}, this)" style="cursor:pointer;"/>
			</c:otherwise>
        </c:choose>
	</div>
	<hr style="border:none; border-top: 5px solid #E5AF4F">
</div>

<div style="display:flex; flex-direction: row; justify-content:center;">
	<button class="diphylleia-regular-button"
		onclick="location.href='${ctx}/season/list?season=${ss.season}'"
		style="background-color:#E5AF4F; border: 0px; border-radius:10px; padding:5px; margin-right: 10px;">목록</button>
	<c:if test="${not empty logId && logId eq ss.userID}">
		<button class="diphylleia-regular-button" onclick="location.href='${ctx}/season/seasonEdit?no=${ss.no}'" style="background-color:#E5AF4F; border: 0px; border-radius:10px; padding:5px; margin-right: 10px;">수정</button>
		<button class="diphylleia-regular-button" onclick="seasonDel()" style="background-color:#CCC; border: 0px; border-radius:10px; padding:5px;">삭제</button>
	</c:if>
</div>

<!-- 댓글 입력창 -->
<div style="display:flex; flex-direction: row; justify-content:center; padding:10px;">
	<form id="replyForm">
		<div style="display:flex; flex-direction: column;">
			<input type="hidden" name="no" value="${ss.no}">
   			<input type="hidden" name="season" value="${ss.season}">
   			<c:if test="${logId!=null && logId!=''}">
				<p style="color:#E5AF4F; margin: 0; font-weight: bold;">작성 이름:${logId }</p>
			</c:if>	
			<div>
				<textarea id="context" name="context" placeholder="댓글을 입력하세요."
					style="width: 600px; min-height: 40px; resize: none;
					overflow: hidden; box-sizing: border-box; border: 2px solid #E5AF4F;
					border-radius:10px;	padding:5px;"></textarea>
				<button class="diphylleia-regular-button" onclick="replyWrite()" style="background-color:#E5AF4F; border: 0px; border-radius:10px; padding:5px;">등록</button>
			</div>
		</div>
	</form>
</div>

<!-- 댓글 목록 -->

<div style="background-color:#FFF0DB; display:flex; flex-direction: column; align-items: center;">
	<hr style="width: 100%; border:none; border-top: 5px solid #E5AF4F; margin: 0;">
	<div style="background-color:#ffffff; width:700px; padding:0px 20px 0px 20px; margin-top:30px;">
		<div id="replyListContainer"></div>
		<input type="hidden" name="no">
	</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b47a858cabc81fed5a6f2b5ba327956&libraries=services"></script>
<script>
kakao.maps.load(function() {
    const {kakao} = window;
    
    var lat=${ss.lat != 0 ? ss.lat : 33.3766},
		lng=${ss.lng != 0 ? ss.lng : 126.5437};
    var mapContainer = document.getElementById('kakaoMap');
    
    console.log("체크용:", lat, lng);
    
    var mapOption = { 
        center: new kakao.maps.LatLng(lat, lng), 
        level: 3 
    };
    
    var map = new kakao.maps.Map(mapContainer, mapOption);
    
    var marker = new kakao.maps.Marker({
        position: map.getCenter()
    });
    marker.setMap(map);
    
    var geocoder = new kakao.maps.services.Geocoder();
    
    
    function searchDetailAddrFromCoords(coords, callback) {
        geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
    }
});
</script>