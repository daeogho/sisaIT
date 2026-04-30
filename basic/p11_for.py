# 반복문 (for)

# 리스트에 담긴 데이터 반복처리
data = ['hong', 456, [100, 200, 300], True]

for val in data:
        # 해당변수의 데이터형을 특정타입이 비교해준다(True, False)
        if isinstance(val, list):
              for v in val:
                      print(v)  
        else :
                print(val)
                
#리스트에 저장된 튜플을 꺼내 연산하여 출력하기
data2 = [(1,2,3), (10,20,30), (100,200,300)]
for (one, two, three) in data2:
        hap = one + two + three
        print(f"{one:3d}+{two:3d}+{three:3d}={hap:3d}")
        
#문제
test = [90,80,60,46,80,95,50,92,72,75]

for val in test:
        if val>=60:
                result = "합격"
        else:
                result = "불합격"
        print("{} = {}".format(val, result))
        
# 홍길동은 90점으로 합격입니다.
data3 = [('길동', 90), ('현수', 62), ('흥민', 55), ('로운', 80), ('상민', 100), ('종석', 39)]
for (name, score) in data3:   
                if score>=60:
                        result = "합격"
                else :
                        result = "불합격"
                        
                print(f"{name}은{score}으로{result}입니다.")
                
# continue
# 60점 이상만 출력
#for j in data3:
#        if j<60:
#                continue
#        print(f"{j}점은 합격입니다.")
        
# range() : 특정범위 숫자를 생성해준다.
n1 = range(10) #0~9
n2 = range(5,10) #5~9
n3 = range(1, 10, 2) #시작값, 최종값, 증가값

print(n1)
print(n2)
print(n3)

# 1,2,3,4,5
for i in range(1, 6):
        print(i)
print('*'*50)
# 2,4,6,8,10
for i in range(2,11,2):
        print(i)
print('-'*100)
# 10~ 100tkdldml 3의 배수만 출력
for i in range(12, 101, 3):
        print(i)
        
# range() 값을 list로 생성하기
data5 = list(range(1, 100, 10))
print(data5)

data6 = tuple(range(1,10,3))
print(data6)

for i in range(2, 10):
        for j in range(1,10):
                print(f"{i:2d} *{j:2d}={i*j:2d}", end='  ')
        print('')