#연습문제 1
# 1부터 100까지 합

sum=0
for i in range(0, 101):
        sum += i
print(f"1~100까지합= {sum}")

#연습문제 2 1~20까지의 짝수만 출력
for i in range(2,21,2):
        print(i, end=' ')
print('')

for i in range(1,21):
        if i%2==0:
                print(i, end=' ')
print('')

# 연습문제 3
# 단을 입력받아 개의 단을 출력하라.
# 단은 1~9단까지이며 단을 잘못입력하면 다시 입력받는다.

import itertools 
for q in itertools.count(): # for문 무한루프 
        
        num = int(input("단을 입력하세요:"))

        if num>=1 and num <10:
        #출력할 단
                outputDan = [d for d in range(num,num+3) if d<=9]
                """     start = num
                end = num+3
                if end>10:
                        end = 10
                """
                print(outputDan)
                for i in range(2, 10): #2
                        for d in outputDan: #5
                                result = d * i
                                print(f"{d:2d} * {i:2d} = {result:2d}", end=' ')
                        print('')
        else:
                print("단을 잘못입력하였습니다.(1~9까지만 입력하세요.)")