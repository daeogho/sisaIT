#문제
#while문으로 구구단 4단씩 출력하기

startDan = 2 
while startDan <= 9: 
        i = 2
        while i <=9:
                dan = startDan
                while dan<startDan+4: # 2,3,4,5
                        print("%2d * %2d = %2d" % (dan, i, (dan*i)), end=' ')
                        dan += 1
                print('')
                i += 1
        startDan += 4
else:
        print("구구단 출력이 완료 되었습니다.")