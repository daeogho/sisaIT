# 문제 3
# ATM 미니 프로그램 만들기
# while문과 조건문을 이용하여 ATM 프로그램을 작성하시오
# 사용자가 메뉴를 선택하여 잔액 조회, 입금,출금, 종료 기능을 사용할 수 있도록 프로그램을 작성합니다.

#잔고
money = 10000
head = """
        === ATM ===
        1.잔액조회, 2.입금, 3.출금, 4.종료
"""
m = 0
while m<4:
        print(head)
        
        menu = int(input("이용할 서비스를 선택하세요."))
        if 0<menu<=4: #정상처리
                if menu == 1:
                        print(f"현재잔액 : {money:,}")
                        break
                elif menu ==2:
                        inmoney = int(input("입금할 금액을 입력하세요."))
                        money += inmoney
                        print(f"입금완료 : {money:,}원")
                elif menu ==3:
                        outmoney = int(input("출금할 금액을 입력하세요."))
                        money -= outmoney
                        print(f"출금완료 : {money:,}원")
        elif menu ==4:
                continue
        else: # 1,2,3,4가 아닐때
                print("1~4까지의 번호를 눌러주세요.")
                menu = 0

else:
        print("프로그램이 종료 되었습니다.")