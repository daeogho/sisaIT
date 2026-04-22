package j09Collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public TreeSetTest() {
		// 숫자
		int data[] = {43,564,768,98,434,8678,43,765,54,54,54,76,87,43};
		// 중복데이터 제거, 정렬, 저장순서 유지하지 않음
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int d : data ) {
		    ts.add(d);
		}
		
		//오름차순
		Iterator<Integer> iiAsc = ts.iterator();
		System.out.print("오름차순=");
		while(iiAsc.hasNext()) {
		   Integer i = iiAsc.next();
		   System.out.print(i+",");
		}
		System.out.println();
		
		//내림차순으로 얻어오기
		Iterator<Integer> iiDesc = ts.descendingIterator();
		System.out.print("내림차순=");
		while(iiDesc.hasNext()) {
			Integer i = iiDesc.next();
			System.out.print(i+",");
		}
		System.out.println();
		
//----------------------------------------------------------------------------------------------------------------------------
		String[] flawer = {"장미","코스모스","코스모스","패랭이","개나리","진달래","개나리","접시꽃","금냥화","패랭이","튤립"};
		
		//TreeSet에 flower의 내용 추가하기
		TreeSet<String> ts2 = new TreeSet<String>();
		for(String s : flawer) {
			ts2.add(s);
		}
		// 중복제거,정렬
		// 오름차순
        Iterator<String> sAsc = ts2.iterator();		
        System.out.print("문자 오름차순=");
		while(sAsc.hasNext()) {
			String ss = sAsc.next();
			System.out.print(ss+",");
		}
		System.out.println();
		
		// 내림차순
		Iterator<String> sAsc2 = ts2.descendingIterator();//내림차순정렬
		System.out.print("내림차순=");
		while(sAsc2.hasNext()) {
			String sss = sAsc2.next();
			System.out.print(sss+",");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		new TreeSetTest();

	}

}


