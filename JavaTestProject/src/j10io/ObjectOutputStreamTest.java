package j10io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
	}

	public void start() {
		try {
			// 객체를 파일로 기록하기
			File file = new File("c:/study/javaTest/MemberObject.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			MemberDTO dto = new MemberDTO();
			dto.setNum(1234);
			dto.setName("김길리");
			dto.setTel("010-7899-7878");
			dto.setEmail("kim@nate.com");
			dto.setAddr("서울시 서대문구");
			System.out.println(dto.toString());

			oos.writeObject(dto);

			oos.close();
			System.out.println("객체쓰기 완료....");

		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 없습니다..." + fnfe.getMessage());
		} catch (IOException ie) {
			System.out.println("입출력 예외가 발생하였습니다... " + ie.getMessage());
		}
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest().start();

	}

}
