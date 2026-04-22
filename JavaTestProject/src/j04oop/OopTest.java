package j04oop;

import java.util.Scanner;

public class OopTest extends Object{
	Scanner scan = new Scanner(System.in);
	public OopTest() {
	
}
	public void start() {
		// 최빈수, 화폐수구하기, 숫자 맞추는 게임, 로또번호 생성기
		do {
			System.out.print("\n메뉴(1.최빈수, 2.화폐수구하기, 3.숫자 맞추는게임, 4.로또번호 생성기, 5.종료)=>");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: 
				new ModeNumber();
				break;
			case 2 :
				MoneyCount2 mc =new MoneyCount2();
				mc.MoneyStart();
				break;
			case 3 : 
				new NumberMarche();
				break;
			case 4 :
				Lotto lt = new Lotto();
				lt.lottoStart();
				break;
			case 5 :
				System.out.print("종료되었습니다.");
				System.exit(0);
				
			
			}
			
		}while(true);
}
	public static void main(String[] args) {
		// 출력을 하기위해 메인메소드에 호출?
		OopTest ot = new OopTest();
		ot.start();

	}

}
