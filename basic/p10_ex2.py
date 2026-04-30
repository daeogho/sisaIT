#연습문제2
#등수를 입력받아 메달의 색상을 구하는 프로그램을 작성하세요

num = int(input("등수를 입력하세요="))

if num==1:
        rank ="Gold"
elif num ==2:
        rank = "Silver"
elif num ==3:
        rank == "Bronze"
else:
        rank == "등수미달입니다"
        
print("%d등의 메달 컬러는 %s입니다" % (num,rank))