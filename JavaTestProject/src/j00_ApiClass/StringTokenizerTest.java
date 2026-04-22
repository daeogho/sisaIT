package j00_ApiClass;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public StringTokenizerTest() {
		// StringTokenizer클래스 문자열을 조각내기 전용클래스
		StringBuffer sb = new StringBuffer("사과/배,,,/귤/바나나.파인애플");
		
		StringTokenizer st = new StringTokenizer(sb.toString(), "/,.");
		
		// 토큰의 갯수
		int cnt = st.countTokens();
		System.out.println("토큰 갯수 : " + cnt);
		
		while(st.hasMoreElements()) { // 토큰이 있으면
			// 꺼내기
			String fruit = st.nextToken();
			System.out.println(fruit);
		}
	}

	public static void main(String[] args) {
		new StringTokenizerTest();

	}

}
