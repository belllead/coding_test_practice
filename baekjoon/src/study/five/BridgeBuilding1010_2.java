package study.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BridgeBuilding1010_2 {

	static int N, M;
	static int[] east = new int[M];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			build(1, 1);
			sb.append(cnt + "\n");
			cnt = 0;
		}
		System.out.println(sb);
	}
	
	static void build(int idx, int start) {
		if (idx > N) {
			cnt++;
			return;
		}
		
		for (int i=start; i<=M-N+idx; i++) {
			build(idx+1, i+1);	
		}
	}
	
}
