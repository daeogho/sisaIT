package j09Collection;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {
	public Lotto() {
	}

	public void start() {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		do {
			System.out.print("게임수 = ");
			int game = scan.nextInt(); // 게임수 만큼 반복하여 로또게임을 생성한다.

			for (int i = 1; i <= game; i++) {
				TreeSet<Integer> lotto = new TreeSet();// 1게임을 담을 컬렉션 = TreeSet 역할 중복제거 및 정렬
				int lastNum = 0; // 마지막에 만든 번호

				while (lotto.size() < 7) { // 로또 번호 + 보너스번호 = 7
					lastNum = ran.nextInt(45) + 1;// 번호 생성
					lotto.add(lastNum);// TreeSet에 담기  lastNum를 랜덤으로 돌려서 lotto로 넣는 과정
				}
				// 중복검사, 정렬되어 있다.
				// 보너스 번호를 TreeSet에서 제거한다.
				lotto.remove(lastNum);

				System.out.print(i + "게임=");
				System.out.print(Arrays.toString(lotto.toArray()));
				System.out.println(", bonus=" + lastNum);

			}

			System.out.print("계속하시겠습니까(1. 예, 2. 아니오)?");
			int conti = scan.nextInt();
			if (conti == 2) {
				break;

			}
		} while (true);

	}

	public static void main(String[] args) {
		new Lotto().start();

	}

}
