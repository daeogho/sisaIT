#연습문제 5
# 구매 금액 할인 프로그램을 작성하라.

num = int(input("구매금액을 입력하세요:"))

print("구매금액",num)

if num>=100000:
        result = num*0.1
elif 50000<=num<100000:
        result = num*0.05
else:
        result = num
        
cost = num - result
print("할인금액:", result)
print("결제금액:", cost)