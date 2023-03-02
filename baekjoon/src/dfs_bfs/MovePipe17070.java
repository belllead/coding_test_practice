package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MovePipe17070 {

	static class Pipe {
		int state; // 가로 세로 대각선 표시 0, 1, 2
		int[] start;
		int[] space1;
		int[] space2;
		int[] end;
		
		public Pipe(int state, int[] start, int[] space1, int[] space2, int[] end) {
			super();
			this.state = state;
			this.start = start;
			this.space1 = space1;
			this.space2 = space2;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Pipe [state=" + state + ", start=" + Arrays.toString(start) + ", space1=" + Arrays.toString(space1)
					+ ", space2=" + Arrays.toString(space2) + ", end=" + Arrays.toString(end) + "]";
		}
		
		
	}
	
	static int[][] house;
	static int N, cnt;
	static Pipe pipe;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		
		for (int r=1; r<N+1; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=1; c<N+1; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r=0; r<N+1; r++) {
			for (int c=0; c<N+1; c++) {
				System.out.print(house[r][c]);
			}
			System.out.println();
		}
		
		pipe = new Pipe(0, new int[] {1,1}, null, null, new int[] {1,2});
		
		dfs(pipe);
		
		System.out.println(cnt);
		
	}
	
	static void dfs(Pipe pipe) {
		System.out.println(pipe.toString());
		if (pipe.end[0] > N || pipe.end[1] > N)
			return;
		
		if (pipe.state == 2 && house[pipe.space1[0]][pipe.space1[1]] == 1)
			return;
		
		if (pipe.state == 2 && house[pipe.space2[0]][pipe.space2[1]] == 1)
			return;
		
		if (house[pipe.end[0]][pipe.end[1]] == 1)
			return;
		
		if (pipe.end[0] == N && pipe.end[1] == N) {
			cnt++;
			return;
		}
		
		if (pipe.state == 0) {
			Pipe temp = pipe;
			dfs(moveRight(pipe));
			dfs(moveDiag(temp));
		} else if (pipe.state == 1) {
			dfs(moveDown(pipe));
			dfs(moveDiag(pipe));
		} else {
			dfs(moveRight(pipe));
			dfs(moveDown(pipe));
			dfs(moveDiag(pipe));
		}
	}
	
	static Pipe moveRight(Pipe pipe) {
		if (pipe.state == 0) {
			pipe.start[1]++;
			pipe.end[1]++;
		} else if (pipe.state == 2) {
			pipe.start[0]++;
			pipe.start[1]++;
			pipe.space1 = pipe.space2 = null;
			pipe.end[1]++;
		} else {
			System.out.println("wrong call");
		}
		return pipe;
	}
	
	static Pipe moveDown(Pipe pipe) {
		if (pipe.state == 1) {
			pipe.start[0]++;
			pipe.end[0]++;
		} else if (pipe.state == 2) {
			pipe.start[0]++;
			pipe.start[1]++;
			pipe.space1 = pipe.space2 = null;
			pipe.end[0]++;
		} else {
			System.out.println("wrong call");
		}
		return pipe;
	}
	
	static Pipe moveDiag(Pipe pipe) {
		if (pipe.state == 0) {
			pipe.start[1]++;
			pipe.space1 = new int[] {pipe.start[0], pipe.start[1]+2};
			pipe.space2 = new int[] {pipe.start[0]+1, pipe.start[1]+1};
			pipe.end[0]++;
			pipe.end[1]++;
		} else if (pipe.state == 1) {
			pipe.start[0]++;
			pipe.space1 = new int[] {pipe.start[0]+1, pipe.start[1]+1};
			pipe.space2 = new int[] {pipe.start[0], pipe.start[1]+2};
			pipe.end[0]++;
			pipe.end[1]++;
		} else {
			pipe.start[0]++;
			pipe.start[1]++;
			pipe.space1 = new int[] {pipe.start[0]+1, pipe.start[1]+1};
			pipe.space2 = new int[] {pipe.start[0]+1, pipe.start[1]+1};
			pipe.end[0]++;
			pipe.end[1]++;
		}
		return pipe;
	}
	
	
}





















