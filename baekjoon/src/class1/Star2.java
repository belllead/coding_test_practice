package class1;

import java.util.Scanner;

public class Star2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] arr = new String[N][N];
		
		for (int r=0; r<N; r++) {
			for (int c=N-1; c>N-r-2; c--) {
				arr[r][c] = "*";
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c] == null)
					System.out.print(" ");
				if (arr[r][c] != null)
					System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
	}
}
