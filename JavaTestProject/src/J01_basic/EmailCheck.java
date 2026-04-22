package J01_basic;

import java.util.Scanner;

public class EmailCheck {
	public EmailCheck() {}
	public void emailCheck() {
		Scanner scan = new Scanner(System.in);
		
		do {
			//이메일 입력
			System.out.print("이메일입력=");
			String email = scan.nextLine(); // 1줄 입력(enter포함)
			//유효성      abcdefg@nate.com
			// indexOf() : 특정문자의 index위치를 구하고 없으면 -1
			int atMark = email.indexOf("@");
			int lastAtMark = email.lastIndexOf("@");
			// nate.com korea.co.kr
			int point = email.indexOf(".");
			
			
			if(atMark == -1 || atMark !=lastAtMark || point== -1 || atMark > point) { // 잘못된 이메일 일때
				System.out.println(email + "은 잘못된 이메일주소입니다...");
			}else {// 정상 이메일일 경우
				String emailSplit[] = email.split("@");  // emailSplit[0]=abcdf, emailSplit[1] = nate.com
				System.out.println("아이디= " + emailSplit[0]);
				System.out.println("도메인=" + emailSplit[1]);				
			}
			
		}while(true);
		
	}

	public static void main(String[] args) {
		new EmailCheck().emailCheck();

	}

}
