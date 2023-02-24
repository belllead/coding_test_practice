package study.day0227;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen9663_2 {
	static boolean[][] chess;
	static int N, emptyBlockNum = N*N;
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		chess = new boolean[N][N];
		
		System.out.println(placeQueen(0, 0, 1));
		
				
	}
	
	static int placeQueen(int row, int col, int queenNum) {
		// 이 단계에서 true인 블록 개수
		// 유도파트에서 중복으로 true 처리가 되는 부분 (chess[row][col])
		// 이 있기 때문에 -1에서 시작
		int blockCnt = -1;
		
		int ret = 0;
		
		// 기저조건
		if (queenNum == N+1) {
			System.out.println("success");
			return 0;
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
			
			// 이번 단계에서 판단한 경우의 수
			ret = emptyBlockNum - blockCnt;
			
			emptyBlockNum -= blockCnt;
			
			// queenNum이 끝나기 전에 빈 블록이 바닥나면 불가능 반환
			if (emptyBlockNum < 0) {
				return -1;
			}
			
			// 경우의 수 중복 방지를 위해 오른쪽 아래로만 추가 탐색
			for (int r=row+1; r<N; r++) {
				for (int c=col+1; c<N; c++) {
					if (chess[r][c] == false) {
						int temp = placeQueen(r, c, queenNum+1);
						if (temp == -1) {
							return -1;
						} else {
							ret += temp;
						}
					}
				}
			}
			
			
		}
		
		return ret;		
	}
}
