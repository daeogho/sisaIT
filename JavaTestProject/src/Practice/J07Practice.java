package Practice;

public class J07Practice {

	public static void main(String[] args) {
		for(int i =1; i <=5; i++) { // 1,2,3,4,5
			for(int j = 1; j <=5-i; j++) { // 1234,123,12,1
				System.out.print(" ");
			}for(int k = 1; k<=i; k+=2) {//5,456,34567,
				System.out.print("*");					
					
			}System.out.println();
			
		} 
		

	}

}
