package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RussianFlag {
	static char[][] flag;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flag = new char[N][M];
			for (int i=0; i<N; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					System.out.print(flag[i][j]);
				}
				System.out.println();
			}
			
			// 각 줄 별 최소 칠한 횟수
			int[] cnt = new int[N];
			int temp = 0;
			
			// 첫 줄 W 처리
			for (int i=0; i<M; i++) {
				if (flag[0][i] == 'W')
					temp++;
			}
			cnt[0] = M - temp;
			temp = 0;

			// 마지막 줄 R 처리
			for (int i=0; i<M; i++) {
				if (flag[N-1][i] == 'R')
					temp++;
			}
			cnt[N-1] = M - temp;
			temp = 0;
			
			int totalPaint = N * M;
			// 중간 줄 처리
			for (int i=1; i<N-1; i++) {
				// B의 앞
				for (int j=1; j<i; j++) {
					cnt[j] = colorLine(flag[j], "WB");
				}
				
				// 중간 B 줄
				for (int j=0; j<M; j++) {
					if (flag[i][j] == 'B')
						temp++;
				}
				cnt[i] = M - temp;
				temp = 0;
				
				// B의 뒤
				for (int j=i+1; j<N-1; j++) {
					cnt[j] = colorLine(flag[j], "BR");
				}
				
				int sum = 0;
				
				for (int j=0; j<N; j++)
					sum += cnt[j];
				
				totalPaint = Math.min(totalPaint, sum);
				System.out.println(Arrays.toString(cnt));
				System.out.println(totalPaint);
			}
			
			sb.append("#" + tc + " " + totalPaint + "\n");
		}
		System.out.println(sb);
	}
	
	static int colorLine(char[] line, String color) {
		int[] cnt = new int[2];
		int minPaint = M;
				
		// W B
		if (color.equals("WB")) {
			for (int i=0; i<M; i++) {
				if (line[i] == 'W') {
					cnt[0]++;
				} else if (line[i] == 'B') {
					cnt[1]++;
				}
			}
			
			minPaint = (cnt[0] > cnt[1])? (M - cnt[0]) : (M - cnt[1]);
		}
		
		// B R		
		else if (color.equals("BR")) {
			for (int i=0; i<M; i++) {
				if (line[i] == 'B') {
					cnt[0]++;
				} else if (line[i] == 'R') {
					cnt[1]++;
				}
			}
			
			minPaint = (cnt[0] > cnt[1])? (M - cnt[0]) : (M - cnt[1]);
		}
		
		return minPaint;
	}
	
}
