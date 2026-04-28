<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb509c46c771c3734afd3a62afb5b566&libraries=services"></script>
<%@ page import="java.util.Calendar" %>
<%
    // 1. 현재 날짜 및 파라미터 처리
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    String y = request.getParameter("year");
    String m = request.getParameter("month");
    if(y != null) year = Integer.parseInt(y);
    if(m != null) month = Integer.parseInt(m);

    // 달력 세팅
    cal.set(year, month, 1);
    int startDay = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일
    int endDay = cal.getActualMaximum(Calendar.DATE); // 월의 마지막 날짜
%>
<style>
	#weather{
		  padding:0; 
		  justify-content: center;  /* 세로 가운데 */
    	  align-items: center;      /* 가로 가운데 */
    	  text-align: center;       /* 글자 가운데 */
	}
	#weatherBox{
		width:400px; height: 400px;
		margin: 100px 150px;
	}
	#weatherDate{
		font-size: 2em; font-weight: bold; margin:10px 0px;
	}
	#wDate{
		 display: flex; 
		 justify-content: space-between; /* 양쪽 끝으로 */ 
		 margin-top:50px;

	}
	.wDateBox{ 
		padding:30px; 
		border:1px solid #FFF3BE; 
		background-color: #FFF3BE; 
		border-radius: 10px;
		font-size:1.5em; 
		font-weight: bolder;
		color: #FF9C00;
	}
	.content{ 
			display: flex; 
			justify-content: center;   /* 가로 가운데 */ 
    }
	.category{
		min-height: 100vh;
		width:100%;
		background-color: #a3ccea;
	}
	#btn-category img:hover {
    	transform: scale(1.1);  /* 10% 확대 */
	}
	#homeCtg-btn{
		display: flex; text-align:center;
	}
	#homeCtg-btn img:hover{
		transform: scale(1.1);  /* 10% 확대 */
	}
	@keyframes floatUpDown {
    0%   { transform: translateY(0); }
    50%  { transform: translateY(-20px); }
    100% { transform: translateY(0); }
	}
	.categorytext {
	    text-align: center;
	    opacity: 0;
	    transform: translateY(30px);
	    transition: all 0.8s ease-out;
	}
	.categorytext.show {
	    opacity: 1;
	    transform: translateY(0);
	}
</style>

</style>

<!-- 상단 -->
<div>
	<!-- 상단이미지 -->
	<div class="main_topImg">
		<img src="${ctx }/img/mainImg.jpg" style="width:100%"/>
	</div>
	<!-- 제주날씨, 달력 -->
	<div class="content">
		<div id="weatherBox" style="">
			<p style="font-size: 1.6em; font-weight: bold;  text-align: center;">오늘의 제주날씨</p>
			<div id="weather" ></div>
		</div>
		<div id="calender" style="margin: 100px 150px; padding:10px; ">
			<h2 style="text-align: center; font-weight: bold; font-size: 2em;"><%=year%>년 <%=month+1%>월</h2>
			    <table style="  width:400px; height: 400px; ">
			        <tr style=" font-size:1.5em">
			            <th style="color:red;">일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
			        </tr>
			        <tr >
			        <%
			            // 2. 1일 전까지 빈 칸 출력
			            for(int i=1; i<startDay; i++){
			                out.println("<td style='font-size:1.5em'></td>");
			            }
			            // 3. 1일부터 말일까지 출력
			            for(int i=1; i<=endDay; i++){
			            	if(i==day)out.println("<td style='font-size:2em; color:#FF7F27; font-weight:bold; '>"+i+"</td>");
			            	else out.println("<td style='font-size:1.5em'>"+i+"</td>");
			                
			                startDay++;
			                if(startDay%7 == 1) out.println("</tr><tr>"); // 7일마다 줄바꿈
			            }
			        %>
			        </tr>
			    </table>
		</div>
	</div>
	
	<!-- 지도,버튼카테고리  -->
	<div class="category">
	
		<div style=" display: flex; justify-content: space-between; /* 양쪽 끝으로 */">
			<img src="${ctx }/img/gurum1.png" style="width:400px; height: 200px; animation: floatUpDown 3s ease-in-out infinite;"/>
			<img src="${ctx }/img/gurum2.png" style="width:500px; height: 250px; animation: floatUpDown 3s ease-in-out infinite;"/>
		</div>
		
		<div style="width:1400px; display: flex; margin:0px auto; justify-content: space-between;">
		
			<div style="width:900px;">
				<div class="categorytext" style="text-align:center;">
						<img src="${ctx }/img/categorytext.png" />
				</div>
				<div id="homeCtg-btn">
						<div><a href="${ctx }/season/list?season=spring"><img src="${ctx }/img/spring.png" style="width:200px"/><img src="${ctx }/img/btnText1.png" style=" height: 40px"/></a></div>
						<div><a href="${ctx }/season/list?season=summer"><img src="${ctx }/img/summer.png"style="width:200px"/><img src="${ctx }/img/btnText2.png" style=" height: 40px"/></a></div>
						<div><a href="${ctx }/season/list?season=fall"><img src="${ctx }/img/fall.png"style="width:200px"/><img src="${ctx }/img/btnText3.png" style="height: 40px"/></a></div>
						<div><a href="${ctx }/season/list?season=winter"><img src="${ctx }/img/winter.png"style="width:200px"/><img src="${ctx }/img/btnText4.png" style="height: 40px"/></a></div>
				</div>
			</div>
			<div style="width:900px;">
				<img src="${ctx }/img/jejumap.png" />
			</div>
		</div>
	</div>	
</div>	
	
	
<script>
	function openWeatherReceive(){
		fetch('https://api.openweathermap.org/data/3.0/onecall?lat=33.3766&lon=126.5437&exclude=hourly,daily&appid=9469eddb61f9f3df9a022df0a2864963&units=metric')
		.then(response=>{
			return response.json();
		})
		.then(data=>{
			console.log(data)
			var date = new Date();
			console.log(date.getMonth(), date.getDate())
			var tag = `<div id='weatherDate'>`+(date.getMonth()+1)+`월 `+date.getDate()+`일</div>
						<div><img src="${ctx}/img/`+data.current.weather[0].icon+`.png" style="width:250px;"/></div>
						<div id='wDate'><div class='wDateBox'>온도 `+data.current.temp+`℃</div>
						<div class='wDateBox'>습도 `+data.current.humidity+`%</div></div>`
			
			document.getElementById("weather").innerHTML = tag;
		})
		.catch(error=>{
			console.log(error)
		})
	}
openWeatherReceive();
	// 카테고리 텍스트 효과(스크롤 내렸을때 나타나기)
	document.addEventListener("DOMContentLoaded", function() {
	    const target = document.querySelector(".categorytext");
	
	    const observer = new IntersectionObserver((entries) => {
	        entries.forEach(entry => {
	            if (entry.isIntersecting) {
	                target.classList.add("show");
	            } else {
	                target.classList.remove("show"); 
	                // 스크롤 올라가면 다시 사라지게 (반복 효과)
	            }
	        });
	    }, { threshold: 0.3 });
	
	    observer.observe(target);
	});

</script>



