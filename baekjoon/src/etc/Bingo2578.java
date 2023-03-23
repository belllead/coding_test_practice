package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bingo2578 {
	
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}, dc = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] bingo = new int[5][5];
		int[][] checked = new int[5][5];

		for (int r=0; r<5; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<5; c++) {
				bingo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] call = new int[25];
		int callIdx = 0;
		
		for (int r=0; r<5; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<5; c++) {
				call[callIdx++] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	static boolean check(int row, int col) {
		for (int i=0; i<8; i++) {
			int tr = row + dr[i];
			int tc = col + dc[i];
			
			
		}
		
		
		return false;
	}
}










