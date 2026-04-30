# 임의의 정수를 입력받아 홀수, 짝수, 0을 표시하라
# 5는 홀수입니다.

num = int(input("정수입력="))

if num>0 :
        result = "양수"
elif num<0:
        result = "음수"
else:
        result = "0"
        
print("%d는 %s입니다." % (num, result))

# 학점구하기
kor = int(input("국어="))
eng = int(input("영어="))
mat = int(input("수학="))

total = kor + eng + mat
avg = total / 3 # avg = total

if avg>=90:
        grade = "A"
elif avg>= 80:
        grade = "B"
elif avg>= 70:
        grade = "C"
elif avg>= 60:
        grade = "D"
else:
        grade = "F"

print("총점=%f" % (total))
print("평균={}".format(avg))
print(f"학점={grade}")

