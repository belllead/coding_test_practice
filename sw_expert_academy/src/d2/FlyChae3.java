package d2;

import java.util.Scanner;

public class FlyChae3 {
	static int T, N, M, max, cnt1, cnt2, crossR, crossC, xR, xC, ans;
	static int[][] floor;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			floor = new int[N][N];
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					floor[r][c] = sc.nextInt();
				}
			}
			
			ans = 0;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					ans = Math.max(ans, spray(r, c));
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
	
	static int spray(int row, int col) {
		int[] crossDr = {-1, 1, 0, 0};
		int[] crossDc = {0, 0, -1, 1};
		
		int[] xDr = {-1, -1, 1, 1};
		int[] xDc = {-1, 1, -1, 1};
		
		max = 0;
		cnt1 = floor[row][col];
		cnt2 = floor[row][col];
		
		for (int i=0; i<4; i++) {
			for (int j=1; j<M; j++) {
				
				crossR = row + crossDr[i]*j;
				crossC = col + crossDc[i]*j;
								
				xR = row + xDr[i]*j;
				xC = col + xDc[i]*j;
				
				if (crossR >= 0 && crossR < N && crossC >=0 && crossC < N)
					cnt1 += floor[crossR][crossC];
				
				if (xR >= 0 && xR < N && xC >=0 && xC < N)
					cnt2 += floor[xR][xC];
			}
		}
		max = Math.max(cnt1, cnt2);
		
		return max;
	}
}
