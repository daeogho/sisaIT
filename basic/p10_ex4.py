#연습문제4
#ATM 출금 프로그램을 작성하라

num = int(input("출금금액:"))

print("출금금액:",num)

if num%1000==0:
        if num>50000:
                result = "잔액부족"
        else :
                result = 50000-num
else : 
        result = "1000원 단위로 입력하세요"
        
print("남은잔액:", result)