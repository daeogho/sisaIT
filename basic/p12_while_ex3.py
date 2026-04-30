#연습문제
#비밀번호 확인 프로그램
#사용자가 비밀번호를 입력하여 비밀번호를 맞출때까지 반복실행하는 프로그램을 작성하라

pwd = ("1234",) # 튜플타입은 값을 수정할 수 없다.

count = 0
while True:
        user_pwd = int(input("비밀번호 : "))
        
        if pwd[0] == user_pwd:
                print("로그인 성공하였습니다.")
                break
        elif pwd[0] != user_pwd:
                print("비밀번호를 잘못입력하였습니다.")
                count += 1
                if count == 5:
                        print(f"{count}번 실패로 잠금처리 되었습니다.")
                        break
        
