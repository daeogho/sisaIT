package j12Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public URLTest() {

	}

	public void start() {

		try {
			// URL클래스를 이용하여 www.nate.com홈페이지의 소스코드 읽어오기
			// 프로토콜 www 도메인
			URL url = new URL("https://www.nate.com");

			// 프로토콜, 호스트명, 포트번호, 파일명
			System.out.println("protocol=>" + url.getProtocol());
			System.out.println("host=>" + url.getHost());
			System.out.println("port=>" + url.getPort());
			System.out.println("file=>" + url.getFile());

			InputStream is = url.openStream(); // byte
			InputStreamReader isr = new InputStreamReader(is);// char
			BufferedReader br = new BufferedReader(isr);
//---------------------------------------------------------------------------------
			File file = new File("c://study/javaTest", "nateSourceCode.html");
			FileWriter fos = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fos); // 파일을 쓰기(구현)
					
			while (true) {
				String code = br.readLine();
				if (code == null) {
					break;
				}
				System.out.println(code);
				bw.write(code+ "\n");

			}
			br.close();
			isr.close();
			is.close();
			bw.close();
			fos.close();

		} catch (

		MalformedURLException mie) {
			System.out.println("url객체 예외 발생...." + mie.getMessage());
		}

		catch (IOException ioe) {
			System.out.println("입력 또는 출력 예외 발생...." + ioe.getMessage());
		}

	}

	public static void main(String[] args) {
		new URLTest().start();

	}

}
