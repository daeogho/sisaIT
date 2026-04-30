#문제 1 
# 단을 입력받아 구구단을 출력하라

num = int(input("단 :"))

for i in range(1, 10):
        print(f"{num:2d} * {i:2d} = {num*i:2d}")
        
#문제2

print("이름 국어 영어 수학 총점 평균 학점")
print("="*28)
students = [
        ["민수",85,78,89],
        ["지훈",92,90,23],
        ["서연",78,89,27],
        ["유나",96,98,78],
        ["하준",88,98,33]
]


for data in students : # ["민수", 85, 78, 89]
        
        #총점
        total = 0
        for jum in data[1:]:
                total += jum
                
        #평균
        ave = total / len(data[1:])
        
        #학점
        if ave>=90:
                grade = 'A'
        elif ave>=80:
                grade = 'B'
        elif ave >= 70:
                grade = 'C'
        elif ave >= 60:
                grade = 'D'
        else:
                grade = 'F'
        print(f"{data[0]:2}", end='')
        for j in data[1:]:
                print(f"{j:6d}", end='')
        print(f"{total:6d}{ave:7.1f}", end='',)
        print("%4s" % (grade))
#for (name, kor, eng, mat) in students:
#        total = kor+eng+mat
#        avg = total /3
#        if avg>=90:
#                grade="A"
#        elif 80<=avg<90:
#                grade="B"
#        elif 70<=avg<80:
#                grade="C"
#        else:
#                grade="D"
               
#        print(f"{name}{kor:4d}{eng:5d}{mat:5d}{total:5d}{avg:6.1f}  {grade} ")