package d3;

import java.util.Scanner;

public class OmokReferee {
	static String[][] field;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			field = new String[N][N];
			
			for (int r=0; r<N; r++) {
				field[r] = sc.next().split("");
			}
			
			String s = "NO";
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (r + 4 < N && c + 4 < N && checkFive(r, c)) {
						s = "YES";
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + s);
		}
		sc.close();
	}
	
	static boolean checkFive(int startRow, int startCol) {
		String[][] fiveField = new String[5][5];
		
		for (int r=0; r<5; r++) {
			for (int c=0; c<5; c++) {
				fiveField[r][c] = field[startRow + r][startCol + c];
			}
		}
				
		// 행 검사
		for (int r=0; r<5; r++) {
			StringBuilder sbR = new StringBuilder();
			for (int c=0; c<5; c++) {
				sbR.append(fiveField[r][c]);
				if (sbR.toString().equals("ooooo"))
					return true;
			}
		}
		
		// 열 검사
		for (int c=0; c<5; c++) {
			StringBuilder sbC = new StringBuilder();
			for (int r=0; r<5; r++) {
				sbC.append(fiveField[r][c]);
				if (sbC.toString().equals("ooooo"))
					return true;
			}
		}
		
		// 대각선 검사
		StringBuilder sbD1 = new StringBuilder();
		for (int i=0; i<5; i++) {
			sbD1.append(fiveField[i][i]);
			if (sbD1.toString().equals("ooooo"))
				return true;
		}
		
		StringBuilder sbD2 = new StringBuilder();
		for (int i=0; i<5; i++) {
			sbD2.append(fiveField[i][4-i]);
			if (sbD2.toString().equals("ooooo"))
				return true;
		}
		
		return false;			
	}
	
}
