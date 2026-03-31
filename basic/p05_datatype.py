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