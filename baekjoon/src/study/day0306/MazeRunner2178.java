package study.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MazeRunner2178 {
	static char[][] maze;
	static byte[][] visit;
	static int N, M, runCnt;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static List<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		visit = new byte[N][M];
		
		for (int i=0; i<N; i++) {
			maze[i] = br.readLine().toCharArray();			
		}
		
		run(0, 0);
		
		System.out.println(ans.toString());

		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				System.out.print(visit[r][c]);
			}
			System.out.println();
		}
	}
	
	static void run(int r, int c) {
		visit[r][c] = 1;
		runCnt++;
		
		if (r == N - 1 && c == M - 1) {
			ans.add(runCnt);
			return;
		}
		
		for (int i=0; i<4; i++) {
			int tr = r + dr[i];
			int tc = c + dc[i];
			
			if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
				if (maze[tr][tc] == '1' && visit[tr][tc] == 0) {
					run(tr, tc);
				}					
			}
		}
		
	
	}
}
