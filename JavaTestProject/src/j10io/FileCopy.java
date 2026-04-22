package j10io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public FileCopy() {
		
	}
	public void start() {
		// C:\study\img\image1.gif --> C:\study\java Test\image1.gif
				// FileInputStream         --> FileoutputStream
				try {
					//원본파일객체
					File org = new File("C:/study/img/냥이.gif");
					//타겟파일객체
					File tar = new File("C:/study/javaTest/blackShoes.gif");
					
					
					//읽기
					FileInputStream fis = new FileInputStream(org);
					//쓰기
					FileOutputStream fos = new FileOutputStream(tar);
					
					while(true) {
						int read = fis.read(); // 1byte읽기
						if (read == -1) break;
						fos.write(read);
					}
					fos.close();
					fis.close();
					System.out.println("파일 복사완료....");
				}catch(FileNotFoundException fnfe){
					System.out.println("파일이 존재하지 않습니다.");
				}catch(IOException ie) {
					System.out.println("입출력 예외 발생함....."+ ie.getMessage());
				}
	}

	public static void main(String[] args) {
		new FileCopy().start();

	}

}
