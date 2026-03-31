import datetime
from dateutil.parser import parse
"""
dateutil 패키지의 parser클래스를 사용하면 날짜/시간정보가 문자열로 된 것을
자동으로 datetime.datetime클래스 객체로 만들어준다.
"""

dt = parse('2026-04-30')
print(type(dt))
print('dt->', dt)

dt2 = parse('2027-03-10 10:23:14')
print('dt2->', dt2)

dt3 = parse('Apr 26, 2026 04:05:32 PM')
print('dt3->', dt3)

dt4=parse('6/7/2027')
print('dt4->', dt4)