#컴프리헨션
#리스트내에서 사용하는 반복문

#리스트의 데이터를 이용하여 또 다른 리스트 만드는 방법

data1 = [10, 20, 30, 40, 50]

#data1의 값을 이용하여 result1리스트 만들기
#result1의 값은 data1의 값에 5배를 한 값으로 만든다.

result1 = [] # result1 = list()
for d in data1:
        result1.append(d*5)
print('result1 =>{}'.format(result1))
print('result1 =>{}'.format(','.join(map(str, result1))))

#리스트내에서 반복문을 이용하여 처리하기 : 컴프리헨션
#data1의 값을 3배하여 result2리스트 만들기
result2 = [a*3 for a in data1]
print('result2=>'.format('/'.join(map(str, result2))))

#리스트내의 for에 if문 함께 사용하기
data3=[10,15,20,25,30,35,40]
#짝수만 3배하여 시트를 생성하라.
result3 = [n*3 for n in data3 if n%2==0]

print(f" result3 = {result3}")

# 컴프리헨션으로 중첩 for문 사용하기
result4 = [i*j for i in range(2,10) for j in range(1, 10)]
print(f"result4 = {result4}")

#짝수단만 결과값을 가진 result5
result5 = [i*j for i in range(2,10,2) for j in range(1,10)]
print(f" result5 = {result5}")

# for문에서 break
for x in range(10):
        if x > 5:
                break
        print(x)
        
#for ~ else문
#반복문이 정상종료 되었을때 else문을 수행한다.
#break에 의해 종료된 경우를 실행하지 않는다.
for i in range(1,11):
        print(i, end=',')
else:
        print("반복문이 정상종료 되었습니다.")
        
names = ['길동', '동수', '가람', '해진', '지훈', '동찬']
for n in names:
        print('이름={}'.format(n))
        if n=='해진':
                #break
                continue
else:
        print("반복문이 break에 의해 중단됨.")
        
#enumerate함수 활용하기

data4 = ["해바라기", "장미", "코스모스", "히야신스", "튤립"]
num = 0
for flower in data4:
        num += 1
        print(f"{num}=>{flower}")
        
# index(0), value
for idx, f in enumerate(data4):
        print("{}->{}".format(idx, f))
        
# index를 원하는 값부터 시작하도록 설정하기
for idx, fw in enumerate(data4, 101):
        print("%d => %s" % (idx, fw))
        
print('#'*50)
# zip()함수 : 여러개의 list데이터가 저장된 경우 한번에 반복처리 할 수 있다.
stu = ["길동", "해수", "연아", "경찬", "순신"]
jumsu = [56, 89, 41, 99, 96]

#길동 => 56점 => fail
#순신 => 96점 => pass
for n, j in zip(stu, jumsu):
        if j>=60:
                p = 'pass'
        else:
                p = 'fail'
        print(f"{n}=>{j}점=>{p}")
        
#list가 3개이상일때
stu = ["길동", "해수","연아","경찬","순신"]
kor = [56,89,41,99,78]
eng = [56,39,41,87,75]
mat = [42,73,14,95,45]

#길동 국어:56점 영어:23점 수학:98점
for n, k, e, m in zip(names, kor, eng, mat):
        print(f"{n} 국어:{k}점 영어:{e}점 tngkr:{m}")