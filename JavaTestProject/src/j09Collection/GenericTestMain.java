package j09Collection;

import java.util.Calendar;

public class GenericTestMain {

	public GenericTestMain() {
		// GenericTest는 제너력기능이 있는 클래스이다.
		// data멤버변수는 다양한 객체를 담을 수 있는 변수가 되고
		// 만약에 Generic을 성정하지 않으면 Object타입에 담긴다.
		
		MemberDTO member = new MemberDTO(100, "hong", "010-1111-1111");
		
		GenericTest gt = new GenericTest();
		gt.setData(member);
		
		MemberDTO dto = (MemberDTO)gt.getData();
		
		System.out.println(dto.toString());
		
		Calendar now = Calendar.getInstance();
		
		GenericTest<Calendar> gt2 = new GenericTest<Calendar>();
		gt2.setData(now);
		
		System.out.print(gt2.getData());
		
	}

	public static void main(String[] args) {
		new GenericTestMain();

	}

}
