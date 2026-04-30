# 연습문제4
# for문을 사용하여 다음과 같이 출력하세요.

for i in range(1,6):    
        for j in range(1, i+1):
                print("*", end= '')
        print('')
        
for i in range(5,0,-1):
        for j in range(1, i+1):
                print("*", end='')
        print('')
        
# 연습문제5
# 다음리스트의 총합을 구하는 프로그램을 작성하세요.

nums = [10,20,30,40,50]
sum = 0
for i in nums:
        sum = sum + i
print(f"합 = {sum}") 

# 연습문제6
#학생 점수 평균 구하기
 
scores = [80,90,75,100,85]
sum = 0
for i in scores:
        sum = sum+i
        avg = sum/ len(scores)
print(f"평균 = {avg}")
print("-"*100)

# 연습문제 7
# 사용자가 입력한 숫자5개의 합을 구하세요.

sum=0
for num in range(1,6):
        num = int(input("숫자 입력 : "))        
        sum = sum+num
print(f"총합 = {sum}")
print("-"*100)

# 연습문제 8
# 구매 금액 할인 계산 

prices=[12000,35000,18000,25000]

for p in prices:
        if p>20000:
                discount=p*0.1
                result = p-discount
                print(f"{p:,d}원 -> {result:,.0f}원")
        else:
                discount=0
                result = p-discount
                print(f"{p:,d}원 -> {int(result):,}원")
                
# 연습문제 9
# 약수구하기

num = int(input("숫자 입력 : "))
for i in range(1, num+1):
        if num%i==0:
                result = i
                print(f"{num}의 약수: {i}")