package study.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeRunner2178_2 {
	static int[][] maze;
	static int N, M, runCnt;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		
		
		for (int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				maze[i][j] = temp[j] - '0';
			}			
		}
		
		bfs(0, 0);

		System.out.println(runCnt);
		
	}
	
	// bfs를 실행했을 때 가장 먼저 타겟 좌표에 도달한 너비를 찾을 것
	// 큐를 활용하여 너비 별로 카운트를 해주면 처음 타겟 좌표가 나오는 것이 최단거리
	static void bfs(int r, int c) {
		Queue<int[]> bfs = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		// 시작점 입력
		bfs.offer(new int[] {r, c});
		visited[r][c] = true;
		
		// 모든 노드를 방문할 때까지 반복
		while (!bfs.isEmpty()) {
			// 너비가 증가할 때마다 이동횟수를 늘리기 위해
			// size()로 너비 구분
			int size = bfs.size();
			runCnt++;
			
			// 하나의 너비가 소모될 때까지 반복
			while (--size >= 0) {
				// 큐 제일 앞에 좌표 꺼내기
				int[] temp = bfs.poll();
				int row = temp[0];
				int col = temp[1];
				
				// 꺼낸 좌표가 타겟좌표이면 탐색 종료
				if (row == N - 1 && col == M - 1)
					return;
				
				// 꺼낸 좌표에서 이어 갈 수 있는 좌표 판단해서
				// 큐에 추가 후 방문 표시
				for (int i=0; i<4; i++) {
					int tr = row + dr[i];
					int tc = col + dc[i];
					
					if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
						if (maze[tr][tc] == 1 && !visited[tr][tc]) {
							bfs.offer(new int[] {tr, tc});
							visited[tr][tc] = true;
						}					
					}
				}
			}	
		}
	}
	
	
		
		
			
}


























