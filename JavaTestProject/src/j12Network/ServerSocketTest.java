package j12Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketTest {
	ArrayList<Socket> chatList = new ArrayList<Socket>();

	public ServerSocketTest() {

	}

	public void serverStart() {
		try {
			// 포트번호는 0~65535번까지 있다.
			ServerSocket ss = new ServerSocket(20000);

			while (true) {
				// 접속대기중
				System.out.println("접속대기중.....");
				Socket s = ss.accept();

				// 서버에 접속한 클라이언트의 정보가 담긴 InetAddress 객체
				InetAddress ia = s.getInetAddress();
				System.out.println("클라이언트 => " + ia.getHostAddress());

				chatList.add(s);

				// 현재 접속자에게 문자 보내기
				OutputStream os = s.getOutputStream();// 1byte
				OutputStreamWriter osw = new OutputStreamWriter(os);// 1문자
				PrintWriter pw = new PrintWriter(osw);

				pw.println("서버에 잘 접속 되었어. 반가워");
				pw.flush();

				// 클라이언트가 서버로 보낸 문자 받기
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String inData = br.readLine();
				System.out.println("클라이언트가 서버로 보낸 문자==>" + inData);
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ServerSocketTest().serverStart();

	}

}
