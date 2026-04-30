# while을 이용한 커피 자판기 프로그램
# 재고(잔)
coffee =10

while True :
        # 요금입력
        cash = int(input("돈을 넣어주세요"))
        
        if cash == 300:
                print("커피 한잔을 줌")
                coffee -= 1
        elif cash>300 :
                print("커피 한잔을 줌")
                print("거스름돈 %d를 줌" % (cash - 300))
                coffee -= 1
        else :
                print("돈을 돌려줌")
                print("커피안줌")
        # 재고 확인
        if coffee == 0 :
                print("재고 부족으로 커피판매를 종료합니다.")
                break
print("프로그램이 종료되었습니다.")