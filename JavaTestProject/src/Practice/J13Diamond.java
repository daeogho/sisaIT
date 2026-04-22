package Practice;

import java.util.Scanner;

public class J13Diamond {
	public J13Diamond() {}
		public void start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("임의의 홀수입력(1~49)=");
		int num = scan.nextInt();
		
		char i = 65;					
				for(int index = 1; index<= num; index+=2) {  // i =5
					for(int k=1; k<=(num-index)/2; k++) {
						System.out.print(" ");
					}
					for(int j=1; j<=index; j++) { 
						System.out.printf("%s", i++);
						if(i>90) {
							i=65;
						}
						
					}	
					System.out.println();			
				} 
				
				for(int index =1; index <=num; index+=2) {
					for(int j=num; j<=index/2+num; j++) {
						System.out.print(" ");
					}
					for(int k=num-2; k>=index; k--) {
						System.out.printf("%s", i++);
						if(i>90) {
							i=65;
						}
					}
					System.out.println();
		
					
		}
		
	}

	public static void main(String[] args) {
		J13Diamond dia = new J13Diamond();
		dia.start();

	}

}
