package j12Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicasteSend {

	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;

	public UnicasteSend() {
	}

	public void sendStart() {
		String txt = "Java Network 유니캐스트 전송 테스트중.";

		try {
			ia = InetAddress.getByName("192.168.4.98");

			ds = new DatagramSocket();
			byte[] code = txt.getBytes();
			dp = new DatagramPacket(code, code.length, ia, 25000);

			ds.send(dp);// 전송
			System.out.println("전송완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new UnicasteSend().sendStart();

	}

}
