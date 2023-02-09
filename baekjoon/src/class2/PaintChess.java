package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintChess {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] pallete = new String[N][M];
		
		for (int r=0; r<N; r++) {
			String s = br.readLine();
			for (int c=0; c<M; c++) {
				pallete[r][c] = s.substring(c, c+1);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				for (int r=i; r<i+8; r++) {
					for (int c=j; c<j+8; c++) {
						System.out.print(pallete[r][c]);
						int cnt = 0;
						pallete[i][j] = "W";
						if (r % 2 == 1 && c % 2 == 1) { 
							if (pallete[r][c].equals("W")) {
								pallete[r][c] = "B";
								cnt++;
							}
						}
						if (r % 2 == 0 && c % 2 == 0) {
							if (pallete[r][c].equals("B")) {
								pallete[r][c] = "W";
								cnt++;
							}
						}
						min = Math.min(min, cnt);
						cnt = 0;
						
						pallete[i][j] = "B";
						if (r % 2 == 1 && c % 2 == 1) { 
							if (pallete[r][c].equals("B")) {
								pallete[r][c] = "W";
								cnt++;
							}
						}
						if (r % 2 == 0 && c % 2 == 0) {
							if (pallete[r][c].equals("W")) {
								pallete[r][c] = "B";
								cnt++;
							}
						} min = Math.min(min, cnt);
						cnt = 0;
						
					}
					System.out.println();
				}
				System.out.println(min);
//				System.out.println(i +" " + j);
			}			
		}
		
		
		
		
	}
}
