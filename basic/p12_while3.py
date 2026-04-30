# while문이 정상종료되면 else를 실행한다.

cnt = 0
while cnt < 3:
        print(f"카운트 : {cnt}")
        cnt += 1
else :
        print("while문이 정상 종료 되었습니다.")
    
# while문이 break로 중단되면 else문이 실행되지 않는다.
count = 1
while count<5  :
        if count == 3 :
                break
        print(f"카운트 : {count}")
        count += 1
else :
        print("while문이 중단되었습니다.")   
        
# 중첩 while문
i = 1
while i <= 3 :
        j = 1
        while j <= 3 :
                print(f"i={i}, j={j}")
                j += 1
        i += 1

# 구구단
# 2 3 4 5
# 6 7 8 9
i = 2
while i <= 9 :
        j = 2
        while j <= 5: 
                su = i * j   
                print(f"{j:2d} * {i:2d} = {su:2d}",end="") 
                j += 1
        print()
        i+=1
print()
ii = 2       
while ii <= 9 :
        jj = 6
        while jj <= 9:
                su2 = ii * jj
                print(f"{jj:2d} * {ii:2d} = {su2:2d}",end="") 
                jj+=1
        print()
        ii+=1
       
        
               
               
        
                  
              
        
       