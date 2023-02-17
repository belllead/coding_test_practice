package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PinBall {
	static int score, currentR, currentC, N;
	static int[] currentDirection;
	static int[][] ballDirection = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] board, wormHole6, wormHole7, wormHole8, wormHole9, wormHole10;
	
	public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new FileReader("test_case/test.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N+2][N+2];
			
			int ans = 0;
			
			List<int[]> possibleStartPosition = new ArrayList<>();
			wormHole6 = new int[2][2];
			wormHole7 = new int[2][2];
			wormHole8 = new int[2][2];
			wormHole9 = new int[2][2];
			wormHole10 = new int[2][2];			
						
			for (int r=1; r<N+1; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=1; c<N+1; c++) {
					board[r][c] = Integer.parseInt(st.nextToken());
					
					// 가능한 시작 위치 체크
					if (board[r][c] == 0) {
						int[] temp = {r, c};
						possibleStartPosition.add(temp);
					}
					
					// 웜홀 입력
					switch (board[r][c]) {
					case 6:
//						System.out.println(board[r][c]);
						if (wormHole6[0][0] == 0)
							wormHole6[0] = new int[] {r, c};
						else 
							wormHole6[1] = new int[] {r, c};
						break;
					case 7:
						if (wormHole7[0][0] == 0)
							wormHole7[0] = new int[] {r, c};
						else 
							wormHole7[1] = new int[] {r, c};
						break;
					case 8:
						if (wormHole8[0][0] == 0)
							wormHole8[0] = new int[] {r, c};
						else 
							wormHole8[1] = new int[] {r, c};
						break;
					case 9:
						if (wormHole9[0][0] == 0)
							wormHole9[0] = new int[] {r, c};
						else 
							wormHole9[1] = new int[] {r, c};
						break;
					case 10:
						if (wormHole10[0][0] == 0)
							wormHole10[0] = new int[] {r, c};
						else 
							wormHole10[1] = new int[] {r, c};
					}	
				}	
			}
			
//			System.out.println(tc);
			
			for (int i=0; i<possibleStartPosition.size(); i++) {
//				System.out.println("0. startR,	 C: " + possibleStartPosition.get(i)[0] + " " + possibleStartPosition.get(i)[1]);
				int tempMax = playPinBall(possibleStartPosition.get(i)[0], possibleStartPosition.get(i)[1]);
				ans = Math.max(ans, tempMax);
			}
			
			
//			ans = playPinBall(9, 3);
			
//			System.out.println(ans);
			sb.append("#" + tc + " " + ans + "\n");
			
			// 출력 검사
//			for (int r=0; r<N+2; r++) {
//				for (int c=0; c<N+2; c++) {
//					System.out.print(board[r][c]);
//				}								
//				System.out.println();
//			}
//			
//			for (int i=0; i<possibleStartPosition.size(); i++) {
//				System.out.println(Arrays.toString(possibleStartPosition.get(i)) + " ");
//			}
//			System.out.println(possibleStartPosition.size());
//			System.out.println();
			
//			for (int i=0; i<2; i++) {
//				System.out.print(Arrays.toString(wormHole6[i]) + " ");
//				System.out.print(Arrays.toString(wormHole7[i]) + " ");
//				System.out.print(Arrays.toString(wormHole8[i]) + " ");
//				System.out.print(Arrays.toString(wormHole9[i]) + " ");
//				System.out.print(Arrays.toString(wormHole10[i]) + " ");
//			}
		}
		System.out.println(sb);		
		br.close();
	}

	private static int playPinBall(int startR, int startC) {
		int max = 0;
		currentR = startR;
		currentC = startC;
		
		for (int startDirection=0; startDirection<4; startDirection++) {
			score = 0;
			
			currentDirection = ballDirection[startDirection];
//			System.out.println("startDirection: " + currentDirection[0] + " " + currentDirection[1]);
			
			while (board[currentR][currentC] != -1) {
//				System.out.println("1. currentR, C: " + currentR + " " + currentC);
				currentR += currentDirection[0];
				currentC += currentDirection[1];
//				System.out.println("1. currentDirection: " + currentDirection[0] + " " + currentDirection[1]);
//				System.out.println("2. currentR, C: " + currentR + " " + currentC);
//				System.out.println("3. board[currentR][currentC]" + " " + board[currentR][currentC]);
				switch (board[currentR][currentC]) {
				case 1:
					block(1);
					break;
				case 2:
					block(2);
					break;
				case 3:
					block(3);
					break;
				case 4:
					block(4);
					break;
				case 5:
					block(5);
					break;
				case 6:
					wormhole(6);
					break;
				case 7:
					wormhole(7);
					break;
				case 8:
					wormhole(8);
					break;
				case 9:
					wormhole(9);
					break;
				case 10:
					wormhole(10);
					break;
				}
				
				if (currentC == 0)
					wall("left wall");
				else if (currentC == N+1)
					wall("right wall");
				else if (currentR == 0)
					wall("top wall");
				else if (currentR == N+1)
					wall("bottom wall");
				
				if (currentR == startR && currentC == startC)
					 break;
			}	
			

			// 각 방향으로 시작한 핀볼 경우의 수 중 가장 큰 점수를 저장한다.
			max = Math.max(max, score);
//			System.out.println("max: " + max);
		}
		
		return max;
	}

	private static void block(int i) {
		switch (i) {
		case 1:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		case 2:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		case 3:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[2];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[1];
			score++;
			break;
		case 4:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[2];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[0];
			score++;
			break;
		case 5:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		}
	}
	
	private static void wall(String s) {
		switch (s) {
		case "left wall":
//			System.out.println("left wall");
			currentDirection = ballDirection[3];
			score++;
			break;
		case "right wall":
//			System.out.println("right wall");
			currentDirection = ballDirection[2];
			score++;
			break;
		case "top wall":
//			System.out.println("top wall");
			currentDirection = ballDirection[1];
			score++;
			break;
		case "bottom wall":
//			System.out.println("bottom wall");
			currentDirection = ballDirection[0];
			score++;
			break;
		}
		
	}
	
	private static void wormhole(int i) {
		switch (i) {
		case 6:
			 if (currentR == wormHole6[0][0] && currentC == wormHole6[0][1]) {
				 currentR = wormHole6[1][0];
				 currentC = wormHole6[1][1];
			 } else if (currentR == wormHole6[1][0] && currentC == wormHole6[1][1]) {
				 currentR = wormHole6[0][0];
				 currentC = wormHole6[0][1];
			 }
			 break;
		case 7:
			 if (currentR == wormHole7[0][0] && currentC == wormHole7[0][1]) {
				 currentR = wormHole7[1][0];
				 currentC = wormHole7[1][1];
			 } else if (currentR == wormHole7[1][0] && currentC == wormHole7[1][1]) {
				 currentR = wormHole7[0][0];
				 currentC = wormHole7[0][1];
			 }
			 break;
		case 8:
			 if (currentR == wormHole8[0][0] && currentC == wormHole8[0][1]) {
				 currentR = wormHole8[1][0];
				 currentC = wormHole8[1][1];
			 } else if (currentR == wormHole8[1][0] && currentC == wormHole8[1][1]) {
				 currentR = wormHole8[0][0];
				 currentC = wormHole8[0][1];
			 }
			 break;
		case 9:
			 if (currentR == wormHole9[0][0] && currentC == wormHole9[0][1]) {
				 currentR = wormHole9[1][0];
				 currentC = wormHole9[1][1];
			 } else if (currentR == wormHole9[1][0] && currentC == wormHole9[1][1]) {
				 currentR = wormHole9[0][0];
				 currentC = wormHole9[0][1];
			 }
			 break;
		case 10:
			 if (currentR == wormHole10[0][0] && currentC == wormHole10[0][1]) {
				 currentR = wormHole10[1][0];
				 currentC = wormHole10[1][1];
			 } else if (currentR == wormHole10[1][0] && currentC == wormHole10[1][1]) {
				 currentR = wormHole10[0][0];
				 currentC = wormHole10[0][1];
			 }
			 break;
		}		
	}
	
	
}
