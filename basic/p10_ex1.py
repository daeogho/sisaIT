# 연습문제1
# 나이를 입력받아 공원입장료 계산을 if문을 이용하여 작성하라.

num = int(input("나이를 입력하세요="))

if num<8:
        result = "미취학아동"
        cost = 2500
elif 8<=num<13:
        result = "초등학생"
        cost = 2000
elif 13<=num<20:
        result = "중/고등학생"
        cost = 2500
else :
        result = "성인"
        cost = 3000
        
print("%d세는 %s이며, 입장료는 %s입니다." % (num, result, cost))
print("{}세는 {}이며, 입장료는 {}입니다.".format(num, result, cost))
print("{나이}세는 {분류기준}이며, 입장료는 {요금}입니다.".format(나이=num, 분류기준=result, 요금=cost))
print(f"{num}세는 {result}이며, 입장료는 {cost:,}입니다.")