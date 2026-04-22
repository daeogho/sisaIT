package J01_basic;

public class J02Operator1 {

	public static void main(String[] args) {
		// 연산자 : 산술연산자 -> +, -, *, /, %(나머지)

		int a = 12;
		int b = 4;
		double c = 5.1;

		double result = a + (b - c); // 10.9 ,()먼저 계산한다.
		System.out.println("result=" + result);

		int result2 = a % 5; // 2
		System.out.println("result2=" + result2);
// -------------------------------------------------------------------------------------
		
		// 몫을 구하라.
		int x = 10;
		int y = 3;

		int z = x / y;
		double zz = (double) (x / y);
		System.out.println("z=" + z + "\tzz=" + zz);

		// double result3 = a * 2 + x / y - 10; //17.0
		double result3 = a * (2 + x) / y - 10;
		System.out.println("result3=" + result3);

		String result4 = 10 + (7 + "JDK"); // 17JDK
		System.out.println("result4=" + result4);

		// -----------1증가, 1감소, 2증가, 2감소 등등--------------

		int num = 0;

		num = num + 1;

		num = num + 1; // 대입문 양쪽에 같은 변수의 값이 일정한 값으로 증가하는

		System.out.println("num=" + num);

		num += 1; // num = num+1, num += 2, num = num + 2
		System.out.println("num=" + num);

		num++; // num = num+1, num += 1 과 같다. (단항 연산자)
		System.out.println("num=" + num);

		++num; // num = num+1, num += 1 과 같다. (단항 연산자)
		System.out.println("num=" + num);

		num = num - 1; // num -= 1;
		System.out.println("num=" + num);

		num--;

		--num;
		System.out.println("num-=" + num); // 2

		// 증감 연산자가 다른 식과 함께 연산될때

		int result5 = num++ + 120; // num++가 먼저 계산된 후 num +1 적용
		System.out.println("result5=" + result5 + "\tnum=" + num);

		int result6 = ++num + 50; // ++num가 먼저 계산된 후 + 50 적용
		System.out.println("result6=" + result6 + "\tnum=" + num);

	}

}
