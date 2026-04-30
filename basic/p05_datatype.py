#숫자형 : 정수, 실수, 복소수
#정수 : 양수, 음수, 0

a = 100
b = 200
print('type(a)=>', type(a), 'type(b)=>', type(b))
print("a=>", a, "b=>", b)
# 실수 : 소수점이 있는 숫자, 파이썬의 실수는 float형이다.
c = 12.6
d = .5
e = 5.
print("c=>", c, "d=>", d, "e=>", e, "type=>", type(c))
f = 3+4j # 4j가 허수부
g = complex(5, -2)
print('f=>', f, 'g=>', g, 'type=>', type(f))
#실수부(real)와 허수부(imag) 구하기
print('f.real=>', f.real, 'f.imag=>', f.imag)
print('g.real=>', g.real, 'g.imag=>', g.imag)
print("문자열->", "*" * 50)

t1 = "문자열"
t2 = "싱글따옴표"
t3 = """더블 따옴표를 3번으로 하여 문자열 처리가능
        여러줄의 문자열 처리 할수 있다."""

t4 = '''싱글 따옴표 3개도
        여러줄을
        표시할 수 있다'''
         # 주석문으로 사용가능하다.
'''주석문으로도
사용가능하다.'''
         
# 문자열내에 따옴표가 있을때 "결과를 \ "잘\" 나오게 하고 싶다."
t5 = "문자열 '중간'에 따옴표 표시하기"
t6 = '문자열 "중간"에 따옴표 표시하기'

print("t1=>", t1, 'type=>', type(t1))
print("t2=>", t2, 'type=>', type(t2))
print("t3=>", t3, 'type=>', type(t3))
print("t4=>", t4)
print("t5=>", t5)
print("t6=>", t6)

print("불리언=>", "*" * 50)
is_happy = True
is_sad = False

x = 5
y = 10
r = x > y # False

print(is_happy, is_sad, r, type(is_happy)) # boolean

print("List=>", ">" * 50)
# 리스트 : 여러개의 데이터를 하나의 변수에 저장
#           []사용하고, index가 있다.
#           리스트의 내에 리스트를 대입할 수 있다.
#           데이터 타입을 다양하게 저장할수 있다.
# 초기값이 없는 리스트
data1 = []
print(data1, type(data1))
# 초기값이 있는 리스트
data2 = ['apple', "사과", '''바나나''', """파인애플""", 125, 32.9, True, is_sad]
print(data2)

data2[2] = 'banana'
getdata = data2[3]

print(data2, getdata)

#list내에 list를 저장
data3 = [10,20,30, ['AAA', 'BBB', 'CCC']]
print('data3=>', data3)
print('data[3]=>', data3[3]) #['AAA', 'BBB', 'CCC']
print('data[-2]=>', data3[-2]) # 30

#리스트내의 리스트 중 특정값 접근

result1 = data3[3][1] #BBB
result2 = data3[-1][1] #BBB
result3 = data3[3][-2] #BBB
print("result=>", result1, result2, result3)

# 3중 리스트
data4 = [100,200,["가가가", ['XXX', 'YYY', 'ZZZ'],'나나나','다다다'],300]

result4= data4[2][1][2]
result5= data4[-2][-3][-1]
print(result4, result5)

#list의 슬라이싱
#                0      1     2      3      4        5
data5 = [10,20,30,40,50,60]
print(data5[1:3]) # [20, 30]
print(data5[:3]) # [10,20,30]
print(data5[:3]) # [40, 50, 60]

# 문자열에 슬라이싱
#         0     1     2    3
data6 = "가나다라마바사"
#      가나다라   가나다
print(data6[0:4], data6[:3], data6[3:5])

가 = [10,20,30,40]
나 = [100,200,300]
다 = 가 + 나
print('가+나=>', 다)

라 = 가*3
print('가*3=>', 라)

#데이터 갯수
print('len=>', len(라))

# 리스트의 데이터 삭제
del 라[2]
print(라)

del 라[2:8]
print(라)

print("튜플=>", '-' * 50)
# 튜플은 생성 후 수정할 수 없다.
# 튜플은 ()로 생성한다. ()생략하여 생성할수도 있다.
t1 = () # 데이터가 없는 튜플변수
print(t1, type(t1))
t2 = (100, 200, ) # 값이 2개이상일때는 마지막 ,를 생략 또는 표기하여도 된다.
t3 = (10) #튜플의 값이 1개일때 ,를 생략하면 정수,실수,문자 등의 값이 된다.
t4 = (10,)
print(t2, t3, t4)
print(type(t2), type(t3), type(t4))

t5 = ('A',('가', '나', '다'), 'B', 'C')

print(t2, t3, t4, t5)
print(type(t2), type(t3), type(t4), type(t5))

# 튜플의 인덱싱
t6 = t5[2]
print('t6=>', t6)
t7 = t5[1][2]
print('t7=>', t7)

# 튜플의 슬라이싱
t8 = t5[1:]
t9 = t5[1:3]
t10 = t5[:2]
print('t8->', t8, 't9->', t9, 't10->', t10)

t11 = t2 + t5
print('t11->', t11)

# 튜플의 곱하기
t12 = t2*3 #(100, 200)
print('t12->', t12)

# 튜플의 삭제 : 불가
# del t2[1]
# print('t2->', t2)

# 튜플의 길이
print(len(t5))

print('딕셔너리=>', '*' * 50)
# 딕셔너리는 key와 value를 가진다.
# key는 중복을 허용하지 않는 유일한 값이다.
# {}로 표기한다.
# key "", ''로 표기하여야 한다.

person = {"name":"이순신", "age":40,"city":"한반도"}
# value에 리스트 대입하기
score = {'jumsu':[60, 78, 56, 48], 'grade':'D'}
# value에 튜플 대입하기
product = {"proc":('컴퓨터',1500,'15inch')}

skill = {"김연아":"피겨스케이팅", "손흥민":"축구", "박태환":"수영"}

print(person, type(person))
print(score)
print(product)
print(skill)

# 요소 추가
person['tel']='010-4545-8989'
print(person)

# 요소삭제 person -> age
del person['age']
print(person)

# 딕셔너리의 모든 key를 구하기
key1 = skill.keys()
print('key1=>', key1)
print('key1=>', list(key1))

# 딕셔너리의 모든 value를 구하기 -> list
value1 = skill.values()
print('value1->', value1)
print('value1->', list(value1))


"""
사용자 정보를 딕셔너리 변수로 만들기
변수명 : user

아이디(id) : 본인아이디
이름(username) : 본인이름
나이(age) : 32
로그인상태(isLogin) : 논리형(로그인됨)
취미(hobby) : 축구, 등산, 여행이며 리스트로 생성
포인트(point) : 3000, 4500, 7000이 있으며 튜플로 생성        
"""

user = {
        "id":"daeogho", "username":"김대호", "age":32,
        "isLogin":True, "hobby":["축구","등산","여행"],
        "point": (3000,4500,7000)
}
print(user, type(user))

print("Set=>", '*'*50)
# set(집합)은 중복된 값을 허용하지 않는다.
# index접근이 불가능하다.
# 저장 순서를 유지하지 않는다.
# 값의 존재유무 확인가능
# 교집합, 합집합, 차집합을 구할 수 있다.
# {}로 set데이터를 생성할 수 있다.
fruits = {"apple","banana","cherry","apple","orange","banana"}
print(fruits, type(fruits))

# in키워드 set에 특정 데이터 존재유무 확인하기 (True, False)
result4 = "orange" in fruits #True
result5 = "pineapple" in fruits # False
print(result4, result5)

# list를 set변경하기
numbers = [20, 50, 90, 20, 40, 90]
# set()
setdata = set(numbers)
print('numbers->', numbers)
print('setdata->', setdata, type(setdata))

# tuple() : set를 튜플로 변경하기
tupledata = tuple(setdata) # (40, 50, 20, 90)
print('tupledata->', tupledata, type(tupledata))
print(tupledata[1:3]) # (50, 20)

s1 = set([10, 56, 75, 98, 102, 130])
s2 = {10, 36, 75, 90, 102, 150}
# &, intersection() : 교집합 : 2개의 set에 모두 있는 데이터

# 교집합 : &, intersection(), 2개의 set에 모두 있는 데이터
r1 = s1 & s2 # 10, 75. 102
r2 = s1.intersection(s2)
print('r1=>', r1, ', r2=>', r2)

# 합집합 : |, union(), 2개의 set를 합침. 단, 중복된 데이터는 버린다.
r3 = s1 | s2 # 10, 36, 56, 75, 90, 98, 102, 130, 150
r4 = s1.union(s2)
print('r3->', r3, 'r4->', r4)

# 차집합 : -, difference() : A - B 뺀 결과값
r5 = s1-s2 # s1 - s2 : 56, 98, 130
r6 = s1.difference(s2)
print('r5->', r5, 'r6->', r6, type(r5))

# add() : 값추가
r6.add(1000)
print('r6->', r6) # {56, 1000, 98, 130}

# 값 지우기
# s1 = {10, 56, 75, 98, 102, 130}
# remove()
s1.remove(75)
print('s1->', s1)
# s1.remove(120)
# print('s1->', s1)

# s1 = {10, 56, 98, 102, 130}
# 1200추가
s1.add(1200)

# clear() : 전체 삭제
s1.clear()
print(s1)

"""
[] = list()
() = tuple()
{} = dict() : key, value
{} = set() : value
        
a = []
a = list()

b = ()
b = tuple()

c = dict()

d = set()
"""