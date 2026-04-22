package j00_ApiClass;

import java.util.Arrays;

public class StringTest2 {

	public static void main(String[] args) {
		// equals() : 대소문자를 구별한다.
		// equalsIgnoreCase() : 대소문자 구별하지 않는다.
		
		String language = "Java";
		String language2 = "JAVA";
		
		boolean result = language.equals(language2); // ==와 같은 의미인데 참,거짓을 판단
		if(result) {
			System.out.println("equals실행시\n" + language + "와" + language2 + "는 같다.");
		}else {
			System.out.println("equals실행시\n" + language + "와" + language2 + "는 다르다.");
		}
		if(language.equalsIgnoreCase(language2)) {
			System.out.println("equalsIgnorCase실행시\n" + language + "와" + language2 + "는 같다.");
		}else
			System.out.println("equalsIgnoreCase실행시\n" + language + "와" + language2 + "는 다르다.");
		
		// >,<, >=, <=
		// compareTo() : 대소문자 구별하여 크기비교
		// compareToIgnoreCase() : 대소문자 구별없이 크기비교

//--------------------------------------------------------------------------------
		String food = "사과";
		String food2 = "복숭아";
		
		int result2 = food.compareTo(food2);
		
		if(result2 ==0) {
			System.out.println("food의 food2의 값이 같은 값이다.");
		}else if(result2 > 0) {
			System.out.println("food가 food2보다 크다");
		}
			else {
			System.out.println("food2가 food보다 크다.");	
		}
			System.out.println("result2=" + result2);
			
//---------------------------------------------------------------------------------
			//문자 조각만들기
			String tel = "010-1234-5789";
			
			String t[] = tel.split("-"); // split : 내가 원하는 문자로 쪼개기
			System.out.println(Arrays.toString(t));
			
	}
	

}
