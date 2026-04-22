package j12Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UnicasteReceive {

	DatagramSocket ds;
	DatagramPacket dp;

	public UnicasteReceive() {

	}

	public void receiveStart() {
		try {
			ds = new DatagramSocket(25000);

			// 유니캐스트는 데이터를 DatagramPacket객체 담아서 전송하므로
			// 받을때도 DatagramPacket으로 받아야 한다.
			// 512byte
			byte data[] = new byte[1024];
			dp = new DatagramPacket(data, data.length);
			System.out.println("받기 대기중.......");
			ds.receive(dp); // 대기중

			///////////////////////////////////////////////////////

			// 전송받은 데이터 출력
			byte receiveData[] = dp.getData();
			System.out.println(new String(receiveData, 0, dp.getLength()));

		} catch (SocketException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive().receiveStart();

	}

}
