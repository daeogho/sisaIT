<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
form {
	width: 850px;
	height: 600px;
	text-align: center;
	align-content: center; /* 세로 중앙 */
	margin: 100px auto;
	border: 1px solid white;
	border-radius: 30px;
	background-color: white;
}

.loginText>input {
	width: 50%;
	padding: 12px;
	margin: 10px 0 20px 0;
	border-radius: 20px;
	border: 2px solid #5fa8d3;
	outline: none;
	background-color: #EBF8FF;
	color: #5fa8d3;
}

@keyframes floatUpDown {
 0% { transform: translateY(0);}
50%{ transform:translateY(-20px);}
100%{ transform:translateY(0);}
}
.ribbon {
	position: absolute;
	top: 40px;
	left: 50%;
	transform: translateX(-50%);
}

button {
	width: 30%;
	padding: 10px 20px;
	border-radius: 20px;
	border: none;
	cursor: pointer;
	background: #2d8ecf;
	color: white;
}

button:hover {
	background-color: #1f6fa5;
}

.mb-3>input {
	width: 50%;
	padding: 12px;
	margin: 5px 0 0 0;
	border-radius: 20px;
	border: 2px solid #5fa8d3;
	outline: none;
	background-color: #EBF8FF;
	color: #5fa8d3;
}
</style>

<script>
	function formCheck() {
		if (document.getElementById('userpwd').value === '') {
			alert("비밀번호를 입력후 수정하세요.");
			return false;
		}
		if (document.getElementById("username").value === '') {
			alert("이름을 입력하세요.");
			return false;
		}
		if (document.querySelector("#tel").value === '') {
			alert("연락처를 입력하세요.");
			return false;
		}
		return true;
	}
</script>

<c:if test="${not empty msg}">
<script>
    alert("${msg}");
</script>
</c:if>

<!---------------------------------------- HTML -------------------------------------------------->

<div id="loginBox"
	style="background-color: #a3ccea; position: relative; height: 100vh; overflow: hidden; align-items: center;">
	<img src="${ctx }/img/gurum1.png"
		style="position: absolute; width: 400px; height: 200px; top: 80px; left: 80px; animation: floatUpDown 3s ease-in-out infinite;" />
	<img src="${ctx }/img/gurum2.png"
		style="position: absolute; width: 500px; height: 250px; top: 120px; right: 100px; animation: floatUpDown 3s ease-in-out infinite;" />

	<form method="post"
		action="${pageContext.request.contextPath }/mypage/userEditOk"
		onsubmit="return formCheck()">
		<div class="ribbon">
			<img src="${ctx }/resources/image/userEdit.png" style="width: 400px;" />
		</div>

		<div class="mb-3">
			<label for="userid" style="font-weight: bold; font-size: 1.2em;">ID</label><br />
			<input type="text" id="userID" placeholder="아이디를 입력하세요."
				value="${dto.userID }" readonly name="userID" minlength="5"
				maxlength="15">
		</div>
		<div class="mb-3">
			<label for="userpwd" style="font-weight: bold; font-size: 1.2em">Password</label><br />
			<input type="password" id="userpwd" placeholder="비밀번호를 입력하세요."
				name="userpwd" minlength="5" maxlength="15">
		</div>
		<div class="mb-3 ">
			<label for="username" style="font-weight: bold; font-size: 1.2em">Name</label><br />
			<input type="text" id="username" placeholder="이름을 입력하세요."
				value="${dto.username }" name="username" minlength="2"
				maxlength="10">
		</div>
		<div class="mb-3">
			<label for="tel" style="font-weight: bold; font-size: 1.2em">Tel</label><br />
			<input type="text" id="tel" placeholder="ex)010-0000-0000"
				value="${dto.tel }" name="tel">
		</div>
		<div class="mb-3 ">
			<label for="email" style="font-weight: bold; font-size: 1.2em">Email</label><br />
			<input type="text" id="email" placeholder="ex)0000@naver.com"
				value="${dto.email }" name="email">
		</div>
		<button class="btn-primary" style="">회원정보 수정하기</button>
	</form>

	<div>
		<img src="${ctx }/img/jejudoMap.png"
			style="position: absolute; bottom: 0; right: 0; width: 20%" />
	</div>
</div>