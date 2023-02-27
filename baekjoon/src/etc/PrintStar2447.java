package etc;

import java.util.Scanner;

public class PrintStar2447 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[][] arr = new char[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (!(r == N/2 && c == N/2))
					arr[r][c] = '*';
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c] == '\u0000')
					System.out.print(" ");
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
	}
	
	static void printStar(int a) {
		for (int r=0; r<a; r+=(a/3)) {
			for (int c=0; c<a; c+=(a/3)) {
				
			}
		}
		
		
	}
}
