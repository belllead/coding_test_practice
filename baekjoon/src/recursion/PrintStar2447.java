package recursion;

import java.util.Scanner;

public class PrintStar2447 {
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new char[N][N];
		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				if (!(r == N/2 && c == N/2))
//					arr[r][c] = '*';
//			}
//		}
		
		printStar(N, 0, 0);
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c] == '\u0000')
					System.out.print(" ");
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		sc.close();
	}
	
	static void printStar(int a, int startR, int startC) {
		if (a == 3) {
			for (int r=startR; r<startR+3; r++) {
				for (int c=startC; c<startC+3; c++) {
					if (!(r == startR + 1 && c == startC + 1))
						arr[r][c] = '*';
				}
			}			
			return;
		}
		
		for (int r=startR; r<startR+a; r+=a/3) {
			for (int c=startC; c<startC+a; c+=a/3) {
				if (!(r == startR + a/3 && c == startC + a/3))
					printStar(a/3, r, c);
			}
		}
	}
}
