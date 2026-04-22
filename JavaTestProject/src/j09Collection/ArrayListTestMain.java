package j09Collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ArrayListTestMain {

	public ArrayListTestMain() {
		//
		int a = 10;
		Integer aa = a; // 오토박싱
		int b = aa; // 오토언박싱
		
		double cc = 12.6;
		Double d =cc;
		
		ArrayListTest alt = new ArrayListTest();
		ArrayList al = alt.getAllData();
		      // Object
		int getNum = (Integer)al.get(0); // 500
		System.out.println("num=" + getNum);
		
		MemberDTO m1 = (MemberDTO)al.get(1);
		System.out.println(m1.toString());
		
		String name = (String)al.get(2);
		System.out.println("name=" + name);
		
		Calendar date = (Calendar)al.get(3);
		System.out.println("year=" + date.get(Calendar.YEAR));
		
		MemberDTO m2 = (MemberDTO)al.get(4);
		System.out.println(m2.toString());
		
		System.out.println("객체의 수 = " + al.size());
		
		// set() : 해당 위치의 객체를 대체한다.
		al.set(2, new MemberDTO(3, "강감찬", "010-1234-5555", "gang@daum.net", "서울시 영등포구"));	
		System.out.println(al.get(2).toString());
		
		al.remove(3); // 제거하는 것
		al.remove(m2);				
		System.out.println("객체의 수 = "+ al.size());
		System.out.println("====================");
		
		List<MemberDTO> memberList = alt.allMember();
		
		for(int i=0; i < memberList.size(); i++) { // 0,1,2,3,4
		 MemberDTO m = memberList.get(i);
		 System.out.println(m.toString());
		}
	}

	public static void main(String[] args) {
		new ArrayListTestMain();
	}

}
