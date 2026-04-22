package j12Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		
	}
	public void start() {
		// 현재 컴퓨터의 ip를 이용하여 객체만들기
		try {
		InetAddress ia1 = InetAddress.getLocalHost();
		System.out.println("ia1.address=>" + ia1.getHostAddress()); // ip
		System.out.println("ia1.name=>" + ia1.getHostName()); // 컴퓨터이름, url = 도메인
		
		// 도메인을 이용하여 InetAddress객체 만들기
		InetAddress ia2 = InetAddress.getByName("www.nate.com");
		System.out.println("ia2.address=>" + ia2.getHostAddress());
		System.out.println("ia2.name=>" + ia2.getHostName());
		
		// ip를 이용하여 InetAddress객체 만들기
		InetAddress ia3 =InetAddress.getByName("120.50.131.112");
		System.out.println("ia3.address=>" + ia3.getHostAddress());
		System.out.println("ia3.name=>" + ia3.getHostName());
		
		System.out.println("-----------------------------------------");
		// ip가 여러개일때 InetAddress객체 생성
		InetAddress[] ia4 =InetAddress.getAllByName("www.naver.com");
		for(InetAddress ia : ia4) {
			System.out.println("naver.address=>" + ia.getHostAddress());
			System.out.println("naver.address=>" + ia.getHostName());
		}
		
		}catch(UnknownHostException uhe) {
			System.out.println("통신 예외 발생...." + uhe.getMessage());
		}
	}

	public static void main(String[] args) {
		new InetAddressTest().start();

	}

}
