#연습문제3
#국어,영어,수학점수를 입력받아 성적처리하는 프로그램을 작성하라.

kor = int(input("국어점수:"))
eng = int(input("영어점수:"))
mat = int(input("수학점수:"))

total = kor + eng + mat
avg = total /3

if avg>=60:
        result = "합격"
elif avg<60:
        result = "평균미달로 불합격"

if kor & eng & mat <40:
        result = "과락으로 불합격"

print(result)