package j09Collection;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// Properties 클래스 key와 value가 모두 String인 컬렉션이다.
		
		Properties prop = new Properties();
		prop.setProperty("/", "index.html");
		prop.setProperty("/board/list", "notice/viewList.html");
		prop.setProperty("/member", "register/form.html");
		prop.setProperty("/notice", "news/board.html");
		
		
		// 1개의 value을 얻어오기
		String url = prop.getProperty("/notice");
		System.out.println(url);
		
		// 모든 key구하기
		Enumeration key = prop.propertyNames();
		
		while(key.hasMoreElements()) {
			String value = prop.getProperty((String)key.nextElement());
			System.out.println(value);
				
		}
		
		
		
	}

	public static void main(String[] args) {
		new PropertiesTest();
		
		

	}

}
