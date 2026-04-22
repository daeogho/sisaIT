package j07InnerClass;

public class MethodInnerClass {
	int num = 20;
	String email = "abcd@gamil.com";
	public MethodInnerClass() {	}
	
	public void memberOutput() {
		System.out.println("번호=" + num + ", 이메일=" + email);
	}
	public void createMemberInner() {
		// 내부 클래스 - 메소드내에 정의하는 내부클래스
		//            메소드 호출시에만 사용이 가능하다.
	
		class Member{
			int num = 200;
			String name = "안중근";
			Member(){}
			Member(int num, String name){
				this.num = num;
				this.name = name;
			}
			void memberPrint() {
				System.out.println("num=" + num + ", name=" + name + ", email=" + email);
			}
			
		}
		
		// 메소드에 정의한 내부 클래스는 메소드내에서만 사용이 가능하고, 객체도 생성하여 사용하여야 한다.
		Member member = new Member(50, "강감찬");
		member.memberPrint();
		
	}
	
//==============================================================================
	
	public static void main(String[] args) {
		MethodInnerClass mic = new MethodInnerClass();
		mic.memberOutput();
		mic.createMemberInner();

	}

}
