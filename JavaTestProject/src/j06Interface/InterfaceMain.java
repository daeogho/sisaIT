package j06Interface;

// 클래스에서 interface를 상속 받을 때는 implements로 기술하고
// 여러개의 interface를 상속 받을 수 있다.
// 상속받은 모든 추상메소드는 오버라이딩
public class InterfaceMain implements InterfaceTest, InterfaceA, InterfaceB{

	public InterfaceMain() {
		// Interface는 주상메소드와 static final 변수만 있는 클래스
		minus(50,30);
	}
	// 추상메소드 오버라이딩
	public void plus(int n1, int n2) {
		System.out.println("n1+n2="+ (n1+n2));
	}
	public void minus(int n1, int n2) {
		System.out.println("n1-n2=" + (n1-n2));
	}
	
	@Override
	public void divide() {		
	}
	@Override
	public void multiple(int a, int b) {
		System.out.println("a*b=" + a*b);
	}	
	@Override
		public void sqrt(double a) {	
		System.out.println("sqrt("+a+")=" + Math.sqrt(a));	
	}
	
//------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		InterfaceMain im = new InterfaceMain();
		im.plus(10, 50);
		im.sqrt(50);
		im.multiple(3, im.MAX);
		im.multiple(4, InterfaceTest.MAX);
		
		//클래스로 객체를 만들어 상위 인터페이스 대입가능
		InterfaceTest t = new InterfaceMain();
		InterfaceA a = new InterfaceMain(); //multiple()
		InterfaceB b = new InterfaceMain();
		
		t.multiple(45,67);
		t.sqrt(10);
		//t.divide();
		a.divide();
		
		InterfaceMain main = (InterfaceMain)a; // multiple(), plus(), minus(), divide(0, static변수
		main.plus(50, 40);
		
		InterfaceMain im2 = new InterfaceMain();
		
		if(im == im2) {
			System.out.println("im과 im2는 같다.");
		}else {
			System.out.println("im과 im2는 다르다.");
		}
		
		InterfaceMain im3 = im;
		if(im == im3) {
			System.out.println("im과 im3는 같다.");
		}else {
			System.out.println("im과 im3는 다르다");
		}
		
		if(im.equals(im2)) {
			System.out.println("im과 im2는 같다.");
		}else {
			System.out.println("im과 im2는 다르다.");
		
		}
		
		// instanceof => 객체를 어떤 클래스로 만들었는지 확인
		// im2객체는 InterfaceMain클래스로 생성된 것이 맞는지 알아보기
		// 객체명               클래스명
		if( im2 instanceof InterfaceMain) {
			System.out.println("InterfaceMain으로 생성된 클래스가 맞다.");
		}else {
			System.out.println("InterfaceMain으로 생성된 클래스가 아니다.");
		
		}
	}
	

}
