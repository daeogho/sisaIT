package j10io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
	}

	public void start() {
		try {
			// 파일의 내용을 읽어 콘솔에 출력하기
			File f = new File("c:/study/javaTest/memo.txt");

			FileReader fr = new FileReader(f);
			System.out.println("=========== 1문자씩 읽어오기==========");
			while (true) {
				int code = fr.read();
				// EOF : -1
				if (code == -1)
					break;
				char codeChar = (char) code;
				System.out.print(codeChar);
			}
			fr.close();

			System.out.println("====== 1줄씩 읽어오기 =======");

			FileReader fr2 = new FileReader(f); // FileReader 클래스 Reader 상속받고 있다.
			BufferedReader br = new BufferedReader(fr2);

			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}
			br.close();
			fr2.close();

			System.out.println("======== 한번에 읽어오기 =========");
			File f2 = new File("C://study/workspaceJAVA/JavaTestProject/src/j09Collection", "Lotto.java");
			FileReader fr3 = new FileReader(f2);

			// 파일을 읽어서 담을 char배열을 파일의 크기만한 사이즈로 만든다.
			char readData[] = new char[(int) f2.length()];

			// 문자수 읽은 문자들
			int cnt = fr3.read(readData, 0, readData.length);

			System.out.println(readData);

		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다...." + fnfe.getMessage());
		} catch (IOException ie) {
			System.out.println("파일읽기 예외 발생...." + ie.getMessage());
		}
	}

	public static void main(String[] args) {
		new FileReaderTest().start();

	}

}
