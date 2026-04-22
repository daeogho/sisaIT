package j04oop;

import java.util.Random;
import java.util.Scanner;

public class NumberMarche {

	public NumberMarche() {
		numberStart();
	}
	public void numberStart() {
		
		// 1~100까지의 난수를 만들어 맞추는 게임
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int ranInt = ran.nextInt(100)+1; // 난수생성 큰수-작은+1
		// 입력받은 횟수를 카운트위한 변수를 선언
		int cnt = 0;
		
		Label_1 : do {
			System.out.print("1~100사이의 정수를 입력하세요.?=");
		int inData = scan.nextInt();
		cnt++; // ++cnt, cnt+=1, cnt=cnt+1
		
		for(int i=1; ; i++) {
			if(ranInt > inData) { // 난수가 더 클때
				System.out.println("더 큰 값을 입력하세요..."); continue Label_1;//
			}else if(ranInt < inData) {  // 난수 더 작을때
				System.out.println("더 작은값을 입력하세요...");continue Label_1;//
			}else {  //난수와 입력받은 값이 같을때
				System.out.println("숫자를 맞추었습니다...난수="+ ranInt);
				System.out.println(cnt+"번째에 맞추었습니다."); break;		
				} 
		}
		
	
		System.out.print("계속 할거?");	
		int que = scan.nextInt();
		if(que == 2) { 
				System.out.println("게임이 종료 되었습니다.");
				System.exit(0);
				} 
		}while(true);
		
		
							

			
	}

}
