package j10io;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
			// 문자단위로 읽어오기
			InputStreamReader isr = new InputStreamReader(System.in);
			while (true) {
				int inData = isr.read();

				System.out.println(inData + "=>" + (char) inData);
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
