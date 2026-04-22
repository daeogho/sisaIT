package J03_oop;

public class Calculator {
	
	//생성자 메소드
	public Calculator() {
		
		}
		// 더하기 만드는 메소드
		public double plus(double num1, double num2) {
			//double result = num1 + num2;
			//return result
			return num1 + num2;
			
		}
		// 메소드 오버로딩 : 메개변수의 갯수 또는 데이터형이 달라야 한다.
		public int plus(int num1, int num2) {
			return num1 + num2;
		}
		// 빼기 만드는 메소드
		public double minus(double num1, double num2) {
			return num1 - num2;
		}
		// 곱하기 구하는 메소드
		public double multiple(double num1, double num2) {
			return num1 * num2;
		}		
		// 나누기 구하는 메소드
		public double divide(double num1, double num2) {
			return num1 / num2;
		}
		// 루트 구하는 메소드
		public double root(double num) {
			return Math.sqrt(num);
		}
		public void AllCalcu(double num1, double num2) {
			//합
			System.out.println(num1 + " + " + num2 + "=" + plus(num1, num2));
			//차
			System.out.println(num1 + " - " + num2 + "=" + minus(num1, num2));
			//곱
			System.out.println(num1 + " * " + num2 + "=" + multiple(num1, num2));
			//나누기
			System.out.println(num1 + " / " + num2 + "=" + divide(num1, num2));
			//루트
		}
		
		// 4개의 계산값을 리턴하는 방법
		// 자바는 1개의 값을 반환할 수 없기 때문에 배열이나 컬렉션에 담아서 하나로 만들어 리턴한다.
		
		public double[] allCalcu2(double num1, double num2) {
			double result[] = new double[4];
			
			// 0 : 합, 1 : 차, 2 : 곱, 3 : 몫
			result[0] = plus(num1, num2);
			result[1] = minus(num1, num2);
			result[2] = multiple(num1, num2);
			result[3] = divide(num1, num2);
			
			return result;
		}
			
		
	

}
