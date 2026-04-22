package j00_ApiClass;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// String 클래스 : 문자열을 처리하는 클래스
		// StringBuffer, StringBuilder
		
		String name = "홍길동";
		// 홍길동입니다.
		name = name + "입니다.";
		
		System.out.println(name);
		// 0 123456
		// 홍길동입니다.
		// index위치의 문자를 얻어온다.
		char c = name.charAt(2);
		System.out.println("charAt()=>" + c);		
//---------------------------------------------------------------------
		
		// concat() = + : 2개의 문자를 연결
		String msg = "내 이름은 ";
		
		//msg + name
		String result = msg.concat(name);
		System.out.println("concat()=>" + result);
		
		//
		String txt="Java Programing";
		byte txtCode[] = txt.getBytes();
		
		System.out.println( Arrays.toString(txtCode)); // [cvcc,ccc,ccc,ccc,,]
//----------------------------------------------------------------------
		
		// result = "내 이름은 홍길동입니다."
		byte resultCode[] = result.getBytes();
		System.out.println("rusultCode=>" + Arrays.toString(resultCode)); // [455,465,45.....]
		
		String encode = new String(resultCode);
		System.out.println(encode);
		
//----------------------------------------------------------------------
		
		// 문자의 위치를 찾아주는 메소드
		// name = "내이름은 홍길동입니다."
		//         0123 4 5678910       
		int point = result.indexOf("홍");
		System.out.println("indexOf=" + point);

//----------------------------------------------------------------------
		// txt = "Java Programing"
		int idx = txt.indexOf("a"); 
		System.out.println("indexOf=" + idx); // a가 몇번쨰에 있는지 
		
		System.out.println("lastIndesxOf()=" + txt.lastIndexOf("r")); // r이 뒤에서부터 몇번째에 있는지
		
		System.out.println("length()=>result:" + result.length()+", txt:"+txt.length()); // 글자 길이 출력
		
		//replaceAll() : 치환하다
		txt = txt.replaceAll("Java", "자바"); // java -> 자바로 변경
		System.out.println("replaceAll()=>" + txt);
		
//-------------------------------------------------------------------------
		
		//             012 3 456 789
		String addr = "서울시 동대문구 청량리로 1547";
		System.out.println("substring()=>" + addr.substring(4)); // index 3부터 끝까지
		System.out.println("substring()=>" + addr.substring(1, 6)); // index 1부터 6앞까지 나온다.
		
		// 문자열 대소문자 변경하는 기능
		// toLowerCase() -> 소문자로 변경
		// toUpperCase() -> 대문자로 변경
		
		String str = "  Java String    Class Test!!!!   ";
		System.out.println("toLowerCase()=>" + str.toLowerCase()); // 전부 소문자로 변경
		System.out.println("toUpperCase()=>" + str.toUpperCase()); // 전부 대문자로 변경
		
		// trim() : 문자열의 앞부분 뒷부분 공백문자를 제거
		System.out.println("trim()=>" + str.trim()+"--------");
		
		// 1234 + ""; => "1234"
		String n = String.valueOf(1234);
		
		char[] cc = {'A', 'P', 'P', 'L', 'E'}; //문자열 ==> APPLE
		String food = String.valueOf(cc);
		System.out.println("ValueOf()=>" + food);
	}

}
