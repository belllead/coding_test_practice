package study.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight7562 {

	static int l;
	static int[][] chess;
	static int[] curCoord, tarCoord;
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2}, dc = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			l = Integer.parseInt(br.readLine());
			chess = new int[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			curCoord = new int[2];
			curCoord[0] = Integer.parseInt(st.nextToken());
			curCoord[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			tarCoord = new int[2];
			tarCoord[0] = Integer.parseInt(st.nextToken());
			tarCoord[1] = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(curCoord) + "\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int[] coord) {
		if (coord[0] == tarCoord[0] && coord[1] == tarCoord[1])
			return 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[l][l];
		
		q.offer(coord);
		visited[coord[0]][coord[1]] = true;
		
		int cnt = 0;
		
		while (!(q.isEmpty())) {
			int size = q.size();
			cnt++;

			while (--size >= 0) {
				int[] tmpCoord = q.poll();
				
				for (int i=0; i<8; i++) {
					int tr = tmpCoord[0];
					int tc = tmpCoord[1];
					
					tr += dr[i];
					tc += dc[i];
					
					if (tr == tarCoord[0] && tc == tarCoord[1])
						return cnt;
					
					if (tr >= 0 && tr < l && tc >= 0 && tc < l && !visited[tr][tc]) {
						q.offer(new int[] {tr, tc});
						visited[tr][tc] = true;
					}				
				}
			}
			
		}
		
		return 0;
	}
}
