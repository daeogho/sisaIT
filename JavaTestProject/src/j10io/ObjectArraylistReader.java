package j10io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectArraylistReader {

	public ObjectArraylistReader() {

	}

	public void start() {
		// C://study/javaTest/MemberObject.txt

		try {
			// File객체
			File file = new File("C://study/javaTest/MemberObject.txt");
			// InputStream객체
			FileInputStream fis = new FileInputStream(file);
			// ObjectInputStream객체
			ObjectInputStream ois = new ObjectInputStream(fis);
			// 읽기
			ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) ois.readObject();
			// 출력
			for (MemberDTO dto : list) {
				System.out.println(dto.toString());

			}

		} catch (FileNotFoundException fnfe) {
			System.out.print("파일이 없어요....." + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.print("파일 읽기 예외 발생....." + ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.print("클래스가 없어요..." + cnfe.getMessage());
		}
	}

	public static void main(String[] args) {
		new ObjectArraylistReader().start();

	}

}
