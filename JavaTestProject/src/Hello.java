public class Hello { //클래스명은 파일명이랑 항상 같아야하고, 대문자로 시작한다.
	public static void main(String[] args) {
		System.out.println("이클립스에서 자바 클래스 만들기");
		System.out.println("두번째 줄 출력"); //명령어로 취급하지 않음
		/* 이렇게 하면 
		 * 여기서부터 끝나는 곳 까지
		 * 줄수 제한 없이 적을 수 있다. (주석)
		 * System은 클래스,
		 * out 멤버변수, 필드,
		 * println()은 메소드라 읽는다.
		 */
		
		System.out.println("ctrl + enter 누르면 자동완성");//ln 라인 문단끊기
		System.out.print("A\n");//\n ln과 같은
		System.out.print("B");
	}
}
