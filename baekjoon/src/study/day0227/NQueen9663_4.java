package study.day0227;

import java.util.Scanner;

public class NQueen9663_4 {
	static int N, sum;
	static byte[][] chess;	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new byte[N][N];
		
		placeQueen(0);
		System.out.println(sum);
		sc.close();
	}
	
	static void placeQueen(int col) {
		// 체스판 끝까지 채워지면 경우의 수 카운트
		if (col == N) {
			sum++;
			return;
		}
		
		// 가장 왼쪽 줄에 퀸 놓기 가능한 자리 검증하고
		// 해당 칸에 퀸 놓고 오른쪽 체스판 마저 처리
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
				
				// 해당 칸의 모든 경우의 수를 보고 나면 
				// 초기화하고 다음 칸으로 넘어가서 검사
				chess[r][col] = 0;
			}
			
		}
	}
	
	static boolean isSafe(int row, int col) {
		// 가로 검사
		for (int c=0; c<col; c++) {
			if (chess[row][c] == 1) {
				return false;
			}
		}
		
		// 대각선 검사
		for (int r=0; r<N; r++) {
			for (int c=0; c<col; c++) {
				if (Math.abs(r - row) == Math.abs(c - col)) {
					if (chess[r][c] == 1)
						return false;
				}
			}
		}
		return true;
	}
	
}
