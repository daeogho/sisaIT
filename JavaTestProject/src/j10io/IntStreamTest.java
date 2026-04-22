package j10io;

import java.io.IOException;
import java.io.InputStream;

public class IntStreamTest {

	public IntStreamTest() {
		try {
		// InputStream은 추상클래스이므로 바로 객체생성을 할 수 없다.
		// 객체생성을 하여 제공해주는 System클래스의 in변수를 이용한다.
		// Input : 1byte씩 읽기, Reader : 1문자씩 읽기
		// 컴퓨터는 입력하는 모든데이터는 기본 문자로 읽어온다. -> 형변환
		
			InputStream is = System.in;
			
			System.out.print("문자입력=");
//			while(true) {			
//			int inData = is.read(); // 1byte만 읽기 (맨 처음 문자만 읽는다)
//			System.out.println(inData + "->" + (char)inData);
//			}
			byte[] data = new byte[10];
			int size = is.read(data);
			// 읽은 정보는 byte배열인 data변수에 담겨 있고 읽어온 글자수는 size에 있다.
			// 문자로 변환하여 출력
			
			String inData= new String(data);
			System.out.println("inData=>" + inData);
		}catch(IOException io) {
			System.out.println(io.getMessage());
		}
			
		
	}

	public static void main(String[] args) {
		new IntStreamTest();

	}

}
