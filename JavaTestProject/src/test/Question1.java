package test;

import java.util.Arrays;
import java.util.Random;

public class Question1 {

	public Question1() {
		Random random = new Random();

		int data[] = new int[10];

		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100) + 1;

		}
		String dataString = Arrays.toString(data);
		System.out.print("\t=========정렬전=========\n");
		System.out.print(Arrays.toString(data) + "\n");

		Arrays.sort(data);
		System.out.print("\t=========정렬후=========\n");
		System.out.print(Arrays.toString(data));

	}

	public static void main(String[] args) {
		new Question1();

	}

}
