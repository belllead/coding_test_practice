package study.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class VirusLab14502 {

	static int N, M, max = 0;
	static int[][] lab;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static ArrayList<int[]> virusCoord = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				// 바이러스 좌표 저장
				if (lab[r][c] == 2) 
					virusCoord.add(new int[] {r, c});
			}
		}
		
//		for (int[] virus : virusCoord)
//			System.out.println(Arrays.toString(virus));
//		
//		for (int[] i : lab)
//			System.out.println(Arrays.toString(i));
//		System.out.println();
//				
//		System.out.println(checkSafeArea());
		
		setUpWalls(0);
		System.out.println(max);
		
	}
	
	// 벽 3개를 세울 수 있는 모든 경우의 수를 만든 다음
	// 가장 바이러스를 많이 막은 경우의 수 찾아서 max 변수에 저장
	static void setUpWalls(int n) {
		// 기저조건
		if (n == 3) {
			// 멤버 변수로부터 지역변수로 복사
			// 여러번 테스트하기 위함
			int[][] testLab = new int[N][M];
			for (int r=0; r<N; r++)
				testLab[r] = Arrays.copyOf(lab[r], M);
			
//			for (int[] i : testLab)
//				System.out.println(Arrays.toString(i));
//			System.out.println();
			
			boolean[][] visited = new boolean[N][M];
			
			// 저장된 바이러스 진원지부터 전염 구현
			for (int[] virus : virusCoord)
				bfs(virus, testLab, visited);
			
//			if (max < checkSafeArea(testLab)) {
//				for (int[] i : testLab)
//					System.out.println(Arrays.toString(i));
//				System.out.println(max);
//					
//				max = Math.max(max, checkSafeArea(testLab));
//			}
			
			// 안전한 구역이 가장 많이 남은 경우 저장
			max = Math.max(max, checkSafeArea(testLab));
			return;
			
		}
			
		// 유도
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
	
	static void bfs(int[] coord, int[][] lab, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(coord);
		visited[coord[0]][coord[1]] = true;
		
		while (!q.isEmpty()) {
			int[] tempCoord = q.poll();
			lab[tempCoord[0]][tempCoord[1]] = 2;
			
			for (int i=0; i<4; i++) {
				int tr = tempCoord[0] + dr[i];
				int tc = tempCoord[1] + dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
					if (lab[tr][tc] == 0 && !visited[tr][tc]) {
						int[] temp = {tr, tc};
						q.offer(temp);
						visited[tr][tc] = true;
					}
				}
			}
		}
	}
	
	static int checkSafeArea(int[][] lab) {
		int cnt = 0;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (lab[r][c] == 0)
					cnt++;
			}
		}
		
		return cnt;
	}
	
}




















