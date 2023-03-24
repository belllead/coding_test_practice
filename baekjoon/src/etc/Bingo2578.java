package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bingo2578 {

	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 }, dc = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int[][] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] bingo = new int[5][5];

		Map<Integer, int[]> map = new HashMap<>();

		for (int r = 0; r < 5; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				int t = Integer.parseInt(st.nextToken());
				bingo[r][c] = t;
				map.put(t, new int[] { r, c });
			}
		}

		int[] call = new int[25];
		int callIdx = 0;

		for (int r = 0; r < 5; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				call[callIdx++] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(Arrays.toString(call));

		checked = new int[5][5];
		for (int i=0; i<25; i++) {
			int row = map.get(call[i])[0];
			int col = map.get(call[i])[1];
			System.out.println("bingo: " + check(row, col));

			if (check(row, col) == 3) {
				System.out.println(i+1);
				
				for (int[] tt : checked)
					System.out.println(Arrays.toString(tt));
			}
			
			System.out.println();
		}

	}

	static int check(int row, int col) {
		System.out.println("row: " + row);
		System.out.println("col: " + col);
		
		int bingo = 0;

		checked[row][col] = 1;

		boolean flag = true;

		// 같은 열
		for (int r = 0; r < 5; r++) {
			if (checked[r][col] == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(1);
			bingo++;
		}

		flag = true;

		// 같은 행
		for (int c = 0; c < 5; c++) {
			if (checked[row][c] == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(2);
			bingo++;
		}

		// 우하 대각선
		if (!(row == 0 && col == 4) && !(row == 4 && col == 0)) {
			flag = true;
			
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (c - r == col - row) {
						if (checked[r][c] == 0) {
							flag = false;
							break;
						}
					}
				}
			}
			if (flag) {
				System.out.println(3);
				bingo++;
			}
		}

		// 우상 대각선
		if (!(row == 0 && col == 4) && !(row == 4 && col == 0)) {
			flag = true;
			
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (c + r == col + row) {
						if (checked[r][c] == 0) {
							flag = false;
							break;
						}
					}
				}
			}
			if (flag) {
				System.out.println(4);
				bingo++;
			}
		}

		return bingo;
	}
}
