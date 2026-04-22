package J01_basic;

public class Gugudan3Dan {

	public Gugudan3Dan() {
	}

	public void start() {
		System.out.println("\t구구단");

		for (int startDan = 1; startDan <= 9; startDan += 3) { // 1, 4, 7
			// 제목
			for (int title = startDan; title < startDan + 3; title++) {// 1, 4, 7 startDan=1, title= 123 / startDab=4,
																		// title =456
				System.out.print("==" + title + "단==\t");
			}
			System.out.println();

			// 구구단
			for (int i = 2; i <= 9; i++) { // 곱하는 값 -> 2~9
				for (int dan = startDan; dan < startDan + 3; dan++) {// startDan=1, dan=1,2,3 startDan=4, dan=4,5,6
					System.out.print(dan + "*" + i + "=" + multiple(dan, i) + "\t");
				}
				System.out.println();
			}
		}

	}

	public int multiple(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		new Gugudan3Dan().start();

	}

}
