package j09Collection;

import java.util.Random;
import java.util.Stack;

public class StackTest {

	public StackTest() {
		// Stack은 한쪽으로 입력과 출력을 할 수 있다.
		// 먼저 입력된 객체가 마지막에 출력된다. FILO = LIFO
		
		Random ran = new Random();
		
		Stack<Integer> stk = new Stack<Integer>();
		
		for(int i = 1; i <=10; i++) {
			int r = ran.nextInt(100) + 1;
			stk.push(r);
			System.out.println(r);
		}
		System.out.println("------------------------");
		
		while(!stk.empty()) {// true: 비어있다. false : 객체가 있다.
			System.out.println(stk.pop());
		}
		
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
