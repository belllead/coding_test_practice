package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BreakBrick {
	static int T, N, W, H, brokenBrickCnt, initialBrickCnt, maxBreak;
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
					if (brickMap[r][c] != 0) 
						initialBrickCnt++;
				}
			}
			
			maxBreak = 0;
			
			sb.append("#" + tc + " ");
			
			
			breakBreakRoutine(brickMap, 0, 1);
			
			System.out.println(initialBrickCnt);
			System.out.println(maxBreak);
			sb.append(initialBrickCnt - maxBreak);
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int breakBreakRoutine(int[][] brickMap, int extendedBrokenBrickCnt, int shot) {
		int[][][] brickMaps = new int[W][H][W];
				
		for (int c=0; c<W; c++) {
			// 열의 개수만큼 brickMap을 만들어준다.
			brickMaps[c] = brickMap;
			
			System.out.println();
			System.out.println();
			System.out.println("column: " + c);
			brokenBrickCnt = extendedBrokenBrickCnt;
			int shotNum = shot;
			// 각 열의 가장 위에 있는 벽돌과 그것이 영향을 주는 벽돌을 깬다.
			for (int r=0; r<W; r++) {
				if (brickMaps[c][r][c] == 0) continue;
				else {
					breakBrick(brickMaps[c], r, c, brickMaps[c][r][c]);
					System.out.print("A: " + brokenBrickCnt + " ");
					break;
				}					
			}
			if (shotNum == N) 
				maxBreak = Math.max(maxBreak, brokenBrickCnt);
			else {
				// 벽돌이 깨진 빈 자리를 채운다.
				organizeMap(brickMaps[c]);
				// 각 테스트에 대해 루틴을 한 번 더 진행한다.
				System.out.println();
				System.out.print(brokenBrickCnt + " ");
				System.out.println();
				breakBreakRoutine(brickMaps[c], brokenBrickCnt, shotNum+1);
			}
		}
		System.out.println();
		System.out.println("return: " + maxBreak);
		return maxBreak;
	}
	
	public static void breakBrick(int[][] brickMap, int row, int col, int brickInfluence) {
		// 깨뜨린 벽돌
		brickMap[row][col] = 0;
		brokenBrickCnt++;
		
		int delta = brickInfluence-1;
		
		// 세로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int r=row-delta; r<=row+delta; r++) {
			if (r >= 0 && r < H && r != row) {
				if (brickMap[r][col] != 0) 
					breakBrick(brickMap, r, col, brickMap[r][col]);
			}		
		}
		
		// 가로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int c=col-delta; c<=col+delta; c++) {
			if (c >= 0 && c < W && c != col) {
				if (brickMap[row][c] != 0) 
					breakBrick(brickMap, row, c, brickMap[row][c]);
			}
		}
		
		
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
