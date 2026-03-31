#datetime패키지를 이용한 날짜와 시간 사용하기

# 1. 날짜처리를 위해서는 날짜처리하는 패키지를 import
import datetime
dt = datetime.datetime.now()

print('dt->', dt)

print('year->', dt.year, 'month->', dt.month, 'day->', dt.day)
print('hour->', dt.hour, 'minute->', dt.minute, 'second->', dt.second)
print('microsecond->', dt.microsecond) # 백만분의 1초

# 요일 : weekday, 0:월, 1:화, 2:수,,,, 6:일

week = dt.weekday()
print(type(week))
print('요일=>', week)
print('년월일->', dt.date(), type(dt.date()))

# format을 이용하여 날짜/시간을 표시하기
ymd = dt.strftime("%Y/%m/%d")
print(type(ymd))
print('년월일->', ymd)
print('요일명_일_월명_년도->', dt.strftime('%A %d. %B %Y'))
print('시분초->', dt.strftime('%H시 %M분 %S초'))

#strptime()
# 날짜 /시간정보가 있는 문자열을 날짜/시간 객체인 datetime으로 변환
dt2 = datetime.datetime.strptime('2026/10/15/14/15', '%Y/%m/%d/%H/%M')
print(dt2)
print('년월일->',dt2.date())
print('시분초->', dt2.time()) 

dt3 = datetime.datetime(2027, 1, 9, 15, 23, 45)
print(type(dt3))
print('dt3->', dt3)
print('dt3무슨요일인가 : ', dt3.weekday())
# dt3의 날짜는 무슨요일인가?