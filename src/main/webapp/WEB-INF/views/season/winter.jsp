<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Diphylleia&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Nanum+Pen+Script&family=Sunflower:wght@300&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	function searchCheck(){
		if(document.getElementById("searchWord").value==''){
			alert("검색어를 입력하세요...");
			return false;
		}
		return true;
	}
	function clickLike(no, imgElement){
		$.ajax({url: "${pageContext.request.contextPath}/season/updateLike",
	        type: "POST",
	        data: { no: no },
	        success: function(result) {
	            if (result == 1) {
	                // 좋아요 등록 성공 -> 빨간 하트로 변경
	                $(imgElement).attr("src", "${ctx}/resources/image/like.png");
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

<div class="main-top"  >

	<div class="main-img" style="position:relative; width:100%;">
		<img src="../resources/image/wintermain.png" style="height:450px; width:100%; object-fit: cover;"/>
		<img src="${ctx}/resources/image/Wlogo.png" style="position:absolute; top:30px; right:50%; z-index:10; width:120px"/>
		<img src="${ctx}/resources/image/Slogo2.png" style="position:absolute;  bottom:-0px; left:0px; z-index:20; width:100%; height:200px;"/>
	</div>
</div>
<div style=" justify-content:center; align-items:center; height:100px; display: flex; margin:100px auto 20px;  max-width:1400px; ">
	<img src="${ctx}/resources/image/sanicon.png" style="width:100px; margin-right: 10px;"/>
	<h2 style="line-height:100px;  font-family:Gowun Batang; font-weight: bold;  color:#456e2a">돌담 : 제주의 겨울</h2>
	
	<c:if test="${logId!=null && logId!=''}">
		<button class="btn btn-dark" onclick="location.href='${ctx}/season/seasonForm'"
			style="color:#fff; border: none; border-radius:30px; padding:10px; width:120px; height: 50px; margin-left:700px;">기록하기</button>
	</c:if>
</div>

<!--  선 -->
<div style="border:none; border-top: 3px solid #000000; max-width:1400px;
	width:100%; display:flex; flex-direction: row; justify-content:center; margin:0 auto 20px; "></div>

<!-- 제목 검색 -->	
<div style="width:1400px; display:flex; justify-content:center; margin:50px auto; ">
		<form method="get" action="${ctx}/season/list?season=winter" onsubmit="return searchCheck()"  >
			<input type="hidden" name="season" value="winter"/>
			<input type="text" id="searchWord" name="searchWord"  placeholder="검색할 제목을 입력하세요."
			style="width: 900px; height:50px; border: 2px solid #000000;	border-radius:30px;	padding:10px; "/>
			<input class="btn btn-dark" type="submit" value="검색" style="color:#fff; border: 0px; border-radius:30px; padding:10px;  width:100px; height: 50px;"/>
		</form>
</div>

<!-- 게시판 목록 -->
<div style="display:flex; flex-direction: row; margin: 0 auto;
	max-width:1400px; min-height:50vh; width:100%; flex-wrap: wrap; justify-content: flex-start">

	<c:forEach var="ss" items="${list }">
		<div class="card" style="position:relative; border:none; width:300px; height:250px; margin:10px 10px; flex-wrap:wrap;">
			
				<c:choose>
					<c:when test="${ss.isLike == 1 }">
						<img class="like" src="${ctx}/resources/image/like.png" onclick="clickLike(${ss.no}, this)" style="cursor:pointer;"/>
					</c:when>
					<c:otherwise>
						<img class="like" src="${ctx}/resources/image/unlike.png" onclick="clickLike(${ss.no}, this)" style="cursor:pointer;"/>
					</c:otherwise>
				</c:choose>
		
				<a href="${ctx }/season/winterView?no=${ss.no}&nowPage=${pVO.nowPage }<c:if test="${pVO.searchWord!=null and pVO.searchWord!='' }">&searchKey=${pVO.searchKey }&searchWord=${pVO.searchWord }</c:if>" style="text-decoration:none; color:black;">
			        <img class="img2" src="${ctx}/resources/upload//${ss.thumbnail}"/>
			    
				    <!-- hover overlay -->
				    <div class="overlay">
				         <p style="width: 80%; white-space: nowrap; overflow: hidden;text-overflow: ellipsis;">제목 : ${ss.subject}</p>
				         <p>장소 : ${ss.addrtitle}</p>
				         <p>작성자 : ${ss.userID}</p>
				         <p>조회수 : ${ss.hit}</p>
				    </div>
			</a>
		</div>
	</c:forEach>
</div>


<ul class="pagination justify-content-center">
    <c:if test="${pVO.nowPage==1 }">
    	<li class="page-item"><a class="page-link" href="javascript:void(0);" style="color:#C4ECEA !important;">Prev</a></li>
    </c:if>
    <c:if test="${pVO.nowPage>1 }">
    	<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/season/list?season=winter&nowPage=${pVO.nowPage-1}<c:if test="${pVO.searchWord!=null and pVO.searchWord!='' }">&searchKey=${pVO.searchKey }&searchWord=${pVO.searchWord }</c:if>' style="color:#C4ECEA !important;">Prev</a></li>
    </c:if>
	<!-- 이전페이지 -->
    <c:forEach var="pg" begin="${pVO.startPage }" end="${pVO.startPage+pVO.onePageNumCount-1 }">
    	<c:if test="${pg<=pVO.totalPage }">
    		<c:if test="${pg==pVO.nowPage }">
    			<li class="page-item">
    		</c:if>
    		<c:if test="${pg!=pVO.nowPage }">
    			<li class="page-item">
    		</c:if>	
    				<a class="page-link" href='${pageContext.request.contextPath }/season/list?season=winter&nowPage=${pg}<c:if test="${pVO.searchWord!=null and pVO.searchWord!='' }">&searchKey=${pVO.searchKey }&searchWord=${pVO.searchWord }</c:if>' style="color:#C4ECEA !important;">${pg }</a>
    			</li>
		</c:if>
	</c:forEach>
	<!-- 다음 페이지 -->
	<c:if test="${pVO.nowPage<pVO.totalPage }">
    	<li class="page-item"><a class="page-link" href='${pageContext.request.contextPath }/season/list?season=winter&nowPage=${pVO.nowPage+1 }<c:if test="${pVO.searchWord!=null and pVO.searchWord!='' }">&searchKey=${pVO.searchKey }&searchWord=${pVO.searchWord }</c:if>' style="color:#C4ECEA !important;">Next</a></li>
    </c:if>
    <c:if test="${pVO.nowPage==pVO.totalPage }">
    	<li class="page-item"><a class="page-link" href="javascript:void(0);" style="color:#C4ECEA !important;">Next</a></li>
    </c:if>
</ul>

<img src="../resources/image/rock.png" style="width:100%"/>