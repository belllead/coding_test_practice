package study.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BridgeBuilding1010 {

	static int N, M;
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(build(M, N) + "\n");
		}
		System.out.println(sb);
	}
	
	static int build(int n, int r) {
		if (dp[n][r] > 0)
			return dp[n][r];
		
		if (n == r || r == 0)
			return 1;
		
		dp[n][r] = build(n-1, r-1) + build(n-1, r);
		return dp[n][r];
		
	}
	
}
