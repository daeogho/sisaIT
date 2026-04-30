# 문제
# 메뉴 선택프로그램
# 사용자가 메뉴를 선택하면 해당 메뉴가 주문되고, 주문 금액이 누적 계산되도록 프로그램을 작성합니다.

menu_list = {
        1:["아메리카노", 3000],
        2:["카페라떼", 4000],
        3:["녹차", 3500]
}
#메뉴
title = '''
===========카페 메뉴=============
1. 아메리카노(3,000원)
2. 카페라떼(4,000원)
3. 녹차(3,500원)
4. 종료
'''

while True:
        status = True
        total = 0
        while status:
                select_menu = int(input("메뉴를 입력하세요?"))
                if select_menu ==4:
                        status = False
                        print(f"총주문 금액 : {total:,}원")
                        print("*" * 50)
                else:
                        m = menu_list[select_menu] # ['아메리카노', 3000]
                        total += m[1] #주문한 총금액
                        print(f"{m[0]}주문완료")
                        print(f"현재 누적금액 : {total:,}원")                
        