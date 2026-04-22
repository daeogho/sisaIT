package j04oop;

public class ModifiedTest {
	private int productCode = 1000;
	String name = "세탁기";
	
	ModifiedTest() {
		
	}
	private void output() {
		System.out.println("상품코드=" + productCode);
		System.out.println("상품명=" + name);
	}
	
	//외부클래스에서 캡슐화된 멤버를 접근하는 메소드를 생성해준다.
	// getter
	public int getProductCode(){
		return productCode;
		
	}
	//setter
	public void setProductCode(int productCode){
		this.productCode = productCode;
		
	}
	

}
