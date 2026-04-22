package j10io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectArrayListWrite {

	public ObjectArrayListWrite() {

	}

	public void start() {
		// 데이터
		ArrayList<MemberDTO> al = new ArrayList<MemberDTO>();

		al.add(new MemberDTO(1111, "홍길동", "010-8989-4758", "hong@naver.com", "종로구"));
		al.add(new MemberDTO(2222, "이순신", "010-7777-4456", "sunsin@nate.com", "중구"));
		al.add(new MemberDTO(3333, "최민정", "010-6666-4758", "choi@daum.net", "영등포구"));
		al.add(new MemberDTO(4444, "임종언", "010-3443-8787", "jong@gmail.com", "노원구"));
		al.add(new MemberDTO(5555, "김길리", "010-2222-9999", "gilli@nate.com", "송파구"));

		try {
			File file = new File("c:/study/javaTest/MemberObject.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(al);

			System.out.println("컬렉션에 담긴 MemberDTO를 파일로 쓰기완료");
			oos.close();
			fos.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 없습니다...." + fnfe.getMessage());
		} catch (IOException ie) {
			System.out.println("출력 예외 발생함....." + ie.getMessage());
		}

	}

	public static void main(String[] args) {
		new ObjectArrayListWrite().start();

	}

}
