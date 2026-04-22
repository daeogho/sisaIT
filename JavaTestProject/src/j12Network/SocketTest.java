package j12Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class SocketTest {

	public SocketTest() {

	}

	public void clientStart() {
		try {
			// 서버의 ip를 이용한 InetAddress객체가 필요하다.
			InetAddress ia = InetAddress.getByName("192.168.4.98");

			// Socket객체를 생성하면 InetAddress의 ip컴퓨터의 20000번으로 서버에 접속한다.
			Socket s = new Socket(ia, 20000);
			System.out.println("서버에 접속하였습니다.");

			// 서버에서 보낸 문자 받기
			// InputStream

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String inData = br.readLine();// 서버에서 보낸문자을 입력받기
			System.out.println("클라이언트가 받은 문자 : " + inData);

			// 클라이언트가 서버로 문자 보내기
			// OutputStream
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			pw.println("클라이언트가 서버로 문자를 보냅니다.....");
			pw.flush();

		} catch (java.net.UnknownHostException uhek) {
			uhek.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SocketTest().clientStart();
	}

}
