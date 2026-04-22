package J02_array;

public class J38Array {

	public static void main(String[] args) {
		// 2차원 배열 행열이 있는 배열
		
		// 선언하는 방법
		int[][] arr = new int[3][4];
		
		arr[1][2] = 25;
		arr[2][0] = 92;
		
		// 1차원 : arr.length -> 칸수가 구해진다
		// 2차원 : arr.length -> 행수가 구해진다
		// 2차원 : arr[0].length -> 행의 칸수
		for(int row=0; row<arr.length; row++) { //row=0,1,2
			
			for(int col=0; col < arr[row].length; col++) { // col==0,1,2,3
				System.out.print(arr[row][col]+"\t");				
			}	
				System.out.println();		
		} 
		System.out.println("------------------------------");
		// 초기값이 있는 2차원배열	
//==================================================================================
		int[][] arr2 = {{15, 46, 78, 15, 14},
						{52, 16, 6		   },
						{56, 14, 78, 10, 25},
						{5,55,555,5555	   }};
		for(int i=0; i<arr2.length; i++) {// 한번 반복될때마다 i=0,1,2,3(행)
			for(int j =0; j<arr2[i].length;j++) { // j=0,1,....i
				System.out.print(arr2[i][j]+"\t");
			}
				System.out.println();
		}
		System.out.println("-------------------------------");
//==================================================================================
		String color[][] = {
				{"red", "green", "blue"},
				{"빨강", "초록", "파랑"}
				};
		for(int i =0;i<color.length;i++){
			for(int j=0; j<color[i].length; j++) {
				System.out.print(color[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
