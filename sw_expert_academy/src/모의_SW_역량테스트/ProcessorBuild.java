package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProcessorBuild {

	static int[][] chip;
	static boolean[][] visited;
	static int N, linkedCoreCnt, coreCnt;
	static ArrayList<int[]> coreCoord = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			chip = new int[N][N];
			visited = new boolean[N][N];
			
			for (int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					chip[r][c] = Integer.parseInt(st.nextToken());
					if (chip[r][c] == 1) {
						coreCnt++;
						visited[r][c] = true;
						if (r == 0 || r == N-1 || c == 0 || c == N-1) {
							linkedCoreCnt++;
							coreCnt--;
						} else {
							coreCoord.add(new int[] {r, c});
						}
					}
					
				}
			}
			
			System.out.println(coreCnt);
			System.out.println(coreCoord.toString());
			
			for (int[] a : chip)
				System.out.println(Arrays.toString(a));
			System.out.println(); 
			
			for (boolean[] a : visited)
				System.out.println(Arrays.toString(a));
			
			
			
			System.out.println(linkedCoreCnt);
		}
	}
	
	// n개의 코어를 연결
	static void linkCore(int n) {
		if (n == coreCoord.size())
			return;
		
		int[] coord = coreCoord.get(n);
			
		linkUp(coord);
		linkCore(n+1);
		
		linkDown(coord);
		
		linkLeft(coord);
		
		linkRight(coord);
		
		
	}

	private static void linkRight(int[] c) {
		// TODO Auto-generated method stub
		
	}

	private static void linkLeft(int[] c) {
		// TODO Auto-generated method stub
		
	}

	private static void linkDown(int[] c) {
		// TODO Auto-generated method stub
		
	}

	private static void linkUp(int[] c) {
		// TODO Auto-generated method stub
		
	}

	
}

























