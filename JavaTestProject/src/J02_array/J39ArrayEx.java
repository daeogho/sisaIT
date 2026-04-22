package J02_array;

public class J39ArrayEx {

	public static void main(String[] args) {
		//

		String bingo[][] = new String[5][5]; // 55칸 배열

		// o,x 를 배열 채우기
		// i = j
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if (i == j || i + j == 4) {
					bingo[i][j] = "x";
				} else
					bingo[i][j] = "o";
				System.out.print(bingo[i][j]);
			}
			System.out.println();
		}
//---------------------------------------------------------------

		for (int row = 0; row < bingo.length; row++) {
			for (int col = 0; col < bingo[row].length; col++) {
				System.out.print(bingo[row][col] + "\t");
			}
			System.out.println();

		}

	}

}
