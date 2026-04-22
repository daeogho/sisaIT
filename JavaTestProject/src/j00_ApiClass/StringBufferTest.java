package j00_ApiClass;

public class StringBufferTest {

	public StringBufferTest() {
		// 문자열을 저장할 변수 선언
		// 데이터가 변경되더라도 현재 위치를 유지한다. 공간이 모자라면 크기가 자동 확장된다.
		StringBuffer sb = new StringBuffer(); // 16글자를 저장할 공간 확보
		StringBuffer sb2 = new StringBuffer(50); // 50글자를 저장할 공간 확보
		StringBuffer sb3 = new StringBuffer("자바 공부중"); //초기값을 가진다.
		
		// append -> 추가 : 제일 마지막에 추가한다.
		sb3.append(10);	// a = a+ "10"; a.concat(10)
		sb3.append("api 객체 테스트 중.");		
		System.out.println(sb3.toString()); // toString은 
		System.out.println("size =" + sb3.capacity());
		System.out.println("charAt()=>" + sb3.charAt(3));
		// 0 123 45 678 
		// 자바 공부중 10api 객체 테스트 중.
		sb3.delete(2, 6);
		System.out.println("delete=" + sb3.toString());
		// 자바10api 객체 테스트 중.
		// insert(int offset, String str)
		// insert(int index, char[] str, int offset, int len)
		sb3.insert(4,  "insert문으로 추가한 글");
		System.out.println("insert =>" + sb3.toString());
		
		char[] arr = {'T', 'E', 'S', 'T', 'I', 'N'};
		// 01 2345678910
		// 자바 10insert문으로 추가한 글api 객체 테스트 중.
		sb3.insert(10, arr, 2, 3);
		System.out.println("insert=>" + sb3.toString());	
		
		// 자바 10insert문으로 추가한 글api 객체 테스트 중.
		sb3.reverse();
		System.out.println("reberse =>" + sb3.toString());
	}
	public static void main(String[] args) {
		new StringBufferTest();
	}

}
