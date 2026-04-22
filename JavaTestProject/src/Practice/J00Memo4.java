package Practice;

import java.util.Random;


public class J00Memo4 {

	public J00Memo4() {

		Random random = new Random();

		int data[] = new int[101];

		for (int i = 0; i < 1000; i++) {
			int ran = random.nextInt(100) + 1;

			data[ran]++;
		}

		
		int max = 1;
		for (int i = 2; i < data.length; i++) {
			if (data[max] <= data[i]) {
				max = i;
			}

			
		}
		for (int i = 1; i < data.length; i++) {
			System.out.println("data[" + i + "]=" + data[i]);
		}
		System.out.print("최빈수 =" + max);
	}

	public static void main(String[] args) {
		new J00Memo4();

	}

}
