# while문 : 조건식이 있으며, 논리형 결과값으로 수식을 세운다.

treeHit = 0

while treeHit<10 :
        treeHit += 1
        print("나무를 %d번 찍었습니다." % treeHit)
        if treeHit == 10 :
                print("나무가 넘어갔습니다.")

prompt = """
1.Add
2.del
3.List
4.Quit

Enter number :"""

number = 0
while number != 4:
        print(prompt)
        number = int(input())

# 문제
nlist = [12,3,1]
prompt = """
1.추가
2.수정
3.삭제
4.목록
5.종료

Enter number :"""

number = 0

while number != 5:
        print(prompt)
        number = int(input())
        if number == 1 :
                add = int(input("추가할 값:"))
                nlist += [add] 
                print(nlist)
        elif number == 2:
                print(nlist)
                select = int(input("어떤값을 수정할까요 : "))
                updata = int(input("무엇으로 수정할까요 : "))
                for j in range(len(nlist)):
                        if nlist[j] == select :
                                break
                #del nlist[j] 
                nlist[j] = updata
                print(f"리스트 목록: {nlist}")
        elif number == 3:
                print(nlist)
                select = int(input("어떤값을 삭제할까요 : "))    
                for j in range(len(nlist)):
                        if nlist[j] == select :
                                break
                del nlist[j] 
                print(f"리스트 목록: {',' .join( map(str, sorted(nlist)))}")
        elif number == 4 :
                # data.sort(reverse=True),sorted(data, reverse=True) : 내림차순
                # map():int를 문자열로 변환
                print(f"리스트 목록: {',' .join( map(str, sorted(nlist)))}")      
'''
a = [3,9,2]

원본이 변경됨
a.sort() = > a = [1,3,9]

원본이 유지됨
sorted(a) => a = [3,9,1]
'''

                  
                      
        