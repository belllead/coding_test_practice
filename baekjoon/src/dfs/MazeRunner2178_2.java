package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class MazeRunner2178_2 {
	static int[][] maze;
	static byte[][] visit;
	static int N, M, runCnt;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static List<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		visit = new byte[N][M];
		
		char[] temp = br.readLine().toCharArray();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				maze[i][j] = temp[i] - '0';
			}			
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
		Stack<int[]> dfs = new Stack<>();
		
		int[] curr = {r, c};
		dfs.push(curr);
		
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
