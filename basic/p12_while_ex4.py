#연습문제 2
#숫자맞추기 게임
# 컴퓨터가 랜덤(1~100)하나 정합니다.
# 사용자가 숫자를 맞출 때 까지 반복하세요.

import random
answer = random.randint(1,100)
print(answer)
t = True
while t:
        num = int(input("숫자 입력 :"))
        if answer < num:
                print("더 작은 숫자입니다.")
        elif answer > num:
                print("더 큰 숫자입니다.")
        else :
                print("정답입니다")
                t = False
else:
        print("프로그램이 종료되었습닌다.")