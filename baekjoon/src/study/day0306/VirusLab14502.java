package study.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class VirusLab14502 {

	static int N, M;
	static int[][] lab; 
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static ArrayList<int[]> virusCoord = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				if (lab[r][c] == 2) 
					virusCoord.add(new int[] {r, c});
			}
		}
		
		setUpWalls(0);
		
		
	}
	
	static void setUpWalls(int n) {
		if (n == 3) {
			for (int[] virus : virusCoord) {
				bfs(virus);
			}
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					System.out.print(lab[r][c]);
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.println(checkSafeArea());
			return;
			
		}
			
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (lab[r][c] == 0) {
					lab[r][c] = 1;
					setUpWalls(n + 1);
					lab[r][c] = 0;
				}				
			}
		}
	}
	
	static void bfs(int[] coord) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(coord);
		visited[coord[0]][coord[1]] = true;
		
		while (!q.isEmpty()) {
			int[] tempCoord = q.poll();
			lab[tempCoord[0]][tempCoord[1]] = 2;
			
			for (int i=0; i<4; i++) {
				int tr = tempCoord[0] + dr[i];
				int tc = tempCoord[1] + dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N) {
					if (lab[tr][tc] == 0 && !visited[tr][tc]) {
						int[] temp = {tr, tc};
						q.offer(temp);
						visited[tr][tc] = true;
					}
				}
			}
		}
	}
	
	static int checkSafeArea() {
		int cnt = 0;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (lab[r][c] == 0)
					cnt++;
			}
		}
		
		return cnt;
	}
	
}




















