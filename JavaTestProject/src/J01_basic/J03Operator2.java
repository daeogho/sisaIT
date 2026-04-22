package J01_basic;

public class J03Operator2 {

	public static void main(String[] args) {
		// 비교연산자, 관계연산자 : >, <, <=, >=, ==, !=

		int data = 72;
		// data의 값이 60이상이면 pass, 60미만 fail을 처리해야한다.

		boolean result = data >= 60;
		System.out.println("result=" + result); // : ->클론, ; ->세미클론

		// 삼항 연산자 : (조건식) ? 수식 or 값 : 수식 or 값

		String result2 = (data >= 60) ? "pass" : "fail";
		System.out.println("result2=" + result2);

		// 급여가 2500불인 사원에게 보너스를 지급한다.
		// 급여가 2000불 이상이면 보너스를 5% 지급
		// 급여가 2000불 미만이면 보너스를 10% 지급
		// 보너스가 얼마인지 구하라.

		int salary = 1800;
		double bonus = (salary >= 2000) ? salary * 0.05 : salary * 0.1;

		System.out.println("급여=" + salary + ",보너스=" + (int) bonus);

		// 어떤 수 -> 짝수 인지 홀수 인지 출력하라
		int num = 123;
		int num2 = num % 2;
		System.out.println(num2);

		String A = (num2 < 1) ? "짝수" : "홀수";
		System.out.println("A=" + A + "다");

		// num/2 n/2.0
		// 10 5 5.0
		// 7 3 3.5

		String result4 = (num / 2 == num / 2.0) ? "짝수" : "홀수";
		System.out.println("result4=" + result4);

		// 어떤수를 가지고 양수, 음수, 0인지 구별하라.
		// ....., -2, -1, 0, 1, 2, 3.....
		int su = -454;
		String result5 = (su > 0) ? "양수" : (su == 0) ? "0" : "음수";
		System.out.println("result5=" + result5);

		// 어떤학생이 시험을 봤는데 국어, 영어시험을 봤는데
		// 통과하려면 국어도 60점, 영어도 60점 이상이여야한다.

		int kor = 60, eng = 60;
		boolean grade = kor >= 60 && eng >= 60;

		System.out.println("grade=" + grade);

		// 어떤학생이 시험을 봤는데 국어, 영어시험을 봤는데
		// 통과하려면 국어나 영어 중 하나만 60점 이상이면 통과

		int kor2 = 54, eng2 = 10;
		boolean grade2 = kor2 >= 60 || eng2 >= 60;
		String AA = (grade2 == true) ? "통과" : "실패";

		System.out.println("합격여부=" + AA);

		// true이면 통과, false이면 실패

	}

}
