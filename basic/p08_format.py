import math
# 문자열로 출력형식 만들기

# C-style Fomatting

num = 123
pi = math.pi

# %d : 정수, %f : 실수, %s : 문자열, %o : 8진수, %x : 16진수(소문자), %x : 16진수(대문자)
# %e : 지수표시(소문자), %E : 지수표시(대문자), %% : %문자를 출력
print("정수 : %10d, 실수 : %10.2f, 실수 : %f" %(num, pi, pi))
print("문자열 : %10s, 문자열 : %10s, 16진수 : %X, 지수 : %E" % ("apple", "파인애플", num, pi))

# curly bracket Formatting
# {}를 이용한 포멧
print("{}는 정수 이다. {}은 파이의 값이다.".format(num, pi))
print("num의 값은 {}이고, 파이의 값은 {:2.4f}입니다.".format(num, pi))

name = "홍길동"
bank = "국민은행"
print("{이름}의 현재 잔고는 {원}원이고, {이름}님의 은행은 {은행이름}입니다.".format(이름=name, 원="2억", 은행이름=bank ))

print("파이의 값은 {파이:.4f}이다".format(파이=pi))

# 리스트 or 튜플
names = list(['홍길동','이순신','김삿갓','윤동주'])
print("학생이름은 다음과 같습니다. {}".format(names))

jumsu = {89,43,65,23}
print("학생의 점수 목록입니다. {}".format(jumsu))

# A반 학생은 홍길동, 박세리, 박태환, 김연아 set()
# B반 학생은 홍길동, 김연아, 손흥민, 김길리가 있다. set()

# A반과 B반에 모두 속한 학생을 출력하라.
# A반과 B반에 모두 속한 학생은 홍길동, 김연아 입니다.

aban= set(['홍길동', '박세리', '박태환', '김연아'])
bban= ['홍길동', '김연아', '손흥민', '김길리']

hab = aban.intersection(bban)
print("A반과 B반에 모두 속한 학생은{}입니다".format(hab))

# f-style Formatting
# 문자열 왼쪽 f 또는 F를 붙인다.

name = "홍길동"
pi = math.pi
print(f"나의 이름은 {name}이다.")
print(f"파이의 값은 {pi:.3f}이다.")

print(f"{pi=}")
print(f"{pi=:2.2f}")

a, b, c, d = 100, 200, 300 ,400
# [] : list, () : 튜플, {key:value}: 딕셔너리, {value}:Set

new_tuple = 10, 20, 30, 40 # (), 소괄호 생략가능
print(new_tuple, type(new_tuple))
print(f"{new_tuple=}")

score = {
        "태환":100,
        "연아":150,
        "흥민":200
}
print(f"{score=}")