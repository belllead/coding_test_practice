package study.day0306;

import java.util.Scanner;

public class NQueen9663_3 {
	static int N, sum;
	static byte[][] chess;	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new byte[N][N];
		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				System.out.print(chess[r][c]);
//			}
//			System.out.println();
//		}
		
		placeQueen(0);
		System.out.println(sum);
		sc.close();
	}
	
	static void placeQueen(int col) {
		if (col == N) {
			sum++;
			return;
		}
			
		for (int r=0; r<N; r++) {
			if (isSafe(r, col)) {
				chess[r][col] = 1;
								
				placeQueen(col+1);
				
//				for (int rr=0; rr<N; rr++) {
//					for (int c=0; c<N; c++) {
//						System.out.print(chess[rr][c]);
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				chess[r][col] = 0;
			}
			
		}
	}
	
	static boolean isSafe(int row, int col) {
		int[] dr = {-1, 0, 1};
		int dc = -1;
		
		for (int r=0; r<N; r++) {
			for (int c=1; c<=col; c++) {
				for (int i=0; i<3; i++) {
					int tr = row + dr[i] * c; 
					int tc = col + dc * c;
					if (tr < N && tr >= 0 && tc >= 0) {
						if (chess[tr][tc] == 1) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
}
