<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <style>
 				form{
 					width:850px;
                	height:600px;
                	text-align: center;
                	align-content:center;      /* 세로 중앙 */
                	margin: 100px auto;
                	border:1px solid white;
                	border-radius:30px;
                	background-color:white;
                	
 				}
             
                h1{
                       line-height: 300px;
                }
                .loginText>input{
                        width: 50%;
					    padding: 12px;
					    margin: 10px 0 20px 0;
					    border-radius: 20px;
					    border: 2px solid #5fa8d3;
					    outline: none;
					    background-color:#EBF8FF;
					    color:#5fa8d3;
                }             
                input[type=submit]{
                        background: #2677AD;
				   		color: white;
                        width: 50% ; height:50px;
                        margin:20px 0px;
                        border-radius: 20px;
				    	border: none;
				    	font-size: 1.2em;
				    	font-weight: bold;
                }
                input[type=submit]:hover {
    			background-color: #164463;
				}
                /* 버튼 */
				.btn-group {
				 	width: 50%;
				 	margin:0 auto;
   					display: flex;
    				justify-content: space-between;
				}
				button {
				    padding: 10px 20px;
				    border-radius: 20px;
				    border: none;
				    cursor: pointer;
				    
				}
				button:hover {
    			background-color: #1f6fa5;
				}
				
				.btn-primary {
				    background: #2d8ecf;
				    color: white;
				}
				
				.btn-outline {
				    background: #2d8ecf;
				    color: white;
				}
				.ribbon{
				    position: absolute;
				    top: -25px;
				    left: 50%;
				    transform: translateX(-50%);
				}
				@keyframes floatUpDown {
			    0%   { transform: translateY(0); }
			    50%  { transform: translateY(-20px); }
			    100% { transform: translateY(0); }
				}
              
        </style>
<script>
	function logCheck(){
                        if(document.getElementById("userID").value == ""){
                                alert("아이디를 입력하세요.");
                                return false;
                        }
                        if(document.getElementById("userpwd").value==""){
                                alert("비밀번호를 입력하세요..");
                                return false;
                        }
                        return true;
                }
</script>
<div id="loginBox" style="background-color: #a3ccea;position: relative;height: 100vh;overflow: hidden;  align-items:center;">
			<img src="${ctx }/img/gurum1.png" style="position: absolute; width:400px; height: 200px; top: 80px; left: 80px;animation: floatUpDown 3s ease-in-out infinite;"/>
			<img src="${ctx }/img/gurum2.png" style="position: absolute; width:500px; height: 250px; top: 120px; right: 100px; animation: floatUpDown 3s ease-in-out infinite;"/>
		
	     
	   <form method="post" action="${pageContext.request.contextPath}/users/loginOk" onsubmit="return logCheck()">
			<div class="ribbon"><img src="${ctx }/img/loginLogo.png" style="width:500px;"/></div>	            
	        <div class="loginText">
		         <input type="text" name="userID"  id="userID" placeholder="아이디(5~15자의 영문,숫자만 가능)" /><br/>
		         <input type="password" name="userpwd"  id="userpwd" placeholder="비밀번호(입력 실패 5회 시 잠금처리)" /><br/>
	        </div>
	            
		   <input type="submit" value="로그인"><br/>
		   <div class="btn-group">
		       <button class="btn-primary">회원가입</button>
               <button class="btn-outline">ID / 비번 찾기</button>
	       </div>
	  </form>
      <div>
      		<img src="${ctx }/img/jejudoMap.png" style="position: absolute;bottom: 0;right: 0;width:20%"/>
      </div>
</div>


        
        