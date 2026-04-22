package j10io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import j09Collection.MemberDTO;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {

	}

	public void startObjectRead() {
		try {
			// object.txt 파일에 저장되어 있는 dto객체를 가져오기
			File file = new File("c:/study/javaTest", "object.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			MemberDTO dto = (MemberDTO)obj; // 형변환 = TypeCasting
			
			System.out.println(dto.toString());

		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않아요......." + fnfe.getMessage());
		} catch(IOException ie) {
			System.out.println("파일 입력 예외발생..." + ie.getMessage());
		} catch(ClassNotFoundException cnfe) {
			System.out.println("객체가 존재하지 않는다." + cnfe.getMessage());
		}

	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}
