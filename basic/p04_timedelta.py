import datetime
# timedelta는 날짜와 시간을 연산
# datetime팩키지에 있는 클래스 

dt1 = datetime.datetime.now() # 오늘날짜
dt2 = datetime.datetime(2026, 5, 10)

print("dt1==>", dt1)
print("dt2==>", dt2)

#
print(datetime.timedelta(45, 3600))

# dt2:2026/5/10 dt1:현재날짜
dt = dt2 - dt1
print("일수=>", dt.days)
print("초=>", dt.seconds)
print("마이크로초=>", dt.microseconds)

# 전체를 초로 환산
print("total_seconds=?", dt.total_seconds())
                                #일 초
print(dt1 + datetime.timedelta(445, 3600))

print(dt1 + datetime.timedelta(100))

dt3 = datetime.datetime(2026, 11, 9)
print('수능날짜 : ',(dt3-dt1).days)