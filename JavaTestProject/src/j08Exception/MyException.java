package j08Exception;

public class MyException extends Exception{
	//예외 클래스를 생성할 때는 무조건 Exception 클래스를 상속받아 만든다.
	public MyException() { // new MyException()
		super("1~100까지의 정수가 아닙니다.");
	}
	public MyException(String message) { // new MyException("예외메시지")
		super(message);
	}
	
}
