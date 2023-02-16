package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BreakBrick3 {
	static int T, N, W, H, initialBrickCnt, maxBreak;
	static int[][] brickMap, brickMapTest;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			brickMap = new int[H][W];
			brickMapTest = new int[H][W];
			initialBrickCnt = 0;
			
			for (int r=0; r<H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<W; c++) {
					brickMap[r][c] = Integer.parseInt(st.nextToken());
					// 처음 벽돌의 개수
					if (brickMap[r][c] != 0)
						initialBrickCnt++;
				}
			}
						
			sb.append("#" + tc + " ");
			
			maxBreak = breakBrickRoutine(brickMap, 1);
			
			sb.append(initialBrickCnt - maxBreak);
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int breakBrickRoutine(int[][] brickMap, int shotNum) {
		// 주어진 배열의 모든 열에 대해 각각 벽돌깨기를 진행한다.
		// 각 구슬의 단계에서 최대로 부순값을 반환해
		// 이전 단계의 테스트 결과에 더해준다.
		
		// 결과적으로 각 열에서 시작할 때 N번의 구슬을 사용할 때까지
		// 가장 많이 벽돌을 깬 값이 반환된다.
		
		// 단계가 진행할 수록 배열의 개수가 W개 만큼 복사된다.
		int[][][] columnTest = copyBrickMap(brickMap);
		int[] testResult = new int[W];
		int max = 0;
		
		// 복사한 각 배열에서 열 별로 벽돌깨기를 진행하고
		// 그 중 가장 많이 깨진 벽돌 개수를 저장한다.
		for (int i=0; i<W; i++) {
			testResult[i] = breakTest(columnTest[i], i);
			organizeMap(columnTest[i]);
			max = Math.max(max, testResult[i]);
		}
		
		if (shotNum == N) {
			// 구슬 매개변수가 N이면 재귀를 종료한다.
			return max;
		} else {
			// 구슬 매개변수가 N이 아니면 N+1번째 구슬에 대해 재귀함수를 호출한다.
			// 다음 단계의 결과값은 이번 단계의 테스트 결과에 더해진다.
			for (int i=0; i<W; i++) {
				testResult[i] += breakBrickRoutine(columnTest[i], shotNum+1);
				max = Math.max(max, testResult[i]);
			}
			return max;
		}
	}
	
	static int[][][] copyBrickMap(int[][] brickMap) {
		// 주어진 배열을 열의 개수만큼 복사하여
		// 3차원 배열에 할당하여 반환한다.
		int[][][] copiedBrickMap = new int[W][H][W];
		
		for (int i=0; i<W; i++) {
			for (int j=0; j<H; j++) {
				copiedBrickMap[i][j] = Arrays.copyOf(brickMap[j], W);;
			}
		}
		
		return copiedBrickMap;
	}
	
	static int breakTest(int[][] brickMap, int col) {
		// 주어진 배열의 한 열에 대해 가장 위 벽돌깨기를 진행하고 
		// 깬 벽돌 개수를 반환한다.
		int brokenBrickCnt = 0;
		
		for (int r=0; r<H; r++) {
			if (brickMap[r][col] == 0) continue;
			else {
				brokenBrickCnt = breakBrick(brickMap, r, col, brickMap[r][col]);
				break;
			}					
		}
		
		return brokenBrickCnt;
	}
	
	static int breakBrick(int[][] brickMap, int row, int col, int brickInfluence) {
		// 깨뜨린 벽돌
		brickMap[row][col] = 0;
		int brokenBrickCnt = 1;
		
		int delta = brickInfluence-1;
		
		// 세로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int r=row-delta; r<=row+delta; r++) {
			if (r >= 0 && r < H && r != row) {
				if (brickMap[r][col] != 0) { 
					brokenBrickCnt += breakBrick(brickMap, r, col, brickMap[r][col]);
				}				
			}		
		}
		
		// 가로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int c=col-delta; c<=col+delta; c++) {
			if (c >= 0 && c < W && c != col) {
				if (brickMap[row][c] != 0) { 
					brokenBrickCnt += breakBrick(brickMap, row, c, brickMap[row][c]);
				}
			}
		}
		
		return brokenBrickCnt;
	}
	
	public static void organizeMap(int[][] brickMap) {
		// 각 열에 대해 제일 아래 행부터 올라오면서 0을 만날때마다 
		// 그 위의 0이 아닌 값과 자리를 바꾼다.
		for (int c=0; c<W; c++) {
			for (int r=H-1; r>=1; r--) {
				if (brickMap[r][c] == 0) {
					for (int rr=r-1; rr>=0; rr--) {
						if (brickMap[rr][c] != 0) {
							int temp = brickMap[r][c];
							brickMap[r][c] = brickMap[rr][c];
							brickMap[rr][c] = temp;
							break;
						}
					}
				}
			}
		}
	}
	
	
}
