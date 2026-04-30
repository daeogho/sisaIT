import math

# 내장함수
# pow() 함수 : 거듭제곱 = **
a = 5
b = 3

r1 = a ** b
r2 = pow(a, b)

print(r1, r2)

# divmod()함수 : 몫과 나머지를 한번에 구한다.
# // (몫), %(나머지)
x = 245
y = 100

r3 = x//y #2
r4 = x % y #45

r5, r6 = divmod(x,y)

print(r3, r4)
print(r5, r6)

#--------------------------------------------------------
pi = math.pi
print('pi->', pi)
print('sqrt->', math.sqrt(10)) #제곱근
print('isqrt->', math.isqrt(10)) #제곱근을 정수로
print('ceil->', math.ceil(35.1)) # 올림
print('floor->', math.floor(35.9)) #버림
print('round->', round(35.5))

# [문제 1]
a,b,c,d = 3,6,5,9
r1 = (a-c) **2
r2 = (b-d) **2
r3 = r1+r2
r4 = math.sqrt(r3)
print(r4)
# [문제 2]
ta = 15
tb = 37
r5 = 1/2 * ta * tb * math.sin(math.radians(37))
print(r5)
# [문제3]
t1 = 2 ** 72 % 7 # pow(2,72) % 7
t2, t3 = divmod(5627, 32)

r9 = t1 + t2+ t3
print(r9)