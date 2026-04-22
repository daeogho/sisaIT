package j04oop;

import J03_oop.Calculator;

public class ModifiedMain {

	public static void main(String[] args) {
		// public, default, private
		Calculator cc = new Calculator();
		cc.AllCalcu(12, 3);
		
		// 생성자 메소드 private 다른 클래스에서 객체를 생성할 수 없다.
		ModifiedTest mt = new ModifiedTest();
		
		// System.out.println("mt.productCode=" + mt.productCode);
		System.out.println("mt.name=" + mt.name);
		
		//메소드 호출
		//mt.output(); 
		int code = mt.getProductCode();
		
		mt.setProductCode(3000);
		
		int code2 = mt.getProductCode();
		System.out.print(code + "," +code2);

	}

}
