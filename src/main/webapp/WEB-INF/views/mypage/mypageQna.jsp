<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Toast UI Editor JS -->
<script
	src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<!-- 컬러추가 -->
<script
	src="https://uicdn.toast.com/tui-color-picker/latest/tui-color-picker.min.js"></script>
<script
	src="https://uicdn.toast.com/editor-plugin-color-syntax/latest/toastui-editor-plugin-color-syntax.min.js"></script>
<!-- Toast UI Editor CSS -->
<link rel="stylesheet"
	href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<!-- color추가 -->
<link rel="stylesheet"
	href="https://uicdn.toast.com/tui-color-picker/latest/tui-color-picker.min.css">
<link rel="stylesheet"
	href="https://uicdn.toast.com/editor-plugin-color-syntax/latest/toastui-editor-plugin-color-syntax.min.css">
<!--  ----------------------------------------------------------------------------------- -->
<style>
body {
	margin: 0;
	min-height: 100vh;
	background: linear-gradient(to bottom, #ffffff 50%, #7eccef 50%);
}

.mypage-wrapper {
	min-height: 100vh;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.container {
	width: 800px;
	background: #fff;
	border-radius: 16px;
	padding: 30px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15);
	margin: 50px auto;
}
.qna-actions{
    margin-top: 30px;
    display: flex;
    justify-content: space-between;
}

</style>
<div class="mypage-wrapper">
	<div class="container">
		<h1>QnA</h1>
		<!--  에디터 영역 -->
		<form action="${pageContext.request.contextPath}/mypage/qna"
			method="post" onsubmit="return submitEditor();">


			<div class="mb-3 mt-3">
				<label for="to">받는사람 :</label> <input type="email"
					class="form-control" name="to" id="to"
					placeholder="받는 이메일주소를 입력하세요" value="doldam@doldam.com" readonly
					style="border: 2px solid #5fa8d3;">
			</div>
			
			<div class="mb-3 mt-3">
				<label for="to"></label> <input type="hidden"
					class="form-control" name="userEmail" style="border: 2px solid #5fa8d3;">
			</div>

			<div class="mb-3 mt-3">
				<label for="subject">제목 :</label> <input type="text"
					class="form-control" name="subject" id="subject"
					placeholder="제목을 입력하세요." style="border: 2px solid #5fa8d3;">
			</div>

			<div id="editor" style="border: 2px solid #5fa8d3;"></div>
			
			<div class="qna-actions" style="margin-top:10px;">
				<button type="submit" class="btn btn-warning" style="width: 100px; border: 2px solid #5fa8d3; background-color: #5fa8d3; color: white;">문의하기</button>

				<button type="button" class="btn btn-warning" style="width: 100px; border: 2px solid #5fa8d3; background-color: #5fa8d3; color: white;"
					 onclick="location.href='${pageContext.request.contextPath}/mypage/mypage';">뒤로가기</button>
			</div>

			<!-- 전송 폼 -->
			<input type="hidden" name="content" id="content" />
		</form>
	</div>
</div>

<script>
	// 에디서 생성
	const editor = new toastui.Editor({
		el : document.querySelector('#editor'),
		height : '500px',
		initialEditType : 'wysiwyg', // markdown | wysiwyg
		previewStyle : 'vertical',
		placeholder : '',
		hideModeSwitch : true, // 마크다운/위지윅 전환 숨김
		plugins : [ toastui.Editor.plugin.colorSyntax ], // ✅ 색상 플러그인
	});

	// 폼 전송 시 에디터 내용 hidden input에 담기
	function submitEditor() {
		if (document.getElementById("to").value == "") {
			alert("받는사람 이메일주소를 입력하세요...");
			return false;
		}
		if (document.getElementById("subject").value == "") {
			alert("글제목을 입력하세요...");
			return false;
		}
		document.getElementById("content").value = editor.getHTML();
		console.log();
		if (document.getElementById("content").value == ''
				|| document.getElementById("content").value == '<p><br></p>') {
			alert("글내용을 입력하세요..");
			return false;
		}
		return true;
	}
</script>
