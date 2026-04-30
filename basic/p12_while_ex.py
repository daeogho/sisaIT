# 비밀번호 확인 프로그램
password = 1234

i = 1
while i <=5 :
        indata = int(input("비밀번호 입력 : "))
        if password == indata :
                print("로그인 성공")
                break
        else :
                print("틀렸습니다.")
        i += 1
else :
        print("5번 실패로 잠금처리 되었습니다.")
