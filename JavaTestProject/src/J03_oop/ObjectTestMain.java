package J03_oop;

public class ObjectTestMain {

	public static void main(String[] args) {
		
		ObjectTest obj = new ObjectTest();
		ObjectTest tst = new ObjectTest();
		// ObjectTest클래스의 멤버변수 접근하는 방법
		// 객체명.멤버변수
		System.out.println("obj.name=>" + obj.name);
		System.out.println("오늘날짜 : "+ obj.now);
//------------------------------------------------------------------
		
		// 객체내의 멤버변수의 값을 변경
		// 객체명.멤버변수 = 값
		obj.num = 100;
		System.out.println("obj.num=>"+obj.num +", tst.num=>" + tst.num);
		
		// 메개변수가 있는 생성지로 객체생성하기
		ObjectTest ot1 = new ObjectTest(2000);
		System.out.println("ot1.num=>" + ot1.num);
		
		ObjectTest ot2 = new ObjectTest("강감찬");
		System.out.println("ot2.num=>" + ot2.num +",ot2.name=>" + ot2.name);
		
		ObjectTest ot3 = new ObjectTest(1234, "정영실");
		System.out.println("ot3.num=>" + ot3.num + ", ot3.name=>" + ot3.name);
	
//----------------------------------------------------------------------------
		
		String str = new String(); //
		byte arr[] = {65,66,67,68}; 
		String str2 = new String(arr); // 'ABCD'
		
		char arr2[] = {'T', 'E', 'S', 'T'}; // 'TEST'
		String str3 = new String(arr2);
		
		String str4 = new String("생성자Test중..."); //""
		
		//             A  B  C  D  E  F  G  H 
		byte arr4[] = {65,66,67,68,69,70,71,72}; // 'CDEF'
		String str5 = new String(arr4,2,4); // 
		
		System.out.println("str =>" + str);
		System.out.println("str2 =>" + str2);
		System.out.println("str3 =>" + str3);
		System.out.println("str4 =>" + str4);
		System.out.println("str5 =>" + str5);
		
		// 메소드 호출
		// 객체명.메소드명()
		ot3.add(25,35);
		
		int r = tst.minus(56,10);
		System.out.println("r=" + r);
		
	}

}
