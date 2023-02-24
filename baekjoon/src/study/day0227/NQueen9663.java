package study.day0227;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen9663 {
	static boolean[][] chess;
	static int N;
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		chess = new boolean[N][N];
		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				System.out.printf("%5s ", chess[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
//		placeQueen(0, 0, 1);
//		
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				System.out.printf("%8s ", chess[r][c]);
//			}
//			System.out.println();
//		}
//		
//		int sum = 0;
//		for (int r=0; r<N; r++) {
//			for (int c=0; c<N; c++) {
//				sum += placeQueen(r, c, N*N);
//			}
//		}
//		
//		System.out.println(sum);
		
		int sum = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				placeQueen(r, c, N*N, N);
			}
		}
		
		System.out.println(sum);
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				System.out.printf("%8s ", chess[r][c]);
			}
			System.out.println();
		}
		
				
	}
	
	static int placeQueen(int row, int col, int emptyBlock, int queenNum) {
		// 이 단계에서 놓을 수 있는 퀸 경우의 수
		int emptyCnt = 0;
		
		// 이 단계에서 true인 블록 개수
		// 유도파트에서 중복으로 true 처리가 되는 부분 (chess[row][col])
		// 이 있기 때문에 -1에서 시작
		int blockCnt = -1;
		
		// 기저조건
		if (emptyBlock == 0) {
			if (queenNum > 0) {
				System.out.println("fail");
				return -1;
			} else {
				System.out.println("success");
				return 0;
			}
		}
		
		// 유도 파트
		else {
			
			// 가로 처리
			for (int r=0; r<N; r++) {
				chess[r][col] = true;
				blockCnt++;
			}
			
			// 세로 처리
			for (int c=0; c<N; c++) {
				chess[row][c] = true;
				blockCnt++;
			}
			
			// 대각선 처리
			for (int i=0; i<4; i++) {
				for (int j=1; j<N; j++) {
					int tr = row + dr[i] * j;
					int tc = col + dc[i] * j;
					if (tr >= 0 && tr < N && tc >= 0 && tc < N) {
						chess[tr][tc] = true;
						blockCnt++;
					}
				}
			}	
			
			emptyCnt = N * N - blockCnt;
			
			// 오른쪽 아래로 가서 처리해본 결과
			for (int r=row+1; r<N; r++) {
				for (int c=col+1; c<N; c++) {
					if (chess[r][c] == false) {
						int t = placeQueen(r, c, emptyCnt, queenNum-1);
						if (t == -1) {
							return -1;
						} else {
							emptyCnt += t;
						}
					}
				}
			}
			
			
			
		}
		
		return emptyCnt;		
	}
}
