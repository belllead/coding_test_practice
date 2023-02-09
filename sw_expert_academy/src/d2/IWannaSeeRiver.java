package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IWannaSeeRiver {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int floor = 0;
				
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[][] town = new int[256][N];
			
			
			for (int c=0; c<N; c++) {
				floor = Integer.parseInt(st.nextToken());
				for (int r=0; r<=floor; r++) {
					town[r][c] = 1;
				}
			}
			
			int cnt = 0;
			
			for (int r=0; r<=255; r++) {
				for (int c=2; c<N-1; c++) {
					if (town[r][c] == 1) {
						if (town[r][c-1] == 0 && town[r][c-2] == 0 && town[r][c+1] == 0 && town[r][c+2] == 0) {
							cnt++;
						}
					}
				}
			}
								
			sb.append("#" + tc + " ").append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
