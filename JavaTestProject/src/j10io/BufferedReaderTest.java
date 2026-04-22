package j10io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		// BUFFER 임시데이터 저장소 ex) ctrl +c -> Buffer -> ctrel +v -> 
		// 콘솔에서 바이트 -> 문자 -> 버퍼저장후 1줄씩 읽기를 제공한다.
		try {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("입력 =");
		String inData = br.readLine();
		System.out.println(inData);
		}catch(IOException i) {
			i.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new BufferedReaderTest();

	}

}
