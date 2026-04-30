# if문

if True:
        print("헬로우 조건문~~~")
        a = 100
        b = 200
        c = a+b
        print(f"a+b={c}")
        
if False:
        print('조건이 참일때 실행됨..')
        
# int() : 문자열 숫자(정수)로 변환
# float() : 문자열 숫자(실수)로 변환
# input() : 실행중 콘솔에서 문자열을 입력

inData = float(input("정수를 입력하세요? =>"))

result = inData + 10

print(f"{result}") #print("result=", result)

inData2 = bool(input("논리형값입력(True, False)?=>"))
if inData2 :
        print("True입력됨")
        
if not inData2:
        print("False입력됨")

# if-else문
if indata%2 == 0 :
        # 참일때
        print(f"{inData}는 짝수입니다.")
else:
        print("{}는 홀수 입니다.".format(inData))
        